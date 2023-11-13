package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * BaseUrl: https://demo.nopcommerce.com/
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=
 * %2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */
public class MultiBrowserTesting {

    static String browser = "chrome";
    static String baeUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) {

        // 1. Setup Chrome browser.
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        }

        //2. Open URL.
        driver.get(baeUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3. Print the title of the page.
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        System.out.println("***************************************");

        // * 4. Print the current url.
        String url = driver.getCurrentUrl();
        System.out.println("Current url is: " + url);
        System.out.println("***************************************");

        // * 5. Print the page source.
        System.out.println("Page source is: " + driver.getPageSource());
        System.out.println("***************************************");

        // * 6. Navigate to Url.
        // * “https://demo.nopcommerce.com/login?returnUrl=
        // * %2F”
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=\n" +
                "%2F");

        // * 7. Print the current url.
        System.out.println("Current url is: " + driver.getCurrentUrl());
        System.out.println("***************************************");

        // * 8. Navigate back to the home page.
        driver.navigate().back();

        // * 9. Navigate to the login page.
        driver.navigate().forward();

        // * 10. Print the current url.
        System.out.println("Current Url is: " + driver.getCurrentUrl());
        System.out.println("***************************************");

        // * 11. Refresh the page.
        driver.navigate().refresh();

        // * 12. Enter the email to email field.
        driver.findElement(By.id("Email")).sendKeys("annusomayaji@gmail.com");

        // * 13. Enter the password to password field.
        driver.findElement(By.id("Password")).sendKeys("password1");

        // * 14. Click on Login Button.
        driver.findElement(By.linkText("Log in")).click();

        // * 15. Close the browser.
        driver.quit();

    }
}
