package ru.stqa.pft.addressbook.test;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;

public class ContactEmailTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().home();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData().withlName("Silantyev").withfName("Christian")
              .withAddress("25803 Anderson Ln").withlPhone("818-444-55-66").withCellPhone("8184306300")
              .withwPhone("818-555-66-77").withEmail("annasilantyeva@gmail.com")
              .withGroup("Test1"),true);
      app.contact().home();
    }
  }
  @Test
  public void TestContactEmails(){
    app.contact().home();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    MatcherAssert.assertThat(contact.getAllEmails(),equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactEmailTest::cleaned)
            .collect(Collectors.joining("\n"));


  }

  private static String cleaned(String email) {
    return email.replaceAll("\\s","");
  }

}
