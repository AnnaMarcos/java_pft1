package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().home();
    if (app.contact().list().size() == 0){
      app.contact().create (new ContactData().withlName("Drozdov").withfName("Vladislav")
              .withAddress("25803 Anderson Ln").withCellPhone("8184306311").withEmail("annasilantyeva@gmail.com")
              .withGroup("Test2"),true);
    }
  }

  @Test
  public void testContactModification() {

    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withlName("Marcos").withfName("Anna")
            .withAddress("25804 Anderson Ln").withCellPhone("818-111-22-33").withEmail("annasilantyeva@me.com");

    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size() );

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (o1 , o2) -> Integer.compare(o1.getId(),o2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);



  }


}
