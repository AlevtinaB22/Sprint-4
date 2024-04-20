package pages;
import org.openqa.selenium.*;
public class RentPage {
    protected WebDriver driver;
    //локатор поля "Когда привезти самокат"
    By dateRentaClick = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //локатор поля "Срок аренды"
    By rentalPeriodClick = By.xpath(".//div[text()='* Срок аренды']");
    //локатор определенного срока аренды
    protected final String rentalPeriod = ".//div[@class='Dropdown-option' and text()='%s']";
    //локатор кнопки "Заказать"
    By buttonOrderLocator = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    public RentPage(WebDriver driver) {
        this.driver = driver;
    }
    //заполнение полей формы
    public void writeData(String dateRentaSamokata,String rentalPeriodSamokata){
        WebElement dateClick = driver.findElement(dateRentaClick);
        dateClick.sendKeys(dateRentaSamokata, Keys.ENTER);
        WebElement periodClick = driver.findElement(rentalPeriodClick);
        periodClick.click();
        WebElement periodRent = driver.findElement(By.xpath(String.format(rentalPeriod,rentalPeriodSamokata)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", periodRent);
        periodRent.click();

    }
    //клик на кнопку "Заказать"
    public void clickButtonOrder(){
        WebElement buttonOrder =driver.findElement(buttonOrderLocator);
                   buttonOrder.click();
    }
}
