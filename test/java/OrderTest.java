import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.*;
@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver webDriver;
    private final String firstName;
    private final String secondName;
    private final String adressUser;
    private final String stationMetroUser;
    private final String telephoneUser;
    private final String dateRentaSamokata;
    private final String rentalPeriodSamokata;
    @Before
    public void startUp() {
        webDriver = WebDriverFactory.getWebDriver("chrome");
        webDriver.manage().window().maximize();
        webDriver.get(Constants.HOMEPAGEURL);
    }
    public OrderTest(String firstName, String secondName, String adressUser, String stationMetroUser, String telephoneUser,String dateRentaSamokata,String rentalPeriodSamokata){
        this.firstName=firstName;
        this.secondName=secondName;
        this.adressUser=adressUser;
        this.stationMetroUser=stationMetroUser;
        this.telephoneUser=telephoneUser;
        this.dateRentaSamokata=dateRentaSamokata;
        this.rentalPeriodSamokata=rentalPeriodSamokata;
    }
    @Parameterized.Parameters
    public static Object [][] getData(){
        return new Object[][]{
                {"Александр","Александров","Москва","Сокольники","677700000000","20.06.2024","двое суток"},
                {"Ивано","Иванов","Космическая","Комсомольская","47789890009","21.06.2024","сутки"},
        };
    }
    @Test
    public void orderFromHeader(){
        HomePage homePage = new HomePage(webDriver);
                 homePage.clickButtonOrderHeader();
        OrderPage orderPage = new OrderPage(webDriver);
                  orderPage.writeData(firstName,secondName,adressUser,stationMetroUser,telephoneUser);
                  orderPage.clickButtonNext();
        RentPage rentPage = new RentPage(webDriver);
                 rentPage.writeData(dateRentaSamokata,rentalPeriodSamokata);
                 rentPage.clickButtonOrder();
        PageModalChoice pageModalChoice = new PageModalChoice(webDriver);
                        pageModalChoice.modalWindowOk();
        PageModalFinish pageModalFinish = new PageModalFinish(webDriver);
        Assert.assertTrue(pageModalFinish.headerOrderIsDisplayed());
    }
    @Test
    public void orderFromPage(){
        HomePage homePage = new HomePage(webDriver);
        homePage.clickButtonOrderPage();
        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.writeData(firstName,secondName,adressUser,stationMetroUser,telephoneUser);
        orderPage.clickButtonNext();
        RentPage rentPage = new RentPage(webDriver);
        rentPage.writeData(dateRentaSamokata,rentalPeriodSamokata);
        rentPage.clickButtonOrder();
        PageModalChoice pageModalChoice = new PageModalChoice(webDriver);
        pageModalChoice.modalWindowOk();
        PageModalFinish pageModalFinish = new PageModalFinish(webDriver);
        Assert.assertTrue(pageModalFinish.headerOrderIsDisplayed());
    }
    @After
    public void closeBrowser(){
        webDriver.quit();
    }
}
