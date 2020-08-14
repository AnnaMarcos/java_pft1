package ru.stqa.pft.addressbook.test;
import com.thoughtworks.xstream.XStream;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTest extends TestBase {

  @DataProvider
    public Iterator<Object[]>validContacts() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line != null) {
      String []split =  line.split(";");
      list.add(new Object[] {new ContactData().withfName(split[0]).withlName(split[1]).withAddress(split[2])
              .withlPhone(split[3]).withCellPhone(split[4]).withwPhone(split[5]).withEmail(split[6])});
      line = reader.readLine();
    }
    return list.iterator();
  }
  @DataProvider
  public Iterator<Object[]>validContactsXML() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      String []split =  line.split(";");
      xml += line;
      line = reader.readLine();
    }
    XStream xStream = new XStream();
    xStream.processAnnotations(ContactData.class);
    List <ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
    return contacts.stream().map((g) -> new Object[] {g}).collect (Collectors.toList()).iterator();
  }


  @Test (dataProvider = "validContactsXML")
    public void testContactCreation(ContactData contact) {
      app.contact().home();
      Contacts before = app.contact().all();
      app.contact().create(contact,true);
      //app.contact().home();
      assertThat(app.contact().count(), equalTo(before.size() + 1));
      Contacts after = app.contact().all();
      assertThat(after, equalTo(before.withAdded
              (contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test (enabled = false)
    public void testCurrentDir(){
      File currentDir = new File(".");
      System.out.println(currentDir.getAbsolutePath());
      File photo = new File("src/test/resources/cat.jpg");
      System.out.println(photo.getAbsolutePath());
      System.out.println(photo.exists());
    }
  }