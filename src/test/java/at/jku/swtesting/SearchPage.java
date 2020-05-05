package at.jku.swtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class SearchPage {
    // The element is looked up using the id attribute,
	@FindBy(id = "searchBar")
	private WebElement searchBar;

    public void searchFor(String text) {
        searchBar.sendKeys(text);
        searchBar.sendKeys(Keys.ENTER);
    }
} 