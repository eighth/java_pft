package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by i.nechepurenko on 29.05.2017.
 */
public class AddContactGroupTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {

    app.goTo().groupPage();
    if (app.db().groups().size() == 0) {
      app.group().create(new GroupData().withName("test01"));
    }

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
                      .withAddress("test16")
                      .withHome("test17")
                      .withNotes("test18"),
              true);
    }
  }

  @Test
  public void testAddContactGroup() {
    ContactData contact = app.db().contacts().iterator().next();
    GroupData group;
    Groups groups = app.db().groups();

    if (groups.equals(contact.getGroups())) {
      app.group().create(new GroupData().withName("new_group"));
      groups = app.db().groups();
    }
    groups.removeAll(contact.getGroups());
    group = groups.iterator().next();

    app.goTo().homePage();
    app.contact().addContactGroups(contact, group);

    app.db().refresh(contact);
    assertThat(contact.getGroups(), hasItem(group));

  }
}