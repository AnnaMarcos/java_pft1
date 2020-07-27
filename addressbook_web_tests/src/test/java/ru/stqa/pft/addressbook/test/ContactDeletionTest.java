package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().home();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData().withlName("Silantyev").withfName("Christian")
              .withAddress("25803 Anderson Ln").withCellPhone("8184306300").withEmail("annasilantyeva@gmail.com")
              .withGroup("Test1"),true);
      app.contact().home();
    }
  }

  @Test
  public void testContactDeletion() throws Exception {

    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);





  }



}
