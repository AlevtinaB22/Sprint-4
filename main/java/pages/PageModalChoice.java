package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class PageModalChoice {
    protected WebDriver driver;
    //локатор кнопки "Да"
    By buttonYesLocator = By.xpath("//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");
    public PageModalChoice(WebDriver driver) {
        this.driver = driver;
    }
    //локатор нажатия на кнопку "Да"
    public void modalWindowOk(){
        WebElement buttonYes = driver.findElement(buttonYesLocator);
                   buttonYes.click();
    }
}
