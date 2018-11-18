package ru.aplana.demo.steps;

import cucumber.api.java.en.When;
import ru.aplana.demo.pages.MainPage;

/**
 * Created by mbaykova on 14.11.2018
 */
public class MainSteps {

    MainPage mainPage = new MainPage();

    @When("выбран пункт меню \"(.*)\"")
    public void selectMenuItem(String itemName){
        mainPage.selectMenuItem(mainPage.mainMenu, itemName);
    }

    @When("выбран пункт верхнего меню \"(.*)\"")
    public void selectSubMenuItem(String itemName){
        mainPage.selectMenuItem(mainPage.topMenu, itemName);
    }


    @When("^закрыто всплывающее окно$")
    public void closeBunner() {
        mainPage.click(mainPage.closeBtn);
    }
}
