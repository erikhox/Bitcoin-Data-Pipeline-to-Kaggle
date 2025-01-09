import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            File file = new File("src/main/csv_files/" + "test1.csv.csv");
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile);
            String[] header = {"DateTime", "Price", "Bid", "Ask"};
            writer.writeNext(header);

            driver.get("https://bitcointicker.co/coinbase/btc/usd/10m/");

            ArrayList<LocalDateTime> times = new ArrayList<>();
            ArrayList<String> prices = new ArrayList<>();
            ArrayList<String> bids = new ArrayList<>();
            ArrayList<String> asks = new ArrayList<>();

            int i = 0;
            int previousMin = LocalDateTime.now().getMinute();
            while (i < 10) {
                int currentMin = LocalDateTime.now().getMinute();

                if (currentMin != previousMin) {
                    String time = LocalDateTime.now().withSecond(0).withNano(0).toString();
                    String price = driver.findElement(By.id("lastTrade")).getText();
                    String bid = driver.findElement(By.id("buy")).getText();
                    String ask = driver.findElement(By.id("sell")).getText();
                    prices.add(price);
                    times.add(LocalDateTime.now().withSecond(0).withNano(0));
                    bids.add(bid);
                    asks.add(ask);
                    String[] line = {time, price, bid, ask};
                    writer.writeNext(line);
                    previousMin = currentMin;
                    i++;
                    sleep(55000);
                }
                sleep(500);
            }
            driver.quit();
            writer.close();
            for (int j = 0; j < prices.size(); j++) {
                System.out.println("price: " + prices.get(j) + " -- time: " + times.get(j) + " -- ask: " + asks.get(j) + " -- bid: " + bids.get(j));
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            driver.quit();
        }
    }
}