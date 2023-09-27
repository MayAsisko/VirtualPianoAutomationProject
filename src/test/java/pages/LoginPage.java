package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MenuPage{
	@FindBy(css = "#username")
	WebElement emailField;
	@FindBy(css = "#password")
	WebElement passwordField;
	@FindBy(css = "form > div.c5cafd14f > button")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void login(String email, String password) {
		fillText(emailField, email);
		fillText(passwordField, password);
		pause(2000);
		click(loginButton);
	}
}
