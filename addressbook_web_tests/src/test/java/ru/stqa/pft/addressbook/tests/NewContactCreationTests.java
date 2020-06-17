package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class NewContactCreationTests extends TestBase {

  @Test
  public void testNewContactCreation() throws Exception {
    app.getGroupHelper().gotoHomepage();
    //int before = app.getGroupHelper().getContactCount();//added verification: number of contacts before creation new one
    app.getGroupHelper().addNewContact();
    app.getGroupHelper().fiiContactForm(new ContactData ("Anna", "Marcos", "2580s Anderson Ln", "818-430-6300", "annasilantyeva@gmail.com", "test1" ), true);
    app.getGroupHelper().submitContactForm();
    app.getGroupHelper().gotoHomepage();
    //int after = app.getGroupHelper().getContactCount(); //added verification: number of contacts after creation new one
    //Assert.assertEquals(after,before + 1); // verification: after num = before num + one created
  }
}



