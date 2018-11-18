package ru.aplana.demo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.aplana.demo.annotation.FieldName;
import ru.aplana.demo.util.DriverManager;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Maria on 12.11.2018.
 */
public class TransferResultPage extends BasePageObject {


	@FindBy(xpath = "//*[text()='ФИО получателя:']/following-sibling::div")
	@FieldName(name = "ФИО получателя")
	public WebElement fio;


	@FindBy(xpath = "//*[text()='Сумма перевода:']/following-sibling::div")
	@FieldName(name = "Сумма перевода")
	public WebElement amount;

	@FindBy(xpath = "//*[text()='Комиссия']/following-sibling::div")
	@FieldName(name = "Комиссия")
	public WebElement commission;



	@Override
	public WebElement getField(String name) throws Exception {
		return getField(name, "ru.aplana.demo.pages.TransferResultPage");
	}




}
