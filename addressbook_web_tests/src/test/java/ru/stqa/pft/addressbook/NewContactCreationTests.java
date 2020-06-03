package ru.stqa.pft.addressbook;


import org.testng.annotations.*;
import org.openqa.selenium.*;

public class NewContactCreationTests extends TestBase {

  @Test
  public void testNewContactCreation() throws Exception {

    addNewContact();
    fiiContactForm(new ContactData("Anna", "Marcos", "2580s Anderson Ln", "818-430-6300", "annasilantyeva@gmail.com"));
    submitContactForm();
    returnToHomePage();

    logOut();
  }

  public void logOut() {

    wd.findElement(By.linkText("Logout")).click();
  }
}



