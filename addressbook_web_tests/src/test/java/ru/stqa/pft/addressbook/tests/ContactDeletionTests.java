package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionTests extends TestBase  {
  @Test
  public void testContactDeletion () {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getGroupHelper().isThereAContact()){
      app.getGroupHelper().createContact(new ContactData("Anna", "Marcos", "2580s Anderson Ln", "818-430-6300", "annasilantyeva@gmail.com", "test1"), true);
    }
    List<ContactData> before = app.getGroupHelper().getContactList();
    //int before = app.getGroupHelper().getContactCount();
    app.getGroupHelper().selectContact(before.size() - 1);
    app.getGroupHelper().deleteSelectedContact();
    app.getGroupHelper().submitContactDeletion();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData>after = app.getGroupHelper().getContactList();
    //int after = app.getGroupHelper().getContactCount();
    Assert.assertEquals(after.size(),before.size() -1);
  }
}
