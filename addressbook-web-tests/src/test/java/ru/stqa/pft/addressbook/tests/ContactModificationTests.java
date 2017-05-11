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
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
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

  public void testContactModification() {

    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData()
            .withId(before.get(index).getId())
            .withFirstName("test03")
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
            .withAddress("test16")
            .withHome("test17")
            .withNotes("test18");
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byID = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after) ;
  }


}