package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData(
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
            "test01");
    app.getContactHelper().createContact(contact,true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;
    for (ContactData c : after) {
      if (c.getId() > max) {
        max = c.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)) ;
  }
}
