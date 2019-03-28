package ru.aplana.demo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Maria on 12.11.2018.
 */
public class DepositListPage extends BasePageObject {


	@FindBy(xpath = "//div[@class='b-card__content']")
	public List<WebElement> depositCollection;


	@Override
	public WebElement getField(String name) throws Exception {
		return getField(name, "ru.aplana.demo.pages.DepositListPage");
	}
}
