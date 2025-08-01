package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyInfoPage {
    private WebDriver driver;

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    private By myInfoTab = By.xpath("//span[text()='My Info']");
    private By personalDetailsHeader = By.xpath("//h6[text()='Personal Details']");

    public void openMyInfoSection() {
        driver.findElement(myInfoTab).click();

        boolean isVisible = driver.findElement(personalDetailsr).isDisplayed();
        Assert.assertTrue(isVisible, "My Info section should be displayed");
        System.out.println("Navigated to My Info > Personal Details section.");
    }
}
