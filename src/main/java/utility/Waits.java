package utility;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class Waits {
    WebDriver driver;
    Wait<WebDriver> fWaits;

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    private Wait<WebDriver> fluentWait(int waitingTime) {
        fWaits = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(waitingTime))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        return fWaits;
    }

    public void visibilityOf(WebElement webElement, int waitingTime) {
        Wait<WebDriver> fWait = fluentWait(waitingTime);
        fWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void click(WebElement webElement, int waitingTime) {
        Wait<WebDriver> fWait = fluentWait(waitingTime);
        fWait.until(ExpectedConditions.visibilityOf(webElement));
        fWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public void putText(WebElement webElement, String text, int waitingTime) {
        Wait<WebDriver> fWait = fluentWait(waitingTime);
        fWait.until(ExpectedConditions.visibilityOf(webElement));
        fWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    public String getText(WebElement webElement, int waitingTime) {
        Wait<WebDriver> fWait = fluentWait(waitingTime);
        fWait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public void clickRadioButton(List<WebElement> radio, String value, int waitingTime) {
        Wait<WebDriver> fWait = fluentWait(waitingTime);
        fWait.until(ExpectedConditions.visibilityOfAllElements(radio));
        for (int i = 0; i < radio.size(); i++) {
            if (radio.get(i).getText().equals(value)) {
                radio.get(i).click();
                break;
            }
        }
    }

    public void clickDivDropDownOption(WebElement dropdown, List<WebElement> elements, String value, int waitingTime) {
        Wait<WebDriver> fWait = fluentWait(waitingTime);
        fWait.until(ExpectedConditions.visibilityOf(dropdown));
        click(dropdown, waitingTime);
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(value)) {
                elements.get(i).click();
                break;
            }
        }
    }

    public void selectCheckBox(List<WebElement> checkbox, String[] value, int waitingTime) {
        Wait<WebDriver> fWait = fluentWait(waitingTime);
        fWait.until(ExpectedConditions.visibilityOfAllElements(checkbox));
        for (WebElement element : checkbox) {
            for (int i = 0; i < value.length; i++) {
                if (element.getText().equals(value[i])) {
                    element.click();
                }
            }
        }
    }

}