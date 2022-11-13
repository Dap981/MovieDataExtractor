package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaMainPage {
    WebDriver driver;


    public WikipediaMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement searchBox;

    @FindBy(id = "searchButton")
    WebElement searchButton;

    @FindBy(xpath = "//th[text()='Country']/following-sibling::td")
    WebElement country;

    @FindBy(xpath = "//tr[12]/td[1]/div[1]/ul[1]/li[1]")
    WebElement releaseDate;

    public void searchMovie(String name) {
        searchBox.sendKeys(name);
        searchButton.click();
    }


    public String getCountry() {
        return country.getText();
    }

    public String getReleaseDate() {
        return releaseDate.getText();
    }

}
