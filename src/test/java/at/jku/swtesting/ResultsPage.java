package at.jku.swtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class ResultsPage {
    // The element is looked up using the css attribute,	
	@FindBy(css = ".search-toolbar-title > .results-count")
	private WebElement resultsCount;
	
    public int getNumberOfResults() {
    	return Integer.parseInt(resultsCount.getText().split("\\ ")[0].replace(",", "").replace(".", ""));
    }
} 