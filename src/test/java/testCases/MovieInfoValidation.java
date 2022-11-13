package testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.ImdbMainPage;
import pageObjects.WikipediaMainPage;

import java.text.ParseException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MovieInfoValidation extends BaseClass {

    @Parameters("movieName")
    @Test
    public void validateMovieInfo(String movieName) throws ParseException {

        driver.get(wikipediaUrl);
        WikipediaMainPage wikiPage = new WikipediaMainPage(driver);
        wikiPage.searchMovie(movieName);
        String countryNameFromWiki = wikiPage.getCountry();
        String dateFromWiki = wikiPage.getReleaseDate();

        driver.get(imdbUrl);
        ImdbMainPage imdbPage = new ImdbMainPage(driver);
        imdbPage.searchMovie(movieName);
        String countryNameFromImdb = imdbPage.getCountry();
        String dateFromImdb = imdbPage.getReleaseDate();

        String imdbDateArr[] = dateFromImdb.split(" ");
        String wikiDateArr[] = dateFromWiki.split(" ");
        String imdbDate = Arrays.stream(imdbDateArr).limit(3).sorted().collect(Collectors.joining()).replace(",", "");
        String wikiDate = Arrays.stream(wikiDateArr).sorted().collect(Collectors.joining());

        Assert.assertEquals(countryNameFromImdb, countryNameFromWiki, "Compare Country Name");
        Assert.assertEquals(imdbDate, wikiDate, "Compare Release Date");


    }
}
