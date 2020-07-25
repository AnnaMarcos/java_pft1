package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Christian", "Silantyev",
            "25803 Anderson Ln", "8184306300", "annasilantyeva@gmail.com","Test1");
    app.getContactHelper().createContact(contact,true);
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() + 1);
    app.getSessionHelper().logout();

    int max = 0;
    for (ContactData c : after){
      if (c.getId() > max) {
        max = c.getId();
      }
    }
    contact.setId(max);
    before.add (contact);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));



  }

}
