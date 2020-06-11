package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests  extends TestBase {

  @Test
  public void testContactModification () {
    app.getGroupHelper().editContact();
    app.getGroupHelper().fiiContactForm(new GroupData.ContactData("Anuta", "Ivanova", "25803 Anderson Ln", "818-430-6311", "annasilantyeva@yahoo.com", null), false);
    app.getGroupHelper().submitContactUpdate();
    app.getGroupHelper().returnToHomePage();
  }

}