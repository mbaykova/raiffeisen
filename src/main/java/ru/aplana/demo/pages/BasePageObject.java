/**
 * Created by Maria on 12.11.2018.
 */
package ru.aplana.demo.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.demo.steps.BaseSteps;
import ru.aplana.demo.util.DriverManager;

import java.util.List;


/**
 * Created by Maria on 06.05.2017.
 */
public class BasePageObject {
	WebDriverWait wait  = new WebDriverWait(DriverManager.getDriver(), 60);

	public BasePageObject() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public void fillField(WebElement field, String value){
		field.clear();
		field.sendKeys(value);
	}

	public void click(WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}

	public void selectMenuItem(List<WebElement> menuItems, String itemName){
		for (WebElement item : menuItems ){
			if (item.getText().equalsIgnoreCase(itemName)){
				item.click();
				return;
			}
		}
		Assert.fail("Не найден элмент коллеции - " + itemName);
	}

	public void selectInput(WebElement element, String value) {
		element.click();
		element.findElement(By.xpath(".//div[contains(@class,'choices__item')][contains(text(),'" + value + "')]")).click();
	}

	public void scrollAndClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("return arguments[0].scrollIntoView(false);", element);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

}

