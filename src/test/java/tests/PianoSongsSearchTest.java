package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.PianoPage;

public class PianoSongsSearchTest extends BaseTest {
	PianoPage pp;

	@BeforeMethod
	public void setUp() {
		// Initialize the PianoPage object here
		pp = new PianoPage(driver);
	}

	@Test
	public void tc01_SearchSong01() {
		pp.SearchSongsBtn();
		pp.fillTextSongsFromSearch("expert");
		pp.SelectedSongBtn(6);
		pp.playingTheSongAfterSearch();
		pp.stopPlayingSongThatSearched();

	}

	@Test
	public void tc02_SearchSong02() {
		pp.SearchSongsBtn();
		pp.fillTextSongsFromSearch("unforgiven");
		pp.SelectedSongBtn(1);
		pp.playingTheSongAfterSearch();
		pp.stopPlayingSongThatSearched();

	}

	@Test
	public void tc03_restartTheSong() {
		pp.SearchSongsBtn();
		pp.fillTextSongsFromSearch("Sting");
		pp.SelectedSongBtn(1);
		pp.playingTheSongAfterSearch();
		pp.restartPlayingSongThatSearched();
		pp.playingTheSongAfterSearch();
		pp.stopPlayingSongThatSearched();

	}

	@Test
	public void tc04_SearchSong03() {
		pp.SearchSongsBtn();
		pp.fillTextSongsFromSearch("disney");
		String expected = "nothing found";
		String actual = pp.getMessageNoSongFound();
		assertEquals(actual, expected);

	}

}
