package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PianoPage extends HomePage {

	@FindBy(css = "#Capa_1")
	private WebElement editBtnForFirstOpeningTheWebsite;

	@FindBy(css = "#search-input")
	private WebElement searchPianoSheets;

	@FindBy(css = "#autoplay-btn")
	private WebElement autoPlayBtn;

	@FindBy(css = ".piano-menu__song-info>.close")
	private WebElement exitSong;

	@FindBy(css = ".piano-menu__played-restart")
	private WebElement restartSong;
	
	@FindBy(css = "#restart-btn")
	private WebElement restartSongThatSearched;

	@FindBy(css = ".song-item.verified:nth-child(1)")
	private WebElement selectedSong;

	@FindBy(css = "#restart-btn")
	private WebElement restartSearchedSong;

	@FindBy(css = "#piano-chord")
	private WebElement getTheActualPlayedNote;
	
	@FindBy(css = "#search-result>span")
	private WebElement noSongFound;
	

	// Constructor
	public PianoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Click edit Btn only at home page
	public void clickEditBtnOnlyWhenBeingAtHomeStatus() {
		clickableWait(editBtnForFirstOpeningTheWebsite);
		click(editBtnForFirstOpeningTheWebsite);
		pause(1000);
	}

	// click on exit Text Box

	public void SearchSongsBtn() {
		clickableWait(searchPianoSheets);
		click(searchPianoSheets);
		pause(2000);
	}

	public void fillTextSongsFromSearch(String songOrArtistToSearch) {
		fillText(searchPianoSheets, songOrArtistToSearch);
		pause(2000);

	}

	public void SelectedSongBtn(int numberOfObject) {
		List<WebElement> list = driver.findElements(By.cssSelector("#search-result>li"));
		click(list.get(numberOfObject));

		pause(2000);

	}

	// Playing the song
	public void playingTheSongAfterSearch() {
		pause(5000);
		click(autoPlayBtn);
		pause(20000);

	}

	// click on stop playing from Text Box
	public void stopPlayingFromTextBox() {
		pause(2000);
		click(restartSong);
		pause(2000);
	}

	// Stop playing
	public void stopPlayingSongThatSearched() {
		click(exitSong);
		pause(2000);

	}

	public void restartPlayingSongThatSearched() {
		click(restartSearchedSong);
		pause(2000);

	}

	public void getMyPlayedNote() {
		System.out.println("You just heard " + getText(getTheActualPlayedNote) + "note");
		System.out.println("---------------------------------------");
	}
	
	public String getMessageNoSongFound() {
		return getText(noSongFound);
	}

}
