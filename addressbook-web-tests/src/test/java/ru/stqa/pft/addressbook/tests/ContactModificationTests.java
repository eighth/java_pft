package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by Nechepurenko on 16.04.2017.
 */
public class ContactModificationTests extends TestBase {

  @Test

  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData(
                      "test01",
                      "test02",
                      "test03",
                      "test04",
                      "test05"),
              true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initModificationContact(before.size() - 1);
    app.getContactHelper().fillContactForm(new ContactData(
                    "test011",
                    "test02",
                    "test03",
                    "test04",
                    "test05"),
            false);
    app.getContactHelper().submitModificationContact();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}