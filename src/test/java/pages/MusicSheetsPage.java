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

	public void clickOnCategory(int CategoryOrder) {
		List<WebElement> list = driver.findElements(By.cssSelector(".piano-menu__search-genres>a"));
		click(list.get(CategoryOrder));
		pause(2000);

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

		}

		pause(5000);
	}

}
