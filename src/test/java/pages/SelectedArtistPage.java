package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectedArtistPage extends MusicSheetsPage {

	@FindBy(css = ".about-artist__bio>p:nth-child(2)")
	private WebElement artistBio;

	public SelectedArtistPage(WebDriver driver) {
		super(driver);
		
	}

	public void getArtistBio() {
		pause(2000);
		System.out.println(getText(artistBio));

	}

	public void selectSongFromArtist(String song) {
		pause(4000);
		List<WebElement> listOfSongs = driver.findElements(By.cssSelector(".songs-list>li"));
		for (WebElement el : listOfSongs) {
			WebElement link = el.findElement(By.cssSelector("#post-944 > ul.songs-list > li> a"));
			WebElement titleEl = el.findElement(By.cssSelector(".songs-list__name.verified"));
			if (getText(titleEl).equalsIgnoreCase(song)) {
				click(link);
				pause(6000);
				break;
			}

		}
		pause(6000);
	}

}
