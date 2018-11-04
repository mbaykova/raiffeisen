import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;

/**
 * Created by Maria on 04.11.2018.
 */
public class TemplateTest extends BaseTest {


	@Test
	public void testTransfer() {
		HashMap<String, String> testData = new HashMap<>();
		testData.put("ФИО", "Сидоров Петр Иванович");
		testData.put("Телефон", "79101234567");

		WebDriver driver = getDriver();
		driver.get("https://online.raiffeisen.ru/demo/#/favourites");
		click(driver.findElement(By.xpath("//icon-close")));
		click(driver.findElement(By.xpath("//*[text()='Шаблоны и автоплатежи']")));

		selectInput(driver.findElement(By.xpath("//div[@class='template-create ng-star-inserted']")),
			"Мобильная связь");

		click(driver.findElement(By.xpath("//*[text()='Создать']")));
		fillField(driver.findElement(By.xpath("//*[text()='Номер телефона']/ancestor::div[@class='rc-row']//input[contains(@class,'input ')]")),
			testData.get("Телефон"));
		selectInput(driver.findElement(By.xpath("//*[text()='Оплатить с карты']/ancestor::*[@class='rc-row']//c-select")),
			"Дебетовка в рублях");

		fillField(driver.findElement(By.xpath("//div[@class='rc-row__value']//input[@placeholder='Сумма']")), "0");

		Assert.assertEquals("Сумма перевода должна быть больше 0",
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='rc-row__value']//simple-error")))).getText());

		fillField(driver.findElement(By.xpath("//div[@class='rc-row__value']//input[@placeholder='Сумма']")), "20000000000");
		Assert.assertEquals("Сумма операции превышает доступный баланс",
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='rc-row__value']//simple-error")))).getText());

		fillField(driver.findElement(By.xpath("//div[@class='rc-row__value']//input[@placeholder='Сумма']")), "100");

		scrollAndClick(driver.findElement(By.xpath("//icon-accept-checkbox/..")));

		fillField(driver.findElement(By.xpath("//div[contains(@class,'template__row-name')]//input")), "template");
		click(driver.findElement(By.xpath("//*[text()='Добавить шаблон в избранное']")));
		click(driver.findElement(By.xpath("//*[text()='Сохранить шаблон']/parent::button[@type='button']")));

		Assert.assertTrue("Не появилось сообщение шаблон сохранен",
			isElementPresent(By.xpath("//*[contains(text(), 'Шаблон успешно сохранен')]")));



	}

	@Override
	public void selectInput(WebElement element, String value) {
		element.click();
		element.findElement(By.xpath(".//*[contains(text(),'" + value + "')]")).click();
	}
}


