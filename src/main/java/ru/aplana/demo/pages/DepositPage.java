package ru.aplana.demo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Maria on 12.11.2018.
 */
public class DepositPage extends BasePageObject {

	@FindBy(xpath = "//a[text()='Оставить заявку'][@class='button']")
	public WebElement requestBtn;

	@FindBy(xpath = "//*[text()='Фамилия']/parent::div/input")
	public WebElement surname;

	@FindBy(xpath = "//*[text()='Имя']/parent::div/input")
	public WebElement name;

	@FindBy(xpath = "//*[text()='Отчество']/parent::div/input")
	public WebElement middleName;

	@FindBy(xpath = "//*[text()='Дата рождения']/parent::div/input")
	public WebElement birthDate;

	@FindBy(xpath = "//*[text()='Телефон']/parent::div/input")
	public WebElement phone;

	@FindBy(xpath = "//*[text()='Город']/parent::div/div")
	public WebElement city;

	@FindBy(xpath = "//*[text()='Отделение банка']/parent::div/div")
	public WebElement bank;

	@FindBy(xpath = "//*[text()='Выслать код']")
	public WebElement sentCode;

	@FindBy(xpath = "//div[@class='page-item__invalid'][.//div[text()='Осталось заполнить поля:']]//span[text()='Телефон']")
	public WebElement notFilledField;




}
