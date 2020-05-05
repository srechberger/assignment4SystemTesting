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

import java.util.concurrent.TimeUnit;

public class LisssTest {

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

		// url webservice
		driver.get("https://lisss.jku.at/");

		// searchbar element
		WebElement searchBar = driver.findElement(By.id("searchBar"));
		searchBar.click();
	    searchBar.sendKeys("software testing");
	    searchBar.sendKeys(Keys.ENTER);
		 
	    // searchbutton element
	    WebElement searchButton = driver.findElement(By.cssSelector(".button-confirm .md-primoExplore-theme"));
	    searchButton.click();
		
	    // results element
	    WebElement resultsCount = driver.findElement(By.cssSelector(".results-count"));
	    
	    // tests
	    assertEquals("2,730 Ergebnisse", resultsCount.getText());
	    assertEquals("JKU | LISSS - software testing", driver.getTitle());
		
	  }

}