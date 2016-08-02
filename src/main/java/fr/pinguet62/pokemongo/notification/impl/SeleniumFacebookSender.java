package fr.pinguet62.pokemongo.notification.impl;

import static java.io.File.createTempFile;
import static java.lang.System.lineSeparator;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import fr.pinguet62.pokemongo.model.Appearance;
import fr.pinguet62.pokemongo.notification.Sender;

/** Send message to Facebook messanger, using Selenium. */
@Component
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

    @Value("${facebook.target}")
    private String target;

    @Override
    public void accept(Appearance appearance) {
        String message = appearance.getPokemon().getName();
        message += lineSeparator() + "End: " + new SimpleDateFormat("hh:mm:ss").format(appearance.getExpiration());
        if (appearance.getZone() != null)
            message += lineSeparator() + "Zone: " + appearance.getZone().getName();
        message += lineSeparator() + appearance.getPosition().getUrl();

        driver.findElement(By.xpath("//textarea")).sendKeys(message.toString());
        driver.findElement(By.xpath("//input[@type='submit' and @value='Répondre']")).click();
    }

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
        driver.get("https://www.facebook.com/messages/" + target);
        debug(driver);

        // Hide popup: notification authorization
        driver.findElement(By.xpath("//div[@class='_n8 _3qx uiLayer _3qw']")).click();
    }

}