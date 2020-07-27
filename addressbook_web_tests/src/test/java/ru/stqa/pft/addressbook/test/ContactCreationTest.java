package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.contact().home();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withlName("Fedorov"). withfName("Alex")
            .withAddress("25803 Anderson Ln").withCellPhone("8184306300") .withEmail("annasilantyeva@gmail.com")
            .withGroup("Test1");
    app.contact().create(contact,true);
    app.contact().home();
    Set<ContactData> after = app.contact().all();
    int index = before.size() + 1;
    Assert.assertEquals(after.size(),index);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add (contact);
    Assert.assertEquals(before, after);

  }

}
