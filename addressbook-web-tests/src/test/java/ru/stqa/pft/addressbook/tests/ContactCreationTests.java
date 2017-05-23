package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new ContactData()
                .withFirstName("First1")
                .withMiddleName("Middle1")
                .withLastName("Last1")
                .withNickname("Nick1")
                .withTitle("Title1")
                .withCompany("Company1")
                .withAddress("Address1")
                .withHome("Home1")
                .withMobile("Mobile1")
                .withWork("Work1")});
        list.add(new Object[]{new ContactData()
                .withFirstName("First2")
                .withMiddleName("Middle2")
                .withLastName("Last2")
                .withNickname("Nick2")
                .withTitle("Title2")
                .withCompany("Company2")
                .withAddress("Address2")
                .withHome("Home2")
                .withMobile("Mobile2")
                .withWork("Work2")});
        list.add(new Object[]{new ContactData()
                .withFirstName("First3")
                .withMiddleName("Middle3")
                .withLastName("Last3")
                .withNickname("Nick3")
                .withTitle("Title3")
                .withCompany("Company3")
                .withAddress("Address3")
                .withHome("Home3")
                .withMobile("Mobile3")
                .withWork("Work3")});
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/javapft.png");
//        ContactData contact = new ContactData()
//                .withFirstName(firstName)
//                .withMiddleName(middleName)
//                .withLastName(lastName)
//                .withNickname(nickname)
//                .withTitle(title)
//                .withCompany(company)
//                .withAddress(address)
//                .withHome(home)
//                .withMobile(mobile)
//                .withWork(work)
////              .withFax(name)
////              .witheMail("test12@e-mail.ru")
////              .witheMail2("test13@e-mail.ru")
////              .witheMail3("test14@e-mail.ru")
////              .withHomePage("test15.ru")
////              .withGroup("test02")
////              .withAddress("test16")
////              .withHome("test17")
////              .withNotes("test18")
//                .withPhoto(photo);
        app.contact().create(contact, true);
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
