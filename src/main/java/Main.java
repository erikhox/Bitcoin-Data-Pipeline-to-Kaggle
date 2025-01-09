import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        //installing and setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //setting the path for where the CSV file should be created
        String path = "src/main/csv_files/";

        //setting the name for the CSV file
        String name = "test1.csv";

        try {
            //preparing the CSV file to be created and creating its header
            File file = new File(path + name);
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile);
            String[] header = {"DateTime", "Price", "Bid", "Ask"};
            writer.writeNext(header);

            //setting the link to scrape from
            driver.get("https://bitcointicker.co/coinbase/btc/usd/10m/");

            //setting the variables for the while loop
            int i = 0;
            int previousMin = LocalDateTime.now().getMinute();

            //main loop which scrapes the data every minute and writes to csv file
            while (i < 10) {
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
            System.out.println("Error with FileWriter() or sleep()");
            driver.quit();
        }
    }
}