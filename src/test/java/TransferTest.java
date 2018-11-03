import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.demo.pages.InsuranceTravelPage;
import ru.aplana.demo.pages.MainPage;
import ru.aplana.demo.pages.TransferPage;
import ru.aplana.demo.steps.BaseSteps;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maria on 21.10.2018.
 */
public class TransferTest extends BaseSteps {

	@Test
	public void test() {
		MainPage mainPage = new MainPage();
		mainPage.selectMenuItem("Сервисы");
		mainPage.selectSubMenuItem("Переводы по карте/телефону");

		TransferPage transferPage = new TransferPage();
		transferPage.fillField(transferPage.from, "5406571518194617");
		transferPage.fillField(transferPage.to, "5367433138590699");

		transferPage.fillField(transferPage.cvc, "543");
		transferPage.fillField(transferPage.month, "11");
		transferPage.fillField(transferPage.year, "20");
		transferPage.fillField(transferPage.amount, "5");

		assertEquals("Минимальная сумма перевода – 10 р.", transferPage.error.getText());

	}


	@Test
	public void testInsurance() {
		MainPage mainPage = new MainPage();
		mainPage.selectMenuItem("Страхование");
		new WebDriverWait(BaseSteps.getDriver(), 10)
			.until(ExpectedConditions.visibilityOf(mainPage.travelMenu)).click();


		InsuranceTravelPage insuranceTravelPage = new InsuranceTravelPage();
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("return arguments[0].scrollIntoView(true);", insuranceTravelPage.requestBtn);
		insuranceTravelPage.requestBtn.click();
		insuranceTravelPage.fillField(insuranceTravelPage.surname, "Иванов");
		insuranceTravelPage.fillField(insuranceTravelPage.name, "Иван");
		insuranceTravelPage.fillField(insuranceTravelPage.middleName, "Иванович");
		insuranceTravelPage.fillField(insuranceTravelPage.phone, "9102232372");
		insuranceTravelPage.fillField(insuranceTravelPage.email, "test@mail.ru");
		insuranceTravelPage.fillField(insuranceTravelPage.code, "1123");
		insuranceTravelPage.fillField(insuranceTravelPage.date, "11111990");
		js.executeScript("return arguments[0].scrollIntoView(true);", insuranceTravelPage.checkBox);
		insuranceTravelPage.checkBox.click();
		Assert.assertTrue(insuranceTravelPage.submit.isEnabled());
	}


	@Test
	@Ignore
	public void testUpload(){
		WebDriver driver = BaseSteps.getDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("http://countwordsfree.com/xmlviewer");
		driver.findElement(By.name("qqfile")).sendKeys("C:\\MBaykova\\homework 14 мая\\raiffeizendemo\\src\\main\\resources\\example.xml");
		driver.findElement(By.xpath("//button[@value='validate']")).click();
	}




}
