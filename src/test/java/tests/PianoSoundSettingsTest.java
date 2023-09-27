package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.PianoKeys;
import pages.PianoSoundSetting;

public class PianoSoundSettingsTest extends BaseTest {
	PianoSoundSetting pss;
	PianoKeys pk;

	@BeforeMethod
	public void setUp() {
		// Initialize the PianoPage object here
		pk = new PianoKeys(driver);
		pss = new PianoSoundSetting(driver);
	}

	@Test
	// Test that I get the correct message when midi is not connected
	public void tc01_isthereMidiConnection() {
		pss.pianoSoundMenuBtn();
		pss.MidiConnectionBtn();
		pss.isThereMidiConnection();
		String expected = "NO MIDI CONNECTED";
		String actual = pss.isThereMidiConnection();
		assertEquals(actual, expected);
		pss.closeSoundSettings();

	}

	@Test
	// Turn off sustain and play without sustain
	public void tc02_turnOffSustain() {
		pk.playNote("c");
		pk.playNote("d");
		pss.pianoSoundMenuBtn();
		pss.sustainOfforOn();
		pss.closeSoundSettings();
		pk.playNote("c");
		pk.playNote("d");

	}

	@Test
	// Turn on sustain and press the "-" 10 times
	public void tc03_turnOffSustainbyClickingMinus() {
		pk.playNote("c");
		pk.playNote("d");
		pss.pianoSoundMenuBtn();
		pss.sustainOfforOn();
		pss.lowerSustain(10);
		pss.closeSoundSettings();
		pk.playNote("c");
		pk.playNote("d");

	}

	@Test
	// Lower volume
	public void tc04_changeVolumeAndPlay() {
		pk.playNote("c");
		pk.playNote("d");
		pss.pianoSoundMenuBtn();
		pss.changeVolume(-5);
		pss.closeSoundSettings();
		pk.playNote("c");
		pk.playNote("d");
	}

	@Test
	// Lower volume to silent
	public void tc05_changeVolumeToMin() {
		pk.playNote("c");
		pk.playNote("d");
		pss.pianoSoundMenuBtn();
		pss.changeVolume(-50);
		pss.closeSoundSettings();
		pk.playNote("c");
		pk.playNote("d");
	}

	@Test
	// Return volume
	public void tc06_returnVolumeToNormal() {
		pk.playNote("c");
		pk.playNote("d");
		pss.pianoSoundMenuBtn();
		pss.changeVolume(2);
		pss.closeSoundSettings();
		pk.playNote("c");
		pk.playNote("d");
	}

	@Test
	// Test Metronome
	public void tc07_useMetronome() {
		pss.pianoSoundMenuBtn();
		pss.clickMetronmeBtn();
		pss.changeMetronomeSpeed(50);
		pss.getMetronomeBPM();
		pss.metronomePlayBtn();
		pss.changeMetronomeSpeed(25);
		pss.getMetronomeBPM();
		pss.changeMetronomeSpeed(40);
		pss.getMetronomeBPM();
		pss.closeMetronome();
	}

}
