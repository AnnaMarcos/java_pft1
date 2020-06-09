package ru.stqa.pft.addressbook;


import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class NewContactCreationTests extends TestBase {

  @Test
  public void testNewContactCreation() throws Exception {

    app.getGroupHelper().addNewContact();
    app.getGroupHelper().fiiContactForm(new GroupData.ContactData("Anna", "Marcos", "2580s Anderson Ln", "818-430-6300", "annasilantyeva@gmail.com"));
    app.getGroupHelper().submitContactForm();
    app.getGroupHelper().returnToHomePage();
  }
}



