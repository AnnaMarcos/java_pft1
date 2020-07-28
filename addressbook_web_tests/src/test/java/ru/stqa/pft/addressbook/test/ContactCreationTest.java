package ru.stqa.pft.addressbook.test;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.contact().home();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withlName("Fedorov"). withfName("Alex")
            .withAddress("25803 Anderson Ln").withCellPhone("8184306300") .withEmail("annasilantyeva@gmail.com")
            .withGroup("Test1");
    app.contact().create(contact,true);
    app.contact().home();
    Contacts after = app.contact().all();
    assertThat(after.size(),equalTo(before.size() + 1));

    assertThat(after, equalTo(before.withAdded
            (contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }

}
