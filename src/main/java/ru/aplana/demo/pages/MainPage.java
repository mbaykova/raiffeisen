package ru.aplana.demo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Maria on 21.10.2018.
 */
public class MainPage extends BasePageObject{

	@FindBy(xpath = "//ul[@class='main-menu']//li")
	List<WebElement> mainMenu;



	@FindBy(xpath = "//a[contains(@class,'main-menu__link')][@href]")
	List<WebElement> subMenu;

	@FindBy(xpath = "//a[contains(@class,'menu-block__href')][contains(@href,'travel')]")
	public WebElement travelMenu;


	public void selectMenuItem(String itemName){
		selectMenuItem(mainMenu, itemName);
	}

	public void selectSubMenuItem(String itemName){
		selectMenuItem(subMenu, itemName);
	}


}
