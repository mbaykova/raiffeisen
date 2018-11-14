package ru.aplana.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Maria on 12.11.2018.
 */
public class MainPage extends BasePageObject{

	@FindBy(xpath = "//ul[@class='main-menu']//li")
	public List<WebElement> mainMenu;



	@FindBy(xpath = "//a[contains(@class,'menu-section-link')][@href]")
	public List<WebElement> subMenu;

	@FindBy(xpath = "//*[text()='Да']")
	public WebElement acceptRegion;



}

