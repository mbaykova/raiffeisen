import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

/**
 * Created by Maria on 04.11.2018.
 */
public class TransferTest extends BaseTest {


	@Test
	public void testTransfer() {
		HashMap<String, String> testData = new HashMap<>();
		testData.put("ФИО", "Сидоров Петр Иванович");
		testData.put("Телефон", "79101234567");

		WebDriver driver = getDriver();
		driver.get("https://online.raiffeisen.ru/demo/#/favourites");
		click(driver.findElement(By.xpath("//icon-close")));
		click(driver.findElement(By.xpath("//*[text()='Перевести']")));
		click(driver.findElement(By.xpath("//*[text()='Клиенту банка']")));

		selectInput(driver.findElement(By.xpath("//*[text()='Счет списания']/ancestor::ruble-transfer-form-account//div[@class='rc-row__value']")),
			"Сбережения в рублях");

		click(driver.findElement(By.xpath("//*[text()='По номеру телефона']")));
		fillField(driver.findElement(By.xpath("//*[text()='Номер телефона получателя']/ancestor::div[@class='rc-row ng-star-inserted']//input[contains(@class,'input ')]")),
			testData.get("Телефон"));

		fillField(driver.findElement(By.xpath("//div[@class='rc-row__value']//input[@placeholder='Сумма']")), "0");

		Assert.assertEquals("Сидоров П.И.",
			driver.findElement(By.xpath("//*[text()='ФИО получателя']/ancestor::div[@class='rc-row ng-star-inserted']//div[contains(@class,'static-value')]")).getText());

		Assert.assertEquals("Сумма перевода должна быть больше 0",
			driver.findElement(By.xpath("//div[@class='rc-row__value']//simple-error")).getText());

		fillField(driver.findElement(By.xpath("//div[@class='rc-row__value']//input[@placeholder='Сумма']")), "20000000000");
		Assert.assertEquals("Введенная сумма превышает максимально допустимую (1 000 000,00 \u20BD)",
			driver.findElement(By.xpath("//div[@class='rc-row__value']//simple-error")).getText());

		fillField(driver.findElement(By.xpath("//div[@class='rc-row__value']//input[@placeholder='Сумма']")), "100");
		Assert.assertEquals("0,00 \u20BD",
			driver.findElement(By.xpath("//c-commission-ruble-transfer")).getText());

		fillField(driver.findElement(By.xpath("//textarea")), "test");

		click(driver.findElement(By.xpath("//*[text()='Перевести']/parent::button")));

		Assert.assertEquals(testData.get("Телефон"),
			driver.findElement(By.xpath("//*[text()='По номеру телефона:']/following-sibling::div")).getText());

		Assert.assertEquals(testData.get("ФИО"),
			driver.findElement(By.xpath("//*[text()='ФИО получателя:']/following-sibling::div")).getText());

		Assert.assertEquals("100,00 \u20BD",
			driver.findElement(By.xpath("//*[text()='Сумма перевода:']/following-sibling::div")).getText());

		Assert.assertEquals("Комиссия не взимается",
			driver.findElement(By.xpath("//*[text()='Комиссия']/following-sibling::div")).getText());


	}


}


