package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Nechepurenko on 15.05.2017.
 */
public class ContactEmailTests extends TestBase{
  @Test
  public void testContactEmails() {
    app.goTo().homePage();
    ContactData contact = app.contact().alls().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    
    assertThat(contact.getAllEMails(), equalTo(mergeEMails(contactInfoFromEditForm)));
  }

  private String mergeEMails(ContactData contact) {
    return Arrays.asList(contact.geteMail(), contact.geteMail2(), contact.geteMail3())
            .stream().filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
  }


}
