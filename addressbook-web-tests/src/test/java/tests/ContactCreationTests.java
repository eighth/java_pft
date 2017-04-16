package tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initCreationContact();
    app.getContactHelper().fillContactForm(new ContactData("test01", "test02", "test03", "test04", "test05", "test06", "test07", "test08", "test09", "test10", "test11", "test12@e-mail.ru", "test13@e-mail.ru", "test14@e-mail.ru", "test15.ru", "1961", "1965", "test16.", "test17", "test18"));
    app.getContactHelper().submitCreationContact();
    app.getContactHelper().returnToHomePage();
  }

}
