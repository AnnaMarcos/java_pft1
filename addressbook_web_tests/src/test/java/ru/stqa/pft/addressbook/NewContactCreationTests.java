package ru.stqa.pft.addressbook;


import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class NewContactCreationTests extends TestBase {

  @Test
  public void testNewContactCreation() throws Exception {

    app.addNewContact();
    app.fiiContactForm(new GroupData.ContactData("Anna", "Marcos", "2580s Anderson Ln", "818-430-6300", "annasilantyeva@gmail.com"));
    app.submitContactForm();
    app.returnToHomePage();
  }
}



