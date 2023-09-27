package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectedGenreMusicPage extends MusicSheetsPage {

	public SelectedGenreMusicPage(WebDriver driver) {
		super(driver);
		
	}

	public void chooseSongFromList(String nameOfSong) {
		pause(4000);
		List<WebElement> listOfSongs = driver.findElements(By.cssSelector("#main>ul>li"));
		for (WebElement el : listOfSongs) {
			WebElement link = el.findElement(By.cssSelector("#main>ul>li>a"));
			WebElement titleEl = el.findElement(By.cssSelector(".songs-list__name.verified"));
			if (getText(titleEl).equalsIgnoreCase(nameOfSong)) {
				pause(1000);
				click(link);
				pause(6000);
				break;
			}

		}
		pause(6000);
	}
}