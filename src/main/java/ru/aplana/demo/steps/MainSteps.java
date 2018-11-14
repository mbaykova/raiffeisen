package ru.aplana.demo.steps;

import ru.aplana.demo.pages.MainPage;

/**
 * Created by mbaykova on 14.11.2018
 */
public class MainSteps {

    MainPage mainPage = new MainPage();

    public void selectMenuItem(String itemName){
        mainPage.selectMenuItem(mainPage.mainMenu, itemName);
    }

    public void selectSubMenuItem(String itemName){
        mainPage.selectMenuItem(mainPage.subMenu, itemName);
    }

    public void acceptRegion() {
        mainPage.click(mainPage.acceptRegion);
    }
}
