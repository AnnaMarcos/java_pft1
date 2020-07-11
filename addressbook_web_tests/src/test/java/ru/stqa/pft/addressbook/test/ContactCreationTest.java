package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().returnToHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("Christian", "Silantyev",
            "25803 Anderson Ln", "8184306300", "annasilantyeva@gmail.com","Test1"),true);
    app.getNavigationHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before + 1);
    app.getSessionHelper().logout();


  }

}
