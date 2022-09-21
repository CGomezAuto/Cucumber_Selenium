package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Waits;


public class Home {
    Waits waits;

    public Home(WebDriver driver) {
        waits = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[text()='Elements']")
    WebElement elementsMenuBtn;

    public void clickElementsMenuBtn() {
        waits.click(elementsMenuBtn, 30);
    }
}
