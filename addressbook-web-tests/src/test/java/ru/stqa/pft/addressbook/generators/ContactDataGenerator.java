package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nigor on 22.05.2017.
 */
public class ContactDataGenerator {
  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts(count);
    save(contacts, file);
  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
              contact.getFirstName(),
              contact.getMiddleName(),
              contact.getLastName(),
              contact.getNickname(),
              contact.getTitle(),
              contact.getCompany(),
              contact.getAddress(),
              contact.getHome(),
              contact.getMobile(),
              contact.getWork()));//10
    }
    writer.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData()
              .withFirstName(String.format("First %s", i))
              .withMiddleName(String.format("Middle %s", i))
              .withLastName(String.format("Last %s", i))
              .withNickname(String.format("Nick %s", i))
              .withTitle(String.format("Title %s", i))
              .withCompany(String.format("Company %s", i))
              .withAddress(String.format("Address %s", i))
              .withHome(String.format("Home %s", i))
              .withMobile(String.format("Mobile %s", i))
              .withWork(String.format("Work %s", i)));
    }
    return contacts;
  }
}
