package ru.stqa.pft.addressbook.test;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().home();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withlName("Drozdov").withfName("Vladislav")
              .withAddress("25803 Anderson Ln").withlPhone("818-444-55-66").withCellPhone("8184306300")
              .withwPhone("818-555-66-77").withEmail("annasilantyeva@gmail.com")
              .withGroup("Test1"), true);
      app.contact().home();
    }
  }


  @Test //(enabled = false)
  public void testContactPhones() {

    app.contact().home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    /*MatcherAssert.assertThat(contact.getlPhone(), CoreMatchers.equalTo(cleaned(contactInfoFromEditForm.getlPhone())));
    MatcherAssert.assertThat(contact.getCellPhone(), equalTo(cleaned(contactInfoFromEditForm.getCellPhone())));
    MatcherAssert.assertThat(contact.getwPhone(), equalTo(cleaned(contactInfoFromEditForm.getwPhone())));
    */

    MatcherAssert.assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }
  private String mergePhones(ContactData contact) {
    return  Arrays.asList(contact.getlPhone(),contact.getCellPhone(),contact.getwPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));

  }


  public static String cleaned (String phone){
    return phone.replaceAll("\\s","").replaceAll("[- ()]","");
  }
}


