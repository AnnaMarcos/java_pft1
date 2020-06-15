package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase  {
  @Test
  public void testContactDeletion () {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getGroupHelper().isThereAContact()){
      app.getGroupHelper().createContact(new ContactData("Anna", "Marcos", "2580s Anderson Ln", "818-430-6300", "annasilantyeva@gmail.com", "test1"), true);
    }
    app.getGroupHelper().selectContact();
    app.getGroupHelper().deleteSelectedContact();
    app.getGroupHelper().submitContactDeletion();
    app.getNavigationHelper().gotoHomePage();


  }
}
