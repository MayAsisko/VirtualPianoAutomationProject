package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MusicSheetsPage extends BasePage {
	@FindBy(css = ".pp-offcanvas-toggle-text.pp-toggle-label")
	private WebElement OpenListGeneresBtn;

	// Constructor
	public MusicSheetsPage(WebDriver driver) {
		super(driver);
		
	}

	public void clickOnAPopularCategory(String PopularCategory) {
		List<WebElement> list = driver.findElements(By.cssSelector(".piano-menu__search-genres>a>span"));
		for (WebElement el : list) {
			if (getText(el).equalsIgnoreCase(PopularCategory)) {
				pause(3000);
				click(el);
				
			}
			break;
			

		}
		pause(3000);
	}

	public void clickToOpenListOfGenres() {
		clickableWait(OpenListGeneresBtn);
		click(OpenListGeneresBtn);
	}

	public void chooseGenreFromList(String nameOfGenre) {
		pause(4000);
		List<WebElement> listOfGenres = driver.findElements(By.cssSelector(".pp-category__content"));
		for (WebElement el : listOfGenres) {
			WebElement titleEl = el.findElement(By.cssSelector("div > a > .pp-category__content>div>h4"));
			if (getText(titleEl).equalsIgnoreCase(nameOfGenre)) {
				pause(5000);
				click(el);
				break;
			}
			System.out.println("Try Again");

		}

		pause(5000);
	}

}
