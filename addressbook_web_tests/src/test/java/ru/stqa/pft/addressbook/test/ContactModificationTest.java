package ru.stqa.pft.addressbook.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

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
    ContactData modifyContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifyContact.getId()).withlName("Marcos").withfName("Anna")
            .withAddress("25804 Anderson Ln").withCellPhone("818-111-22-33").withEmail("annasilantyeva@me.com");

    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Set<ContactData> after = app.contact().all();
    assertEquals(after.size(),before.size() );

    //assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));

  }
}
