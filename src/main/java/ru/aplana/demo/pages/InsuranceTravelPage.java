package ru.aplana.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Maria on 22.10.2018.
 */
public class InsuranceTravelPage extends BasePageObject {

	@FindBy(xpath = "(//a[text()='Оставить заявку'][@class='button'])[1]")
	public WebElement requestBtn;

	@FindBy(xpath = "//input[@placeholder='Фамилия']")
	public WebElement surname;

	@FindBy(xpath = "//input[@placeholder='Имя']")
	public WebElement name;

	@FindBy(xpath = "//input[@placeholder='Отчество']")
	public WebElement middleName;

	@FindBy(xpath = "//input[@placeholder='Дата Рождения']")
	public WebElement date;

	@FindBy(xpath = "//input[@sys_name='phone']")
	public WebElement phone;

	@FindBy(xpath = "//input[@placeholder='Электронная почта']")
	public WebElement email;

	@FindBy(xpath = "//input[@placeholder='Проверочный код']")
	public WebElement code;

	@FindBy(xpath = "//label[contains(@class,'checkbox-block__label')]//span")
	public WebElement checkBox;

	@FindBy(xpath = "//button[@id='btn_submit']")
	public WebElement submit;

}
