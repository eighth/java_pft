package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Nechepurenko on 16.04.2017.
 */
public class GroupModificationTests extends TestBase {

  @Test

  public void testGroupModifiication() {
    app.getNavigationHelper().gotoGroupPage();
    //Количество групп до добавления
    int before = app.getGroupHelper().getGroupCount();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test01", null, null));
    }
    app.getGroupHelper().selectGroup(before - 1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test01", "test02", "test03"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    //количество групп после, должно совпадать с количеством групп до
    Assert.assertEquals(after, before);

  }
}
