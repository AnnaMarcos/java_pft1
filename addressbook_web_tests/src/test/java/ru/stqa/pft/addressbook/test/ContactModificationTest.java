package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {



  @Test
  public void testContactModification() {

    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Christian", "Silantyev",
              "25803 Anderson Ln", "8184306300", "annasilantyeva@gmail.com","Test1"),true);
    }
    app.getNavigationHelper().returnToHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Anna", "Marcos",
            "25804 Anderson Ln", "818-111-22-33", "annasilantyeva@me.com", null),false);
    app.getContactHelper().submitContactUpdate();
    app.getNavigationHelper().returnToHomePage();

  }
}
