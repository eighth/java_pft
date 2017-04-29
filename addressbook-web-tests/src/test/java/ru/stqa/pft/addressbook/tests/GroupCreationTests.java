package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    //Количество групп до добавления
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("test01", null, null));
    //количество групп после добавления
    int after = app.getGroupHelper().getGroupCount();
    //количество групп после, должно совпадать с количеством групп до + 1
    Assert.assertEquals(after, before + 1);
  }

}
