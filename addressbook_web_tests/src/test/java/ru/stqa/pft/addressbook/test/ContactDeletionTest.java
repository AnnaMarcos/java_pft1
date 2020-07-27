package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.getContactHelper().returnToHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData( "Silantyev", "Christian",
              "25803 Anderson Ln", "8184306300", "annasilantyeva@gmail.com","Test1"),true);
    }
  }

  @Test
  public void testContactDeletion() throws Exception {

    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() -1;
    app.getContactHelper().deleteContact(index);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),index);

    before.remove(index);
    Assert.assertEquals(before, after);





  }



}
