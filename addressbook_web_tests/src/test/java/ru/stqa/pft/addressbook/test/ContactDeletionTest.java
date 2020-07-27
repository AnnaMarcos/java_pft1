package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase{


  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().returnToHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Christian", "Silantyev",
              "25803 Anderson Ln", "8184306300", "annasilantyeva@gmail.com","Test1"),true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().returnToHomePage();
    app.getContactHelper().selectContact(before.size() -1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().verifyContactDeletion();
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() - 1);

    before.remove(before.size() -1);
    Assert.assertEquals(before, after);





  }

}
