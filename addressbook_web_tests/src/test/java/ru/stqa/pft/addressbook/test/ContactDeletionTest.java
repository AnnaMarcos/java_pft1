package ru.stqa.pft.addressbook.test;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().home();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData().withlName("Silantyev").withfName("Christian")
              .withAddress("25803 Anderson Ln").withlPhone("818-444-55-66").withCellPhone("8184306300")
              .withwPhone("818-555-66-77").withEmail("annasilantyeva@gmail.com")
              .withGroup("Test1"),true);
      app.contact().home();
    }
  }

  @Test
  public void testContactDeletion() throws Exception {

    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.contact().home();
    MatcherAssert.assertThat(app.contact().count(), equalTo(before.size() - 1));
    Set<ContactData> after = app.contact().all();
    MatcherAssert.assertThat(after, equalTo(before.without(deletedContact)));





  }



}
