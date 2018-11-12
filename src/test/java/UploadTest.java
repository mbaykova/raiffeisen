import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;

/**
 * Created by Maria on 06.11.2018.
 */
public class UploadTest extends BaseTest {


	@Test
	@Ignore
	public void testUpload() {
		WebDriver driver = getDriver();
		driver.get("https://www.freeformatter.com/xml-formatter.html");
		File file = new File("src/main/resources/example.xml");
		WebElement inputFile = driver.findElement(By.id("xmlFile"));
		((RemoteWebElement) inputFile).setFileDetector(new LocalFileDetector());
		inputFile.sendKeys(file.getAbsolutePath());
		driver.findElement(By.xpath("//button[@title='Format the XML document']")).click();
	}
}
