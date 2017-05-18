package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/javapft.png");
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
            .withNotes("test18")
            .withPhoto(photo);
    app.contact().create(contact,true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/javapft.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}
