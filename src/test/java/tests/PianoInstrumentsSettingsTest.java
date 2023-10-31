package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.PianoKeys;
import pages.PianoSoundSetting;

public class PianoInstrumentsSettingsTest extends BaseTest {
	PianoSoundSetting pss;
	PianoKeys pk;

	@BeforeMethod
	public void setUp() {
		// Initialize the PianoPage object here
		pk = new PianoKeys(driver);
		pss = new PianoSoundSetting(driver);

	}

	@Test
	// Change sound #1
	public void tc01_changingSoundToClassicalGuitar() {
		pss.pianoSoundMenuBtn();
		pss.pianoSoundTypeBtn();
		pss.scrollDownPage(1);
		pss.choosingSoundsFromDd("CLASSICAL GUITAR");
		pk.playNote("c");
		pk.playNote("d");
		pk.playNote("e");

	}

	@Test
	// Change sound #2
	public void tc02_changingSoundToPanFlute() {
		pss.pianoSoundMenuBtn();
		pss.pianoSoundTypeBtn();
		pss.scrollDownPage(1);
		pss.choosingSoundsFromDd("PAN-FLUTE");
		pk.playNote("c");
		pk.playNote("d");
		pk.playNote("e");
	}

	@Test
	// Change sound #3
	public void tc03_changingSoundToSaxophone() {
		pss.pianoSoundMenuBtn();
		pss.pianoSoundTypeBtn();
		pss.scrollDownPage(1);
		pss.choosingSoundsFromDd("SAXOPHONE");
		pk.playNote("c");
		pk.playNote("d");
		pk.playNote("e");
	}

}
