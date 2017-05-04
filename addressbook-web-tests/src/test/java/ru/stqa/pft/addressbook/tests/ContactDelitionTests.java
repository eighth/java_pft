package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by Nechepurenko on 16.04.2017.
 */
public class ContactDelitionTests extends TestBase {

  @Test

  public void testContactDelition() {
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
    app.getContactHelper().checkContact(before.size() - 1);
    app.getContactHelper().submitDeletionContact();
    app.getContactHelper().applyAlert();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }
}
