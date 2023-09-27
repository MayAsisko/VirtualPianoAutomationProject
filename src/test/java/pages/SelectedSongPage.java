package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectedSongPage extends SelectedGenreMusicPage {
	@FindBy(css = ".sheet__info>li")
	private WebElement SheetInfo;
	@FindBy(css = ".smart-para-div>p")
	private WebElement aboutSong;
	@FindBy(css = ".under_button>#sheet-play")
	private WebElement playThisSongBtn;

	public SelectedSongPage(WebDriver driver) {
		super(driver);
		
	}

	public void getSheetInfo() {
		System.out.println(getText(SheetInfo));
	}
	
	public void aboutThisSong() {
		System.out.println(getText(aboutSong));
	}
	
	public void playSelectedSong() {
		pause(3000);
		click(playThisSongBtn);
		
	}

}
