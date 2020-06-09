package ru.stqa.pft.addressbook;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new ContactData.GroupData("test1", "test2", "test3"));
    app.submitGroupCreation();
    app.returnToGroupPage();

  }


}


