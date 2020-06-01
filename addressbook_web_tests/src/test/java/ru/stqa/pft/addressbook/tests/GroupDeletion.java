package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.*;
import ru.stqa.pft.addressbook.tests.TestBase;

public class GroupDeletion extends TestBase {


  @Test
  public void testGroupDeletion() throws Exception {

    app.gotoGroupPage();
    app.selectGroup();
    app.deleteSelectedGroup();
    app.returnToGroupPage();
  }

}
