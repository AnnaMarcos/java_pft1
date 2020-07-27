package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().home();
    if (app.contact().list().size() == 0){
      app.contact().create(new ContactData().withlName("Silantyev").withfName("Christian")
              .withAddress("25803 Anderson Ln").withCellPhone("8184306300").withEmail("annasilantyeva@gmail.com")
              .withGroup("Test1"),true);
    }
  }

  @Test
  public void testContactDeletion() throws Exception {

    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    app.contact().deleteContact(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(),index);

    before.remove(index);
    Assert.assertEquals(before, after);





  }



}
