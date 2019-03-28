/**
 * Created by Maria on 12.11.2018.
 */
package ru.aplana.demo.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.demo.annotation.FieldName;
import ru.aplana.demo.steps.BaseSteps;
import ru.aplana.demo.util.DriverManager;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Maria on 06.05.2017.
 */
public abstract class BasePageObject {
	WebDriverWait wait  = new WebDriverWait(DriverManager.getDriver(), 60);

	public BasePageObject() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public void fillField(WebElement field, String value){
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("return arguments[0].style.border='1px solid magenta';", field);
		field.clear();
		field.sendKeys(value);
		js.executeScript("return arguments[0].style.border='1px solid black';", field);
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

	public void fillField(String name, String value) throws Exception {
		WebElement element = getField(name);
		fillField(element, value);
	}

	public void click(String name) throws Exception {
		WebElement element = getField(name);
		click(element);
	}

	public WebElement getField(String name, String className) throws Exception {
		Class example = Class.forName(className);
		List<Field> fields = Arrays.asList(example.getFields());
		for (Field field : fields){
			if (field.getAnnotation(FieldName.class).name().equals(name)){
				return DriverManager.getDriver().findElement(By.xpath(field.getAnnotation(FindBy.class).xpath()));
			}
		}
		Assert.fail("Не объявлен элемент с наименованием " + name);
		return null;
	}

	public abstract WebElement getField(String name) throws Exception;

}

