package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyInfoPage {
    private WebDriver driver;

    // Locators
    private By myInfoTab = By.xpath("//span[text()='My Info']");
    private By personalDetailsHeader = By.xpath("//h6[text()='Personal Details']");

    // Constructor
    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void openMyInfoSection() {
        driver.findElement(myInfoTab).click();

        boolean isVisible = driver.findElement(personalDetailsHeader).isDisplayed();
        Assert.assertTrue(isVisible, "My Info section should be displayed");

        System.out.println("Navigated to My Info > Personal Details section.");
    }
}
