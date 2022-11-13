package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImdbMainPage {

    WebDriver driver;

    public ImdbMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='suggestion-search']")
    WebElement searchBox;
    @FindBy(xpath = "//body/div[@id='__next']/nav[@id='imdbHeader']/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
    WebElement firstSearch;
    @FindBy(xpath = "//button[contains(text(),'Country of origin')]/following-sibling::*/ul[1]/li[1]/a")
    WebElement country;
    @FindBy(xpath = "//a[contains(text(),'Release date')]/following-sibling::div/ul[1]/li[1]/a")
    WebElement releaseDate;

    public void searchMovie(String name) {
        searchBox.sendKeys(name);
        firstSearch.click();

    }


    public String getCountry() {
        return country.getText();
    }

    public String getReleaseDate() {
        return releaseDate.getText();
    }

}



