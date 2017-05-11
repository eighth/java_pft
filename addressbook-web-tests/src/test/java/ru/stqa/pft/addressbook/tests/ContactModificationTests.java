package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Nechepurenko on 16.04.2017.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
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
    }
  }

  @Test

  public void testContactModification() {

    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(index).getId(),
            "test03",
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
            null);
    app.getContactHelper().modifyContact(index, contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byID = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after) ;
  }


}