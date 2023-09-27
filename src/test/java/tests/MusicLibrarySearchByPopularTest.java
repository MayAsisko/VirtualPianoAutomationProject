package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.MenuPage;
import pages.MusicSheetsPage;
import pages.PianoPage;
import pages.SelectedGenreMusicPage;
import pages.SelectedSongPage;

public class MusicLibrarySearchByPopularTest extends BaseTest {
	MenuPage mp;
	SelectedGenreMusicPage sgmp;
	SelectedSongPage ssp;
	PianoPage pp;
	MusicSheetsPage msp;

	@BeforeMethod
	public void setUp() {
		// Initialize the PianoPage object here
		mp = new MenuPage(driver);
		sgmp = new SelectedGenreMusicPage(driver);
		ssp = new SelectedSongPage(driver);
		pp = new PianoPage(driver);
		msp = new MusicSheetsPage(driver);
	}

	@Test
	public void tc01_PlayASongFromPopularCategory1() {
		mp.clickMusicSheetsWindow();
		openWindowAndGetHandles();
		MusicSheetsPage msp = new MusicSheetsPage(driver);
		msp.scrollDownPage(1);
		msp.clickOnAPopularCategory("Pop");
		msp.pause(3000);
		openWindowAndGetHandles();
		sgmp.scrollDownPage(2);
		sgmp.chooseSongFromList("I'm Not The Only One (Sam Smith)");
		openWindowAndGetHandles();
		ssp.pause(3000);
		ssp.scrollDownPage(7);
		ssp.playSelectedSong();
		openWindowAndGetHandles();
		pp.playingTheSongAfterSearch();
		pp.stopPlayingSongThatSearched();

	}

	@Test
	public void tc02_PlayASongFromPopularCategory2() {
		mp.clickMusicSheetsWindow();
		openWindowAndGetHandles();
		msp.scrollDownPage(2);
		msp.clickOnAPopularCategory("Disney");
		msp.pause(3000);
		openWindowAndGetHandles();
		sgmp.scrollDownPage(2);
		sgmp.chooseSongFromList("Under The Sea (Intermediate)");
		openWindowAndGetHandles();
		ssp.pause(3000);
		ssp.scrollDownPage(5);
		ssp.playSelectedSong();
		openWindowAndGetHandles();
		pp.playingTheSongAfterSearch();
		pp.stopPlayingSongThatSearched();

	}

}
