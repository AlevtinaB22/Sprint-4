package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class HomePage {
    private final WebDriver driver;
    //Кнопка "Заказать" в хедере
    private final By buttonOrderHeaderLocator= By.className("Button_Button__ra12g");
    //Кнопка "Заказать" на странице
    private final By buttonOrderPageLocator = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']");
    //Кнопка закрытия куки
    private final By cookieButtonLocator = By.id("rcc-confirm-button");
    //локатор для вопросов
    private final String accordionQuestionLocator = ".//div[@id='accordion__heading-";
    //локатор для ответов
    private final String accordionTextAnswer = ".//div[@id='accordion__panel-";
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //нажатие на кнопку "Закзать" в хедере
    public void clickButtonOrderHeader(){
        WebElement buttonOrderHeader = driver.findElement(buttonOrderHeaderLocator);
        buttonOrderHeader.click();
    }
    //нажатие на кнопку "Закзать" на странице
    public void clickButtonOrderPage() {
        closeCookie();
        WebElement scrollToButtonOrder = driver.findElement(buttonOrderPageLocator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", scrollToButtonOrder);
        scrollToButtonOrder.click();
    }
    //закрытие куки
    public void closeCookie(){
        WebElement cookie = driver.findElement(cookieButtonLocator);
        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.elementToBeClickable(cookieButtonLocator));
        cookie.click();
    }
    //клик на аккордион
    public void accordionClick(int numberQuestion){
        WebElement scrollToAccordionQuestion = driver.findElement(By.xpath(accordionQuestionLocator+numberQuestion+"']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", scrollToAccordionQuestion);
        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(accordionQuestionLocator+numberQuestion+"']")));
        scrollToAccordionQuestion.click();
    }
    //получить текст ответов аккордиона
    public String getTextAnswer(int numberAnswer){
        WebElement textAnswer = driver.findElement(By.xpath(accordionTextAnswer+numberAnswer +"']//p"));
        textAnswer.isDisplayed();
       return textAnswer.getText();
    }
}
