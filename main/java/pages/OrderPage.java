package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    protected WebDriver driver;
    //локатор поля "Имя"
    By nameLocator = By.xpath(".//input[@placeholder='* Имя']");
    //локатор поля "Фамилия"
    By familyLocator = By.xpath(".//input[@placeholder='* Фамилия']");
    //локатор поля "Адрес"
    By adressLocator = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор поля "Станция метро" для клика
    By stationMetroClick = By.xpath(".//input[@placeholder='* Станция метро']");
    //локатор для поиска определенной станции метро
    private final String stationMetro = "//div[text()='%s']";
    //локатор поля "Телейон"
    By telephoneLocator = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор кнопки "Далее"
    By buttonNextLocator = By.xpath("//button[text()='Далее']");
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    //метод для заполнения полей формы
    public void writeData(String firstName, String secondName, String adressUser, String stationMetroUser, String telephoneUser){
       WebElement nameFirst = driver.findElement(nameLocator);
                  nameFirst.sendKeys(firstName);
       WebElement nameSecond = driver.findElement(familyLocator);
                  nameSecond.sendKeys(secondName);
       WebElement adressRent = driver.findElement(adressLocator);
                  adressRent.sendKeys(adressUser);
       getStationMetro(stationMetroUser);
       WebElement phone =driver.findElement(telephoneLocator);
                  phone.sendKeys(telephoneUser);
    }
    //метод для заполнения поля "Станция метро"
    public void getStationMetro(String station) {
        WebElement stationNameClick = driver.findElement(stationMetroClick);
        stationNameClick.click();
        WebElement stationMetroName = driver.findElement(By.xpath(String.format(stationMetro,station)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", stationMetroName);
        stationMetroName.click();
    }
    //метод для клика на кнопку "Далее"
    public void clickButtonNext(){
       WebElement buttonNext = driver.findElement(buttonNextLocator);
                  buttonNext.click();
    }
}
