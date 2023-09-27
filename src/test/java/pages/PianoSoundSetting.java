package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PianoSoundSetting extends PianoPage {

	// Sound Settings
	@FindBy(css = ".piano-menu__bottom-btn.sound-btn")
	private WebElement pianoSoundMenu;
	// Sound type
	@FindBy(css = ".type.piano-type")
	private WebElement pianoSoundType;
	// midi connection button
	@FindBy(css = ".type__current.midi")
	private WebElement midiConnectionbtn;
	// Is midi connected
	@FindBy(css = "#midi-input-ul>li")
	private WebElement isMidiConnect;
	// Transpose up
	@FindBy(css = ".transpose__sign.increment")
	private WebElement transposeUp;
	// Transpose down
	@FindBy(css = "div.transpose > div > span:nth-child(1)")
	private WebElement transposeDown;
	// Transpose status
	@FindBy(css = "#transpose_val")
	private WebElement transposeStatus;
	// Sustain
	@FindBy(css = ".sustain__sign.decrement")
	private WebElement sustainminusBtn;
	// Sustain
	@FindBy(css = ".sound-input-sustain>.sustain__slide.sound-input")
	private WebElement sustainOffOrOnBtn;
	// changeVolume
	@FindBy(css = "#volume")
	private WebElement changeVolume;
	// MetronomeBtn
	@FindBy(css = "#metronome-sound-button")
	private WebElement metronomeBtn;
	// Metronome Range
	@FindBy(css = ".metronome__range>[type='range']")
	private WebElement metronomeRange;
	// Metronome Play
	@FindBy(css = ".metronome__play")
	private WebElement metronomePlay;
	// Metronome Play
	@FindBy(css = ".metronome__bpm")
	private WebElement MetronomeBPM;
	// Metronome Close
	@FindBy(css = ".submenu.metronome.active>.close")
	private WebElement closeMetronome;

	// Close sound settings
	@FindBy(css = ".submenu.metronome>.close")
	private WebElement closeSoundSettings;

	// Constructor
	public PianoSoundSetting(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void pianoSoundMenuBtn() {
		// js.executeScript("window.scrollBy(0, 250)"); // Scroll down by 250 pixels
		clickableWait(pianoSoundMenu);
		click(pianoSoundMenu);
		pause(3000);

	}

	public void pianoSoundTypeBtn() {
		clickableWait(pianoSoundType);
		click(pianoSoundType);
		pause(4000);
	}

	public void choosingSoundsFromDd(String soundName) {
		List<WebElement> list = driver.findElements(By.cssSelector(".piano-type.active > div > ul>li"));
		for (WebElement el : list) {
			if (el.getText().equalsIgnoreCase(soundName)) {
				click(el);
				pause(2000);
				System.out.println("The sound you chose is " + soundName);
				break;
			}
		}
		scrollUp350();
	}

	public void MidiConnectionBtn() {
		clickableWait(midiConnectionbtn);
		click(midiConnectionbtn);
	}

	public String isThereMidiConnection() {
		pause(4000);
		return getText(isMidiConnect);
	}

	public void transposeUp(int times) {
		for (int i = 0; i < times; i++) {
			click(transposeUp);
			pause(200);
		}

	}

	public void transposeDown(int times) {
		for (int i = 0; i < times; i++) {
			click(transposeDown);
			pause(200);
		}

	}

	public void closeSoundSettings() {
		pause(2000);
		click(closeSoundSettings);
	}

	public void seeTransposeStatus() {
		System.out.println(transposeStatus.getText());
	}

	public void sustainOfforOn() {
		click(sustainOffOrOnBtn);
	}

	public void lowerSustain(int times) {
		for (int i = 0; i < times; i++) {
			click(sustainminusBtn);
			pause(200);
		}

	}

	public void changeVolume(int howMuchToChange) {
		
		int targetPosition = howMuchToChange;

		int sliderWidth = changeVolume.getSize().getWidth();

		int xOffset = (int) ((targetPosition / 100.0) * sliderWidth);

		Actions a = new Actions(driver);
		a.clickAndHold(changeVolume).moveByOffset(xOffset, 0).release().build().perform();

	}

	public void clickMetronmeBtn() {
		pause(2000);
		click(metronomeBtn);
	}

	public void changeMetronomeSpeed(int metronomeRangeNumber) {
		pause(2000);
		
		int targetPosition = metronomeRangeNumber;

		int sliderWidth = changeVolume.getSize().getWidth();

		int xOffset = (int) ((targetPosition / 100.0) * sliderWidth);

		Actions a = new Actions(driver);
		a.clickAndHold(metronomeRange).moveByOffset(xOffset, 0).release().build().perform();
	}

	public void metronomePlayBtn() {
		click(metronomePlay);
	}

	public void getMetronomeBPM() {
		System.out.println("The BPM is " + getText(MetronomeBPM));
	}

	public void closeMetronome() {
		clickableWait(pianoSoundMenu);
		click(pianoSoundMenu);
	}

}
