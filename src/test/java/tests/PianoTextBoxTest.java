package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.PianoPage;
import pages.PianoTextBox;

public class PianoTextBoxTest extends BaseTest {
	PianoPage pp;
	PianoTextBox ptb;

	@BeforeMethod
	public void setUp() {
		// Initialize the PianoPage object here
		pp = new PianoPage(driver);
		ptb = new PianoTextBox(driver);
	}

	@Test
	// You can add what ever number or letter to play ([]=means chords, take from
	// Write random letters, numbers and specific special characters in the Text Box
	public void tc01_usingTextBox() {
		pp.clickEditBtnOnlyWhenBeingAtHomeStatus();
		ptb.clickEditBtnPencil();
		// Writing in the TextBox for Playing random notes
		ptb.textBoxPasteOrWrite("1 2 3 4 5 6 7");
		ptb.clickRenderSong();
		ptb.clickPlayBtn(3000);

	}

	@Test
	// the VirtualPiano Library)
	public void tc02_usingThepasteOption1() {
		ptb.clickEditBtnPencil();
		// For example-Playing "Shallow" by lady GaGa-
		ptb.textBoxPasteOrWrite("\r\n"
				+ "6 [0t] o y [7r] [wyo]| [8tu]| w t| |8|\r\n"
				+ "6 0 [esj] [tsj] [7sj] [7h] r [8osf]| w u||w t|\r\n"
				+ "q t [is] [pg] [pg] [tpg] [ipg] [pg]\r\n"
				+ "[8pg] [wof] t [5sd]| [9f]d[ws] [ra]\r\n"
				+ "6 [0s] [ej] [tsj] [7h] w [rf]d[8os] w u||w t 8 4\r\n"
				+ "8 [qs] [epg] [tpg] [pg] [4qpg] [pg] [8tog]\r\n"
				+ "[wf] t [5wosd]| 9 w 5 [60uos]| |\r\n"
				+ "[7wryod]||[8wtuof]|||\r\n"
				+ "4 [8osh] [qosh] [eosh] [tosh] [og] 4 f\r\n"
				+ "[8osd] w [tf] [5wsd]| 9 [wd] s\r\n"
				+ "6 0 e t [7wrosh]||[8wtosf]||w| w t 8 4|\r\n"
				+ "[8osh] [qosh] [eosh] [tosh] g 4 f\r\n"
				+ "[8osd] w [tf] [5wd]| [9s] w 5\r\n"
				+ "[29gjc] [gjc] [gjc] [9ygjc]| [fjx]||\r\n"
				+ "[5wdhz] [dhz] [fhx] [wrydhz]| [sl] [5w]|\r\n"
				+ "[8tfhx] [fhx] [fhx] [hv] [7wr] [sfl]| [sfl]\r\n"
				+ "[60e] [fx]| |[6e]|\r\n");

		ptb.clickRenderSong();
		ptb.clickPlayBtn(10000);

	}


}
