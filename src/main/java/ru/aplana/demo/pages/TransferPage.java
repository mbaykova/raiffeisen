package ru.aplana.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Maria on 21.10.2018.
 */
public class TransferPage extends BasePageObject {

	@FindBy(xpath = "//input[@placeholder='Номер карты отправителя']")
	public WebElement from;

	@FindBy(xpath = "//input[@placeholder='Номер карты получателя']")
	public WebElement to;

	@FindBy(xpath = "//input[@placeholder='ММ']")
	public WebElement month;

	@FindBy(xpath = "//input[@placeholder='ГГ']")
	public WebElement year;

	@FindBy(xpath = "//input[@placeholder='CVC2']")
	public WebElement cvc;

	@FindBy(xpath = "//input[contains(@placeholder,'Сумма перевода')]")
	public WebElement amount;


	@FindBy(xpath = "//input[contains(@placeholder,'Сумма перевода')]//following-sibling::div[@class='c2c__error']")
	public WebElement error;


}
