package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


public class NewContactCreationTests extends TestBase {

  @Test
  public void testNewContactCreation() throws Exception {
    app.getGroupHelper().gotoHomepage();
    List<ContactData>before = app.getGroupHelper().getContactList();
    //int before = app.getGroupHelper().getContactCount();
    app.getGroupHelper().addNewContact();
    app.getGroupHelper().fiiContactForm(new ContactData ("Anna", "Marcos", "2580s Anderson Ln", "818-430-6300", "annasilantyeva@gmail.com", "test1" ), true);
    app.getGroupHelper().submitContactForm();
    app.getGroupHelper().gotoHomepage();
    List<ContactData>after = app.getGroupHelper().getContactList();
    //int after = app.getGroupHelper().getContactCount();
    Assert.assertEquals(after.size(),before.size() +1);

  }
}



