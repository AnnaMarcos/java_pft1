package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getfName());
    type(By.name("lastname"), contactData.getlName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getlPhone());
    type(By.name("mobile"), contactData.getCellPhone());
    type(By.name("work"), contactData.getwPhone());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }
  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value= '" + id + "' ]")).click();
  }
  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
    }

  public void initContactModificationById(int id) {
    click(By.cssSelector("a[href='edit.php?id=" + id + "']"));
  }
  public void submitContactUpdate() {
    click(By.name("update"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void verifyContactDeletion() {
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox"));
  }
  public void home() {
    if (isElementPresent (By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }



  public void create(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact,true);
    submitContactCreation();
    home();
  }


  public void modify(ContactData contact) {
    home();
    initContactModificationById(contact.getId());
    fillContactForm (contact, false);
    submitContactUpdate();
    contactCache = null;
    home();
  }

  public void delete(ContactData contact) {
    home();
    selectContactById(contact.getId());
    deleteSelectedContact();
    verifyContactDeletion();
    contactCache = null;
    home();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;


  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String fName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lName = wd.findElement(By.name("lastname")).getAttribute("value");
    String lPhone = wd.findElement(By.name("home")).getAttribute("value");
    String cellPhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String wPhone = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId())
            .withfName(fName).withlName(lName).withlPhone(lPhone).withCellPhone(cellPhone).withwPhone(wPhone);
  }
  public Contacts all() {
    if(contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("#maintable tr:not(:first-child)"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String lName = cells.get(1).getText();
      String fName = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allPhones = cells.get(5).getText();


      ContactData contact = new ContactData().withId(id).withfName(fName).withlName(lName)
              .withAddress(address).withallPhones(allPhones);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);

  }
}
