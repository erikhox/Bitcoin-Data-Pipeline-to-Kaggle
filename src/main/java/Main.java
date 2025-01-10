import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        //installing and setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //creates the file, comment out if it already exists
        String name = "test";
        String filePath = "src/main/csv_files/" + name + ".csv";
        //createFile.create(name);

        try {
            //setting the link to scrape from
            driver.get("https://bitcointicker.co/coinbase/btc/usd/10m/");

            //setting up for CSV file modification
            FileWriter mFileWriter = new FileWriter(filePath, true);
            CSVWriter writer = new CSVWriter(mFileWriter);

            //setting the variables for the while loop
            int i = 0;
            int previousMin = LocalDateTime.now().getMinute();

            //main loop which scrapes the data every minute and writes to csv file
            while (i < 2) {
                int currentMin = LocalDateTime.now().getMinute();

                //checks if the minute changed
                if (currentMin != previousMin) {

                    //sets variables and scrapes data
                    String time = LocalDateTime.now().withSecond(0).withNano(0).toString();
                    String price = driver.findElement(By.id("lastTrade")).getText();
                    String bid = driver.findElement(By.id("buy")).getText();
                    String ask = driver.findElement(By.id("sell")).getText();

                    //writing the scraped data to the CSV file
                    String[] line = {time, price, bid, ask};
                    writer.writeNext(line);

                    //flushing the data to store to drive
                    writer.flush();

                    //updating the variables for the while loop
                    previousMin = currentMin;
                    i++;

                    //sleeping for 55 seconds to save computing power
                    sleep(55000);
                }
                //checking every 0.25 seconds if the minute updated
                sleep(250);
            }
            //closing up the chrome driver and CSV writer
            driver.quit();
            writer.close();

        //catching possible errors that can appear
        } catch (InterruptedException | IOException e) {
            System.out.println("Error with sleep()");
            driver.quit();
        }
    }
}