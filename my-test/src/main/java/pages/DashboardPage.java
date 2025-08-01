package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private By timeAtWorkWidget = By.xpath("//p[contains(text(),'Time at Work')]");
    private By myActionsWidget = By.xpath("//p[contains(text(),'My Actions')]");

    public boolean isDashboardVisible() {
        return driver.findElement(dashboardHeader).isDisplayed();
    }

    public boolean isTimeAtWorkWidgetVisible() {
        return driver.findElement(timeAtWorkWidget).isDisplayed();
    }

    public boolean isMyActionsWidgetVisible() {
        return driver.findElement(myActionsWidget).isDisplayed();
    }
}
