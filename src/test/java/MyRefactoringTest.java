import org.junit.Assert;
import org.junit.Test;
import ru.aplana.demo.pages.DepositListPage;
import ru.aplana.demo.pages.DepositPage;
import ru.aplana.demo.pages.MainPage;
import ru.aplana.demo.steps.BaseSteps;

import java.util.HashMap;

/**
 * Created by Maria on 12.11.2018.
 */
public class MyRefactoringTest extends BaseSteps {


//	@Test
//	public void testMethod(){
//		HashMap<String, String> testData = new HashMap<>();
//		testData.put("Фамилия", "Иванов");
//		testData.put("Имя", "Иван");
//		testData.put("Отчество", "Иванович");
//		testData.put("Дата рождения", "12121992");
//		testData.put("Телефон", "9101234567");
//		testData.put("Город", "Москва");
//		testData.put("Отделение", "732, дополнительный офис «Отделение «Бескудниково»");
//
//		HashMap<String, String> testCheckData = new HashMap<>();
//		testCheckData.put("Дата рождения", "12.12.1992");
//		testCheckData.put("Телефон", "+7 (910) 123-45-67");
//
//		MainPage mainPage = new MainPage();
//		mainPage.acceptRegion();
//		mainPage.selectMenuItem("Вклады");
//		mainPage.selectSubMenuItem("Накопительные счета");
//
//		DepositListPage depositListPage = new DepositListPage();
//		depositListPage.openDeposit("На каждый день");
//
//		DepositPage depositPage = new DepositPage();
//		depositPage.click(depositPage.requestBtn);
//		depositPage.fillField(depositPage.surname, testData.get("Фамилия"));
//		depositPage.fillField(depositPage.name, testData.get("Имя"));
//		depositPage.fillField(depositPage.middleName, testData.get("Отчество"));
//		depositPage.fillField(depositPage.birthDate, testData.get("Дата рождения"));
//		depositPage.fillField(depositPage.phone, testData.get("Телефон"));
//
//
//		Assert.assertEquals(testCheckData.get("Дата рождения"), depositPage.birthDate.getAttribute("value"));
//		Assert.assertEquals(testCheckData.get("Телефон"), depositPage.phone.getAttribute("value"));
//
//		Assert.assertTrue("Кнопка - Выслать код не активна", depositPage.sentCode.isEnabled());
//
//		depositPage.selectInput(depositPage.city, "Москва");
//		depositPage.selectInput(depositPage.bank, testData.get("Отделение"));
//
//
//
//	}
}
