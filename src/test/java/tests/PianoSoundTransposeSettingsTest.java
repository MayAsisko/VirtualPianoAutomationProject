package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.PianoKeys;
import pages.PianoPage;
import pages.PianoSoundSetting;

public class PianoSoundTransposeSettingsTest extends BaseTest {
	PianoPage pp;
	PianoSoundSetting pss;
	PianoKeys pk;

	@BeforeMethod
	public void setUp() {
		// Initialize the PianoPage object here
		pp = new PianoPage(driver);
		pk = new PianoKeys(driver);
		pss = new PianoSoundSetting(driver);
	}

	@Test
	// Test that I can transpose up the piano -then play before and after to see if
	// there is a change +get the updated written notes
	public void tc01_transposeUp() {
		pss.scrollUpPage(1);
		pk.playNote("c");
		pp.getMyPlayedNote();
		pk.playNote("d");
		pp.getMyPlayedNote();
		pss.pianoSoundMenuBtn();
		pss.transposeUp(2);
		pss.closeSoundSettings();
		pss.scrollUpPage(1);
		pk.playNote("c");
		pp.getMyPlayedNote();
		pk.playNote("d");
		pp.getMyPlayedNote();

	}

	@Test
	// Test that I can transpose down the piano -then play before and after to see
	// if there is a change +get the updated written notes
	public void tc02_transposeDown() {
		pk.playNote("b");
		pp.getMyPlayedNote();
		pk.playNote("c");
		pp.getMyPlayedNote();
		pss.pianoSoundMenuBtn();
		pss.transposeDown(4);
		pss.closeSoundSettings();
		pk.playNote("b");
		pp.getMyPlayedNote();
		pk.playNote("c");
		pp.getMyPlayedNote();

	}

	@Test
	// Test that I can't transpose more than 12 values- click "-" 14 times and see
	// what value it returns (transpose status)- should show -12.
	public void tc03_transposeDownMoreThanPossible() {
		pss.pianoSoundMenuBtn();
		pss.transposeDown(14);
		pss.seeTransposeStatus();
		pss.closeSoundSettings();

	}

	@Test
	// Test that I can't transpose more than 12 values- click "+" 14 times and see
	// what value it returns (transpose status)- should show +12.
	public void tc04_transposeDownMoreThanPossible() {
		pss.pianoSoundMenuBtn();
		pss.transposeUp(27);
		pss.seeTransposeStatus();
		pss.closeSoundSettings();

	}

}
