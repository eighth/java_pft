package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData(
                    "test01",
                    "test02",
                    "test03",
                    "test04",
                    "test05",
                    "test06",
                    "test07",
                    "test08",
                    "test09",
                    "test10",
                    "test11",
                    "test12@e-mail.ru",
                    "test13@e-mail.ru",
                    "test14@e-mail.ru",
                    "test15.ru",
                    "test16",
                    "test17",
                    "test18",
                    "test01"),
            true);
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }
}
