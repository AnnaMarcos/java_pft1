package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().home();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withlName("Drozdov").withfName("Vladislav")
              .withAddress("25803 Anderson Ln").withCellPhone("8184306300").withEmail("annasilantyeva@gmail.com")
              .withGroup("Test1"), true);
      app.contact().home();
    }
  }

  @Test
  public void testContactModification() {

    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withlName("Marcos").withfName("Anna")
            .withAddress("25804 Anderson Ln").withCellPhone("818-111-22-33").withEmail("annasilantyeva@me.com");

    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(),before.size() );

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before,after);



  }


}
