package ru.stqa.pft.addressbook.test;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]>validContact() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new ContactData().withlName("Marcos 1").withfName("Anna 1").withAddress("25803 Anderson Ln 1")
            .withlPhone("818-444-55-66 1").withCellPhone("8184306300 1").withwPhone("818-555-66-77 1")
            .withEmail("annasilantyeva@gmail.com 1")});
    list.add(new Object[]{new ContactData().withlName("Marcos 2").withfName("Anna 2").withAddress("25803 Anderson Ln 2")
            .withlPhone("818-444-55-66 2").withCellPhone("8184306300 2").withwPhone("818-555-66-77 2")
            .withEmail("annasilantyeva@gmail.com 2")});
    list.add(new Object[]{new ContactData().withlName("Marcos 3").withfName("Anna 3").withAddress("25803 Anderson Ln 3")
            .withlPhone("818-444-55-66 3").withCellPhone("8184306300 3").withwPhone("818-555-66-77 3")
            .withEmail("annasilantyeva@gmail.com 3")});
    return list.iterator();
  }

  @Test (dataProvider = "validContact")
  public void testContactCreation(ContactData contact) {
    app.contact().home();
    Contacts before = app.contact().all();
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
