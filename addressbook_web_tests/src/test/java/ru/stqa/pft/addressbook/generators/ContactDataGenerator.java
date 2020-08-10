package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generatorContacts(count);
    save(contacts, file);


  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s; %s; %s; %s; %s; %s; %s \n", contact.getlName(), contact.getfName()
              , contact.getAddress(), contact.getEmail(), contact.getlPhone(), contact.getCellPhone()
              , contact.getwPhone()));
    }
    writer.close();

  }

  private static List<ContactData> generatorContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withlName(String.format("LastName %s", i)).withfName(String.format("FirstName %s", i))
              .withAddress(String.format("Address %s", i)).withEmail(String.format("email %s", i))
              .withlPhone(String.format("HomePhone %s", i)).withCellPhone(String.format("CellPhone %s", i))
              .withwPhone(String.format("WorkPhone %s", i)));
    }
    return contacts;
  }

}
