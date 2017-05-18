package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Nechepurenko on 16.05.2017.
 */
public class ContactInfoTests extends TestBase {

  @Test
  public void testContactInfo() {
    app.goTo().homePage();
    ContactData contact = app.contact().alls().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    app.contact().returnToHomePage();
    app.contact().infoContactById(contact.getId());
    String contactInfo = app.contact().contactDetails();
    assertThat(clean(contactInfo), equalTo(mergeAll(contactInfoFromEditForm)));
  }
  private String mergeName(ContactData contact) {
    return Arrays.asList(contact.getFirstName().replaceAll("\n", ""),contact.getLastName())
            .stream().filter(s -> !(s == null || s.equals("")))
            .map(ContactInfoTests::clean)
            .collect(Collectors.joining(" "));
  }

  private String mergeOther(ContactData contact) {
    return Arrays.asList(contact.getAddress(),
            contact.getHome(),
            contact.getMobile(),
            contact.getWork(),
            contact.geteMail(),
            contact.geteMail2(),
            contact.geteMail3())
            .stream().filter(s -> !(s == null || s.equals("")))
            .map(ContactInfoTests::clean).collect(Collectors.joining("\n"));
  }

  private String mergeAll(ContactData contact) {
    return Arrays.asList(mergeName(contact), mergeOther(contact)).stream().collect(Collectors.joining("\n"));
  }

  private static String clean(String contactInfo) {
    return contactInfo.replaceAll("[HMWP]: ", "")
            .replaceAll("Modify", "")
            .replaceAll("Print", "")
            .replaceAll("\n\n\n\n", "\n")
            .replaceAll("\n\n", "\n");

  }

}
