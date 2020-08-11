package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count" )
  public int count;


  @Parameter (names = "-f", description = "Target file" )
  public String file;



  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();

  }

  private void run() throws IOException {
    List<ContactData> contacts  = generatorContacts(count);
    save(contacts, new File(file));

  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s; %s; %s; %s; %s; %s; %s \n", contact.getlName(), contact.getfName()
              , contact.getAddress(),contact.getlPhone(), contact.getCellPhone()
              , contact.getwPhone(),contact.getEmail()));
    }
    writer.close();

  }

  private static List<ContactData> generatorContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withlName(String.format("Anna %s", i)).withfName(String.format("Marcos %s", i))
              .withAddress(String.format("25803 Anderson ln %s", i)).withlPhone(String.format("818-430-6300 %s", i))
              .withCellPhone(String.format("818-430-63-01 %s", i)).withwPhone(String.format("818-430-6302 %s", i))
              .withEmail(String.format("annasilantyeva@gmail.com %s", i)));
    }
    return contacts;
  }

}
