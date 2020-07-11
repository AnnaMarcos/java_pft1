package ru.stqa.pft.addressbook.test;

import org.testng.annotations.*;

public class ContactDeletionTest extends TestBase{


  @Test
  public void testContactDeletion() throws Exception {

    app.getNavigationHelper().returnToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().verifyContactDeletion();
    app.getNavigationHelper().returnToHomePage();
  }


}
