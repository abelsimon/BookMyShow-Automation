import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class TestCase_1_2 extends BasePage {

    public TestCase_1_2(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void searchMovie(String MovieName) throws IOException {
        try {
            click(By.cssSelector(".sc-hMrMfs:nth-child(1) .sc-yZwTr"));
            click(By.id("4"));
            locateElement(By.cssSelector(".sc-fihHvN")).sendKeys(MovieName);
            waitFor(By.xpath("//li"));
            if (!(getText(By.xpath("//li")).contains("No Results found"))) {
                click(By.xpath("//li"));
                String NameMovie = getText(By.xpath("//h1[@class='styles__EventHeading-qswwm9-6 mptsd']"));
                Assert.assertEquals(NameMovie, MovieName);
                if (NameMovie.contains(MovieName)) {
                    System.out.println("Movie : " + MovieName);
                    Reports.extentTest.log(Status.PASS, "Selected Movie is Correct : " + MovieName);
                    takeScreenshot("Correct movie selected");
                } else {
                    System.out.println("Incorrect Movie : " + MovieName);
                    Reports.extentTest.log(Status.FAIL, "Selected Movie is Incorrect : " + MovieName);
                    takeScreenshot("In Correct movie selected");
                }
            } else {
                System.out.println("No results found");
                Reports.extentTest.log(Status.PASS, "No Results found");
                takeScreenshot("No_Result_Found");
            }
        } catch (Exception e) {
            System.out.println(e);
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot("SearchMovie_Failed");
        }
    }
}
