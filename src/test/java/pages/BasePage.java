package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
	}

	protected void fillText(WebElement el, String text) {
		el.clear();
		el.sendKeys(text);
	}

	protected void click(WebElement el) {
		// Highlight in the future
		highlightElement(el, "blue", "pink");
		el.click();
		StopHighlightElement(el);
		pause(2000);

	}

	public String getText(WebElement el) {
		return el.getText();
	}

	public void pause(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void clickableWait(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}

	protected void waitForelementVisible(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	protected void waitForelementInvisible(WebElement el) {
		wait.until(ExpectedConditions.invisibilityOf(el));
	}

	public void scrollDown350() {
		js.executeScript("window.scrollBy(0, 350)"); // Scroll down by 350 pixels
	}

	public void scrollUp350() {
		js.executeScript("window.scrollBy(0, -350)"); // Scroll down by -350 pixels
	}

	public void scrollDown200() {
		js.executeScript("window.scrollBy(0, 200)"); // Scroll down by 100 pixels
	}

	public void scrollUp200() {
		js.executeScript("window.scrollBy(0, -200)"); // Scroll down by 100 pixels
	}

	public void scrollDown1000() {
		js.executeScript("window.scrollBy(0, 1000)"); // Scroll down by 100 pixels
	}

	public void scrollToElementAndClick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		click(element);

	}

	protected void highlightElement(WebElement element, String color, String bgColor) {
		// keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "border: 1px solid " + color + ";background-color:" + bgColor + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

	}

	protected void StopHighlightElement(WebElement element) {
		String originalStyle = element.getAttribute("style");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Change the style back after few milliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},0);", element);

	}

	public void scrollDownPage(int times) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i < times; i++) {
			js.executeScript("window.scrollBy(0, 350);"); // Adjust the scroll amount as needed
			pause(1000);
		}
	}

	public void scrollUpPage(int times) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i < times; i++) {
			js.executeScript("window.scrollBy(0, -350);"); // Adjust the scroll amount as needed
			pause(1000);
		}
	}

}
