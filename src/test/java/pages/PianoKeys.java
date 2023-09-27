package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PianoKeys extends PianoPage {

	
	
	// All notes i will be using from the piano + Array--

	@FindBy(css = "#key_48")
	private WebElement cNote;
	@FindBy(css = "#key_50")
	private WebElement dNote;
	@FindBy(css = "#key_52")
	private WebElement eNote;
	@FindBy(css = "#key_53")
	private WebElement fNote;
	@FindBy(css = "#key_55")
	private WebElement gNote;
	@FindBy(css = "#key_57")
	private WebElement aNote;
	@FindBy(css = "#key_59")
	private WebElement bNote;
	@FindBy(css = "#key_60")
	private WebElement cHighNote;

	// Constructor
	public PianoKeys(WebDriver driver) {
		super(driver);
		
	}

	// Method to play a single note
	public void playNote(String note) {
		if (note == "c") {
			clickableWait(cNote);
			click(cNote);
			pause(4000);
		}
		if (note == "d") {
			clickableWait(dNote);
			click(dNote);
			pause(4000);
		}
		if (note == "e") {
			clickableWait(eNote);
			click(eNote);
			pause(4000);
		}
		if (note == "f") {
			clickableWait(fNote);
			click(fNote);
			pause(4000);
		}
		if (note == "g") {
			clickableWait(gNote);
			click(gNote);
			pause(4000);
		}
		if (note == "a") {
			clickableWait(aNote);
			click(aNote);
			pause(4000);
		}
		if (note == "b") {
			clickableWait(bNote);
			click(bNote);
			pause(4000);
		}

		

	}

	// Method to play a major scale
	public void playMajorScale() {
		// Define the notes of a major scale in order
		WebElement[] majorScaleNotes = { cNote, dNote, eNote, fNote, gNote, aNote, bNote, cHighNote };

		// Loop through the notes and play them one by one

		for (WebElement el : majorScaleNotes) {
			pause(2000);
			click(el);
		}
		pause(2000);

	}

}
