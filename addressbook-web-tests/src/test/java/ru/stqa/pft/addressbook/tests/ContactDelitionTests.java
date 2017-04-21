package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Nechepurenko on 16.04.2017.
 */
public class ContactDelitionTests extends TestBase {

  @Test

  public void testContactDelition() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().checkContact();
    app.getContactHelper().submitDeletionContact();
    app.getContactHelper().applyAlert();
  }
}
