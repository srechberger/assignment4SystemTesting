package at.jku.swtesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class LisssParameterizedTest {

	private static WebDriver driver;

	@BeforeAll
	public static void setUp() { 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
			
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}

    @AfterAll
    public static void tearDown() {
		driver.close();
		driver.quit();
	}
  
    @ParameterizedTest
    @CsvFileSource (resources = "/testdata.csv", numLinesToSkip = 1)
	public void testSearch(String searchString, int expectedNbrOfResults) {
  	    	
		// url webservice
		driver.get("https://lisss.jku.at/");
		// set windowsize to find results-element
		driver.manage().window().setSize(new Dimension(1400, 800));
		
	    // create a new instance of the search page class and initialise WebElement (searchBar)
	    SearchPage sPage = PageFactory.initElements(driver, SearchPage.class);
		sPage.searchFor(searchString);
		
		// create a new instance of the search page class and initialise WebElements (resultsCount, title)
	    ResultsPage rPage = PageFactory.initElements(driver, ResultsPage.class);
	    
	    // tests
	    assertEquals(expectedNbrOfResults, rPage.getNumberOfResults());
	    assertEquals("JKU | LISSS - " + searchString, driver.getTitle());
    }

}
