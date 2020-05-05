package at.jku.swtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class ResultsPage {
    // The element is looked up using the css attribute,	
	@FindBy(css = ".results-count")
	private WebElement resultsCount;
	
    public String getNumberOfResults() {
    	return resultsCount.getText().replace(",", ".");
    }
} 