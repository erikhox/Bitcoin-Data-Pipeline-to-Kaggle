import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.time.LocalDateTime;
import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://bitcointicker.co/coinbase/btc/usd/10m/");

            ArrayList<String> prices = new ArrayList<>();
            ArrayList<LocalDateTime> times = new ArrayList<>();

            int i = 0;
            int previousMin = LocalDateTime.now().getMinute();
            while (i < 10) {
                int currentMin = LocalDateTime.now().getMinute();

                if (currentMin != previousMin) {
                    String price = driver.findElement(By.id("lastTrade")).getText();
                    prices.add(price);
                    times.add(LocalDateTime.now());
                    i++;
                }
                previousMin = currentMin;
                sleep(1000);
            }
            driver.quit();
            for (int j = 0; j < prices.size(); j++) {
                System.out.println("price: " + prices.get(j) + " -- time: " + times.get(j));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            driver.quit();
        }
    }
}