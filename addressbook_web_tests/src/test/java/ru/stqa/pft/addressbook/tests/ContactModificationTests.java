package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactModificationTests  extends TestBase {

  @Test
  public void testContactModification () {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getGroupHelper().isThereAContact()){
      app.getGroupHelper().createContact(new ContactData("Anna", "Marcos", "2580s Anderson Ln", "818-430-6300", "annasilantyeva@gmail.com", "test1"), true);
    }
    int before = app.getGroupHelper().getContactCount();
    app.getGroupHelper().editContact(before - 1);
    app.getGroupHelper().fiiContactForm(new ContactData("Anuta", "Ivanova", "25803 Anderson Ln", "818-430-6311", "annasilantyeva@yahoo.com", null), false);
    app.getGroupHelper().submitContactUpdate();
    app.getGroupHelper().gotoHomepage();
    int after = app.getGroupHelper().getContactCount();
    Assert.assertEquals(after,before);
  }


}