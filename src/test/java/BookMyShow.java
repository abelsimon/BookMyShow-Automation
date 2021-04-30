import DataProviders.ParametrizationClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.io.IOException;

public class BookMyShow {
    private WebDriver driver;

    @Parameters({"chromebrowser","url"})

    @BeforeMethod
    public void openBrowser(String browser,String url) throws Exception {
        driver = Browser.openBrowser(browser, url);
    }


    @Test(dataProviderClass = ParametrizationClass.class, dataProvider = "getdata")
//    TestCase 01 & 02 : Search Movie Positive & Negative TestCase
    public void movieSearch(String MovieName, String ReportSearch) throws IOException {
        Reports.createTest("ReportSearch");
        TestCase_1_2 TestCase1_2 = new TestCase_1_2(driver);
        TestCase1_2.searchMovie(MovieName);
    }
 /*   @Test(dataProvider = "moviepositive",dataProviderClass = ParametrizationClass.class)
    public void movieSelect(String MovieName) throws IOException{
        Reports.createTest("ReportSearch");
        TestCase_1_2 TestCase1_2 = new TestCase_1_2(driver);
        TestCase1_2.searchMovie(MovieName);
    } */


    @Test(priority = 1, dataProviderClass = ParametrizationClass.class, dataProvider = "getdata")
//     TestCase 03 & 04: Search for Cast and Crew - Positive & Negative TestCase
    public void castCrew(String ActorName, String CrewName, String MovieName, String ReportCrew) throws IOException {
        Reports.createTest("ReportCrew");
        TestCase_3_4 TestCase3_4 = new TestCase_3_4(driver);
        TestCase3_4.crewCast(ActorName, CrewName, MovieName);

    }

    @Test(priority = 2)
    //TestCase 05 : List Your Show-What can you Host
    public void showHost() throws IOException {
        Reports.createTest("TestCase 05/List Your Show-What can you Host");
        TestCase_5 TestCase5 = new TestCase_5(driver);
        TestCase5.hostShow();
    }

    @Test(priority = 3)
    //TestCase 06 : List Your Show-What are the services we offer
    public void serviceOffer() throws IOException {
        Reports.createTest("TestCase 06/List Your Show-What are the services we offer");
        TestCase_6 TestCase6 = new TestCase_6(driver);
        TestCase6.offerService();
    }

    @Test(priority = 4)
    //TestCase 07 : List Your Show-Reports & Business insights details
    public void showReports() throws IOException {
        Reports.createTest("TestCase 07/List Your Show-Reports & Business insights details");
        TestCase_7 TestCase7 = new TestCase_7(driver);
        TestCase7.reportShow();

    }


    @Test(priority = 5)
    //TestCase 11 : Footer Text Validation
    public void footer() throws IOException {
        Reports.createTest("TestCase 11/Footer Text Validation");
        TestCase_11 TestCase_11 = new TestCase_11(driver);
        TestCase_11.footerText();
    }

    @Test(priority = 6)
    //TestCase 12 : Validate Menu
    public void validateMenu() throws IOException {
        Reports.createTest("TestCase 12/Validate Menu");
        TestCase_12 TestCase_12 = new TestCase_12(driver);
        TestCase_12.menuValidate();
    }

    @Parameters({"City"})
    @Test(priority = 7)
    //TestCase 13 : Choose City
    public void chooseCity(@Optional("Goa") String City) throws IOException {
        Reports.createTest("TestCase 13/ Choose City");
        TestCase_13 TestCase_13 = new TestCase_13(driver);
        TestCase_13.verifyCity(City);
    }


    @Test(priority = 8)
    //TestCase 15 : Validate Filter by Price Doubts
    public void validateFilter() throws IOException {
        Reports.createTest("TestCase 15/Validate Filter by Price");
        TestCase_15 TestCase_15 = new TestCase_15(driver);
        TestCase_15.filterValidate();
    }

    @AfterMethod
    public void closeBrowser() {
        Browser.closeBrowser(driver);
    }
}