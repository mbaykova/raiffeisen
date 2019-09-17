package ru.aplana.demo.steps;

import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import ru.aplana.demo.pages.DepositPage;
import ru.aplana.demo.util.DriverManager;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by mbaykova on 14.11.2018
 */
public class DepositSteps {

    DepositPage depositPage = new DepositPage();


    @When("поле \"(.*)\" заполняется значением \"(.*)\"")
    public void fillField(String name, String value) throws Exception {
        depositPage.fillField(name, value);
    }

    @When("значение поля \"(.*)\" равно \"(.*)\"")
    public void checkField(String name, String value) throws Exception {
        Assert.assertEquals(value, depositPage.getField(name).getAttribute("value"));
    }

    @When("поле \"(.*)\" доступно")
    public void checkIsEnabled(String name) throws Exception {
        Assert.assertTrue("Кнопка - "+ name +" не активна", depositPage.getField(name).isEnabled());
    }

    @When("выполнено нажатие на \"(.*)\"")
    public void click(String name) throws Exception {
        depositPage.click(name);
    }

    @When("выпадающий список \"(.*)\" заполняется значением \"(.*)\"")
    public void selectInput(String field, String value) throws Exception {
        depositPage.getField(field).click();
        depositPage.selectInput(depositPage.getField(field), value);
    }

    @When("поле \"(.*)\" присутствует")
    public void checkFieldIsPresent(String name)throws Exception{
        try {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            Assert.assertTrue(String.format("Элемент [%s] не видимый", name), depositPage.getField(name).isDisplayed());
        }catch (NoSuchElementException e){
            Assert.fail(String.format("Отсутствует элемент [%s]", name));
        }finally {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

    }


    @When("заполняются поля:")
    public void fillFields(Map<String,String> fields) throws Exception {
        fields.forEach(
            (k, v) -> {
                try {
                    fillField(k, v);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        );
    }


    @When("поля заполнены значениями:")
    public void checkfillFields(Map<String,String> fields) throws Exception {
        fields.forEach(
            (k, v) -> {
                try {
                    checkField(k, v);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        );
    }

}
