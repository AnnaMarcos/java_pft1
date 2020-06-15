package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();//added verification: number of groups before deletion new one
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper(). createGroup( new ContactData.GroupData("test1", "test4", "test5"));
    }
    app.getGroupHelper().selectGroup(before -1);
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount(); //added verification: number of groups after deletion one group
    Assert.assertEquals(after,before - 1); // verification: after num = before num - one deleted


  }


}
