package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

/**
 * Created by Nechepurenko on 16.04.2017.
 */
public class ContactDelitionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstName("test01")
              .withMiddleName("test02")
              .withLastName("test03")
              .withNickname("test04")
              .withTitle("test05")
              .withCompany("test06")
              .withAddress("test07")
              .withHome("test08")
              .withMobile("test09")
              .withWork("test10")
              .withFax("test11")
              .witheMail("test12@e-mail.ru")
              .witheMail2("test13@e-mail.ru")
              .witheMail3("test14@e-mail.ru")
              .withHomePage("test15.ru")
              .withGroup("test01")
              .withAddress("test16")
              .withHome("test17")
              .withNotes("test18"),
              true);
    }
  }

  @Test

  public void testContactDelition() {

    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }


}
