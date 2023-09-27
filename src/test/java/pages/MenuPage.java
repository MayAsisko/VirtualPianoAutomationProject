package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
	@FindBy(css = ".sf-menu>li:nth-child(2)>a")
	WebElement musicSheetsWindowBtn;
	

	public MenuPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickMusicSheetsWindow() {
		clickableWait(musicSheetsWindowBtn);
		click(musicSheetsWindowBtn);
	}
	

}
