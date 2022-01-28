package com.kitapyurdu.methods;

import com.kitapyurdu.driver.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;

    public Methods() {
        driver = BaseTest.driver;
        wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findAll(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void scrollWithAction(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public String getAttribute(By by, String attributeName) {
        return findElement(by).getAttribute(attributeName);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public Select getSelect(By by) {
        return new Select(findElement(by));
    }

    public void selectText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    }

    public void clearInputArea(By by) {
        findElement(by).clear();
    }

    public void hover(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).perform();
    }

    public void selectRandomFavourite(By by) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random rnd = new Random();
        while (numbers.size() < 4) {
            int random = rnd.nextInt(getAllProducts(by).size());
            if (!numbers.contains(random)) {
                scrollWithAction(By.xpath("//*[@class='product-cr'][" + random + "]"));
                waitBySeconds(2);
                getAllProducts(by).get(random).click();
                numbers.add(random);
            }
        }
    }

    public void addToCart(By hover, By by) {
        Actions actions = new Actions(driver);
        Random rnd = new Random();
        int i = rnd.nextInt(getAllProducts(by).size());
        actions.moveToElement(getAllProducts(hover).get(i)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(getAllProducts(by).get(i))).click();
    }

    public String splitId(String text) {
        return text.replace("product-", "");
    }

    private List<WebElement> getAllProducts(By by) {
        return findAll(by);
    }

}
