package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[] {new ContactData()
                .withFirstName(split[0])
                .withMiddleName(split[1])
                .withLastName(split[2])
                .withNickname(split[3])
                .withTitle(split[4])
                .withCompany(split[5])
                .withAddress(split[6])
                .withHome(split[7])
                .withMobile(split[8])
                .withWork(split[9])});
            line = reader.readLine();
        }
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
