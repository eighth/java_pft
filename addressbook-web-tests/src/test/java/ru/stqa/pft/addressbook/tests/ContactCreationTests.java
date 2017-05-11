package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData()
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
            .withGroup("test02")
            .withAddress("test16")
            .withHome("test17")
            .withNotes("test18");
    app.contact().create(contact,true);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byID = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after) ;
  }
}
