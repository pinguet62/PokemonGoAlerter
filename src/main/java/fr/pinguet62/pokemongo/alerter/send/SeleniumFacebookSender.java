package fr.pinguet62.pokemongo.alerter.send;

import static java.io.File.createTempFile;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import fr.pinguet62.pokemongo.alerter.Message;

// @Component
public class SeleniumFacebookSender implements Sender {

    private static final Logger LOGGER = getLogger(SeleniumFacebookSender.class);

    private static void debug(WebDriver driver) {
        if (!LOGGER.isDebugEnabled())
            return;

        File file;
        try {
            file = createTempFile("pokemongo-", null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LOGGER.debug("Using temporary file: " + file);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            IOUtils.write(driver.getPageSource(), fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private WebDriver driver;

    @Value("${facebook.email}")
    private String email;

    @Value("${facebook.password}")
    private String password;

    @PostConstruct
    private void login() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Login
        driver.get("https://www.facebook.com");
        debug(driver);
        driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id=\"pass\"]")).sendKeys(password);
        driver.findElement(By.xpath("//label[@id=\"loginbutton\"]/input")).click();
        debug(driver);

        // Go to chat
        driver.get("https://www.facebook.com/messages/pinguet62");
        debug(driver);

        // Hide popup: notification authorization
        driver.findElement(By.xpath("//div[@class='_n8 _3qx uiLayer _3qw']")).click();
    }

    @Override
    public void send(Message message) {
        driver.findElement(By.xpath("//textarea")).sendKeys(message.toString());
        driver.findElement(By.xpath("//input[@type='submit' and @value='Répondre']")).click();
    }

}