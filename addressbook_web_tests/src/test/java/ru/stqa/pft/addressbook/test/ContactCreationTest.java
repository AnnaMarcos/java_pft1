package ru.stqa.pft.addressbook.test;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {

  @Test//(enabled = false)
  public void testContactCreation() throws Exception {
    app.contact().home();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/cat.jpg");
    ContactData contact = new ContactData().withlName("Fedorov"). withfName("Alex")
            .withAddress("25803 Anderson Ln").withlPhone("818-444-55-66").withCellPhone("8184306300")
            .withwPhone("818-555-66-77") .withEmail("annasilantyeva@gmail.com").withPhoto(photo);
    app.contact().create(contact,true);
    app.contact().home();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded
            (contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }
  @Test (enabled = false)
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/cat.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }

}
