package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
        String xml = "";
        String line = reader.readLine();
        while (line != null) {
            xml += line;
            line = reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        List<ContactData> contacts = (List<ContactData>)xstream.fromXML(xml);
        return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
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
