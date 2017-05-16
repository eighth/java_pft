package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Nechepurenko on 14.05.2017.
 */
public class ContactPhoneTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().alls().size() == 0) {
      app.contact().create(new ContactData()
                      .withFirstName("test01")
                      .withLastName("test03")
                      .withAddress("ковров пер. д (26) стр 1")
                      .withHome("+7 777 77 77")
                      .withMobile("333 33 33")
                      .withWork("8(888) 888 8888")
                      .witheMail("test12@e-mail.ru")
                      .witheMail2("test13@e-mail.ru")
                      .witheMail3("test14@e-mail.ru")
                      .withGroup("test01")
              ,true);
    }
  }
  @Test
  public void testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().alls().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome(), contact.getMobile(), contact.getWork())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
