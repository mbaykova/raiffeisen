package ru.aplana.demo.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import ru.aplana.demo.annotation.FieldName;
import ru.aplana.demo.util.DriverManager;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Maria on 12.11.2018.
 */
public class DepositPage extends BasePageObject {

	@FindBy(xpath = "//a[text()='Оставить заявку'][@class='button']")
	@FieldName(name = "Оставить заявку")
	public WebElement requestBtn;

	@FindBy(xpath = "//*[text()='Фамилия']/parent::div/input")
	@FieldName(name = "Фамилия")
	public WebElement surname;

	@FindBy(xpath = "//*[text()='Имя']/parent::div/input")
	@FieldName(name = "Имя")
	public WebElement name;

	@FindBy(xpath = "//*[text()='Отчество']/parent::div/input")
	@FieldName(name = "Отчество")
	public WebElement middleName;

	@FindBy(xpath = "//*[text()='Дата рождения']/ancestor::div/input")
	@FieldName(name = "Дата рождения")
	public WebElement birthDate;

	@FindBy(xpath = "//*[text()='Телефон']/ancestor::div/input")
	@FieldName(name = "Телефон")
	public WebElement phone;

	@FindBy(xpath = "//*[text()='Город']/ancestor::div[@class='form-group text-field']/div[2]")
	@FieldName(name = "Город")
	public WebElement city;

	@FindBy(xpath = "//*[text()='Отделение банка']/parent::div/div")
	@FieldName(name = "Отделение банка")
	public WebElement bank;

	@FindBy(xpath = "//*[text()='Выслать код']")
	@FieldName(name = "Выслать код")
	public WebElement sentCode;

	@FindBy(xpath = "//div[@class='page-item__invalid'][.//div[text()='Осталось заполнить поля:']]//span[text()='Телефон']")
	@FieldName(name = "Осталось заполнить Телефон")
	public WebElement notFilledField;



	@FindBy(xpath = "//*[contains(text(),'подтверждаю')]/..")
	@FieldName(name = "Я подтверждаю")
	public WebElement acceptCheckBox;

	@FindBy(xpath = "//*[text()='Фамилия, Имя и Отчество']/ancestor::div[contains(@class,'form-group')]//input[2]")
	@FieldName(name = "Фамилия, Имя и Отчество")
	public WebElement fio;

	@Step("поле {0} заполняется значением {1}")
	public void fillField(String name, String value) {
		WebElement element = getField(name);
		fillField(element, value);
	}

	public void click(String name) {
		WebElement element = getField(name);
		click(element);
	}

	public WebElement getField(String name) {
		WebElement element = null;
		switch (name) {
			case "Оставить заявку":
				element = requestBtn;
				break;
			case "Фамилия":
				element = surname;
				break;
			case "Фамилия, Имя и Отчество":
				element = fio;
				break;
			case "Имя":
				element = this.name;
				break;
			case "Отчество":
				element = middleName;
				break;
			case "Дата рождения":
				element = birthDate;
				break;
			case "Телефон":
				element = phone;
				break;
			case "Город":
				element = city;
				break;
			case "Отделение банка":
				element = bank;
				break;
			case "Выслать код":
				element = sentCode;
				break;
			case "Осталось заполнить Телефон":
				element = notFilledField;
				break;
			case "Я подтверждаю":
				element = acceptCheckBox;
				break;
			default:
				Assert.fail("Не объявлен элемент с наименованием " + name);
				break;
		}
		return element;
	}




}
