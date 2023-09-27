package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.PianoKeys;

public class PianoKeysTest extends BaseTest {
	PianoKeys pk;

	@BeforeMethod
	public void setUp() {
		// Initialize the PianoPage object here
		pk = new PianoKeys(driver);
	}

	// Play notes on the piano + call the majorScale method
	@Test
	public void tc01_pianoKeysTest() {

		// play one note of choice (c,d,e,f,g,a,b)
		pk.playNote("b");
		pk.playNote("c");
		pk.playNote("a");

	}

	@Test
	public void tc02_pianoPlayingScaleTest() {

		// play a major scale (by using a method)
		pk.playMajorScale();

	}

}
