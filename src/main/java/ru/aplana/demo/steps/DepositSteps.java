package ru.aplana.demo.steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import ru.aplana.demo.pages.DepositPage;
import ru.aplana.demo.pages.MainPage;

/**
 * Created by mbaykova on 14.11.2018
 */
public class DepositSteps {

    DepositPage depositPage = new DepositPage();


    public void fillField(String name, String value) throws Exception {
        depositPage.fillField(name, value);
    }

    public void checkField(String name, String value) throws Exception {
        Assert.assertEquals(value, depositPage.getFiled(name).getAttribute("value"));
    }

    public void checkIsEnabled(String name) throws Exception {
        Assert.assertTrue("Кнопка - "+ name +" не активна", depositPage.getFiled(name).isEnabled());
    }

    public void click(String name) throws Exception {
        depositPage.click(name);
    }

}
