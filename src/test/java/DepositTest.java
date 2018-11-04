import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

/**
 * Created by Maria on 04.11.2018.
 */
public class DepositTest extends BaseTest {



	@Test
	public void testDeposit() {
		HashMap<String, String> testData = new HashMap<>();
		testData.put("Фамилия", "Иванов");
		testData.put("Имя", "Иван");
		testData.put("Отчество", "Иванович");
		testData.put("Дата рождения", "12.12.1992");
		testData.put("Телефон", "9101234567");
		testData.put("Город", "Москва");
		testData.put("Отделение", "Москва");

		WebDriver driver = getDriver();
		driver.get("https://www.raiffeisen.ru/");
		acceptRegion();
		click(driver.findElement(By.xpath("//ul[@class='main-menu']//a[text()='Вклады']")));
		click(driver.findElement(By.xpath("//*[text()='Накопительные счета']")));
		scrollAndClick(driver.findElement(By.xpath("//p[contains(text(),'На каждый день')]/ancestor::div[@class='b-card__content']//*[text()='Открыть счет']")));
		click(driver.findElement(By.xpath("//a[text()='Оставить заявку'][@class='button']")));

		Assert.assertEquals("На каждый день", driver.findElement(By.xpath("//*[text()='Накопительный счет']/parent::div/div")).getText());
		fillField(driver.findElement(By.xpath("//*[text()='Фамилия']/parent::div/input")), testData.get("Фамилия"));
		fillField(driver.findElement(By.xpath("//*[text()='Имя']/parent::div/input")), testData.get("Имя"));
		fillField(driver.findElement(By.xpath("//*[text()='Отчество']/parent::div/input")), testData.get("Отчество"));
		fillField(driver.findElement(By.xpath("//*[text()='Дата рождения']/parent::div/input")), testData.get("Дата рождения"));
		fillField(driver.findElement(By.xpath("//*[text()='Телефон']/parent::div/input")), testData.get("Телефон"));

		Assert.assertTrue("Кнопка - Выслать код не активна",
			driver.findElement(By.xpath("//*[text()='Выслать код']")).isEnabled());


		selectInput(driver.findElement(By.xpath("//*[text()='Город']/parent::div/div")), "Москва");
		selectInput(driver.findElement(By.xpath("//*[text()='Отделение банка']/parent::div/div")),
			"732, дополнительный офис «Отделение «Бескудниково»");

		Assert.assertTrue("Не найден элмент - Осталось заполнить: Телефон",
			isElementPresent(By.xpath("//div[@class='page-item__invalid'][.//div[text()='Осталось заполнить поля:']]//span[text()='Телефон']")));


	}




}
