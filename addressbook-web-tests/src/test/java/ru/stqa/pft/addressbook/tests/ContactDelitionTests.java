package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Nechepurenko on 16.04.2017.
 */
public class ContactDelitionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.db().contacts().size() == 0) {
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

    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));

  }


}
