package at.jku.swtesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class LisssPageObjectTest {

	private static WebDriver driver;

	@BeforeAll
	public static void setUp() { 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
			
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

    @AfterAll
    public static void tearDown() {
		driver.close();
		driver.quit();
	}
  
	@Test
	public void testSearch() {
		String searchString = "software testing";
		
		// url webservice
		driver.get("https://lisss.jku.at/");

	    // create a new instance of the search page class and initialise WebElement (searchBar)
	    SearchPage sPage = PageFactory.initElements(driver, SearchPage.class);
		sPage.searchFor(searchString);
		
		// create a new instance of the search page class and initialise WebElements (resultsCount, title)
	    ResultsPage rPage = PageFactory.initElements(driver, ResultsPage.class);
	    
	    // tests
	    assertEquals(2730, rPage.getNumberOfResults());
	    assertEquals("JKU | LISSS - software testing", driver.getTitle());
		
	  }

}
