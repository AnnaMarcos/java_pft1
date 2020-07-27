package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {



  @Test
  public void testContactModification() {
    app.getNavigationHelper().returnToHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData( "Silantyev", "Christian",
              "25803 Anderson Ln", "8184306300", "annasilantyeva@gmail.com","Test1"),true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().returnToHomePage();
    app.getContactHelper().initContactModification(before.size() -1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Marcos","Anna",
            "25804 Anderson Ln", "818-111-22-33", "annasilantyeva@me.com", null);
    app.getContactHelper().fillContactForm (contact, false);
    app.getContactHelper().submitContactUpdate();
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() );

    before.remove(before.size() -1);
    before.add(contact);
    Comparator<? super ContactData> byId = (o1 , o2) -> Integer.compare(o1.getId(),o2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);



  }
}
