package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.contact().home();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withlName("Fedorov"). withfName("Alex")
            .withAddress("25803 Anderson Ln").withCellPhone("8184306300") .withEmail("annasilantyeva@gmail.com")
            .withGroup("Test1");
    app.contact().create(contact,true);
    app.contact().home();
    List<ContactData> after = app.contact().list();
    int index = before.size() + 1;
    Assert.assertEquals(after.size(),index);

    before.add (contact);
    Comparator<? super ContactData> byId = (o1 , o2) -> Integer.compare(o1.getId(),o2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
