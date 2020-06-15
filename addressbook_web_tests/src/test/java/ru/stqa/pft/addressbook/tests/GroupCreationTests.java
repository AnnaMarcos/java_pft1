package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();//added verification: number of groups before creation new one
    app.getGroupHelper().createGroup(new ContactData.GroupData("test1", "test2", "test3"));
    int after = app.getGroupHelper().getGroupCount(); //added verification: number of groups after creation new one
    Assert.assertEquals(after,before + 1); // verification: after num = before num + one created

  }
}


