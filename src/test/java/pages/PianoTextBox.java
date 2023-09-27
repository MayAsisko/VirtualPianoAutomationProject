package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PianoTextBox extends PianoPage{
	@FindBy(css = ".piano-menu__played-edit")
	private WebElement editBtnForwritingKeys;
	@FindBy(css = "#song-editor")
	private WebElement writingTheNotes;
	@FindBy(css = ".piano-menu__played-editing.active>.close")
	private WebElement exitTextBoxBtn;
	@FindBy(css = "#render-song")
	private WebElement renderBtn;
	@FindBy(css = ".piano-menu__played-play")
	private WebElement playTheKeysBtn;
	@FindBy(css = "#home")
	private WebElement homePianoBtn;
	
	
	public PianoTextBox(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// Click edit Btn pencil
	public void clickEditBtnPencil() {
		pause(3000);
		click(editBtnForwritingKeys);
		pause(1000);
	}

	// WriteOrPasteInTextBox
	public void textBoxPasteOrWrite(String notesToPaste) {
		fillText(writingTheNotes, notesToPaste);
		pause(2000);

	}

	// Click Render song btn
	public void clickRenderSong() {
		pause(4000);
		click(renderBtn);
		pause(4000);

	}

	// Click Play Btn
	public void clickPlayBtn(long milliseconds) {
		pause(5000);
		click(playTheKeysBtn);
		pause(milliseconds);
		pause(1000);
	}

	// click on exit Text Box
	public void clickExitTextBoxBtn() {
		clickableWait(exitTextBoxBtn);
		click(exitTextBoxBtn);
		pause(2000);
	}

	
	
	// click on home icon to return home
	public void returnToHomemenueOfPiano() {
		pause(2000);
		click(homePianoBtn);
		pause(5000);
	}

}
