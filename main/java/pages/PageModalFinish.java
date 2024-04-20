package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageModalFinish {
    protected WebDriver driver;
    //локатор хедера "Заказ оформлен"
    By headerOrderLocator = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");
    public PageModalFinish(WebDriver driver) {
        this.driver = driver;
    }
    //поиск хедера "Заказ оформлен"
    public boolean headerOrderIsDisplayed(){
       WebElement  headerText = driver.findElement(headerOrderLocator);
                   return headerText.isDisplayed();
   }
}
