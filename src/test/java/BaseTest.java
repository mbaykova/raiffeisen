import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maria on 06.05.2017.
 */
public class BaseTest {
	WebDriverWait wait;
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	@Before
	public void startScenario() {
		System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
		driver = new ChromeDriver();
		wait  = new WebDriverWait(driver, 60);
		driver.get("https://www.raiffeisen.ru/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@After
	public void afterMethod() {
		driver.quit();
	}

	public void click(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}

	public void scrollAndClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("return arguments[0].scrollIntoView(false);", element);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}


	public void fillField(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void selectInput(WebElement element, String value) {
		element.click();
		element.findElement(By.xpath(".//div[contains(@class,'choices__item')][contains(text(),'" + value + "')]")).click();
	}

	public boolean isElementPresent(WebElement element) {
		getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			getDriver().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		}
	}

	public void acceptRegion() {
		click(getDriver().findElement(By.xpath("//*[text()='Да']")));
	}


}
