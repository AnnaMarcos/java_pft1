package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getContactHelper().returnToHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData( "Silantyev", "Christian",
              "25803 Anderson Ln", "8184306300", "annasilantyeva@gmail.com","Test1"),true);
    }
  }

  @Test
  public void testContactModification() {

    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() -1;
    ContactData contact = new ContactData(before.get(index).getId(), "Marcos","Anna",
            "25804 Anderson Ln", "818-111-22-33", "annasilantyeva@me.com", null);

    app.getContactHelper().modifyContact(index, contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() );

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (o1 , o2) -> Integer.compare(o1.getId(),o2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);



  }


}
