package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.MenuPage;
import pages.MusicSheetsPage;
import pages.PianoPage;
import pages.SelectedGenreMusicPage;
import pages.SelectedSongPage;

public class MusicLibrarySearchByGenreTest extends BaseTest {
	MenuPage mp;
	MusicSheetsPage msp;
	SelectedGenreMusicPage sgmp;
	SelectedSongPage ssp;
	PianoPage pp;

	@BeforeMethod
	public void setUp() {
		// Initialize the PianoPage object here
		pp = new PianoPage(driver);
		mp = new MenuPage(driver);
		msp = new MusicSheetsPage(driver);
		sgmp = new SelectedGenreMusicPage(driver);
		ssp = new SelectedSongPage(driver);
	}

	@Test
	public void tc01_GoToLibraryAndChooseAsong() {
		mp.clickMusicSheetsWindow();
		openWindowAndGetHandles();
		msp.scrollDownPage(4);
		msp.clickToOpenListOfGenres();
		msp.chooseGenreFromList("Dance");
		openWindowAndGetHandles();
		sgmp.scrollDownPage(5);
		sgmp.chooseSongFromList("Better Off Alone");
		openWindowAndGetHandles();
		ssp.scrollDownPage(9);
		ssp.playSelectedSong();
		openWindowAndGetHandles();
		pp.playingTheSongAfterSearch();
		pp.stopPlayingSongThatSearched();

	}

	@Test
	public void tc02_GoToLibraryAndChooseAsong2() {
		mp.clickMusicSheetsWindow();
		openWindowAndGetHandles();
		msp.scrollDownPage(4);
		msp.clickToOpenListOfGenres();
		msp.chooseGenreFromList("Electronica");
		openWindowAndGetHandles();
		sgmp.scrollDownPage(3);
		sgmp.chooseSongFromList("Spooky Scary Skeletons");
		openWindowAndGetHandles();
		ssp.pause(3000);
		ssp.scrollDownPage(8);
		ssp.playSelectedSong();
		openWindowAndGetHandles();
		pp.playingTheSongAfterSearch();
		pp.stopPlayingSongThatSearched();

	}

}
