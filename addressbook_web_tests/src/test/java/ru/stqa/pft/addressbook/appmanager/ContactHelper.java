package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

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
    type(By.name("mobile"), contactData.getCellPhone());
    type(By.name("email"), contactData.getEmail());

    if (creation){
         new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void verifyContactDeletion() {
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initContactModification( int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public void submitContactUpdate() {
    click(By.name("update"));
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

  }
  public void modify(int index, ContactData contact) {
    home();
    initContactModification(index);
    fillContactForm (contact, false);
    submitContactUpdate();
    home();
  }
  public void deleteContact(int index) {
    home();
    selectContact(index);
    deleteSelectedContact();
    verifyContactDeletion();
    home();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows ){
      List<WebElement> cells = row.findElements(By.cssSelector("td"));
              String lName = cells.get(1).getText();
              String fName = cells.get(2).getText();
              int id = Integer.parseInt(row.findElement(By. tagName("input")).getAttribute("value"));
      contacts.add( new ContactData().withId(id).withlName(lName).withfName(fName));
      }
     return contacts;

  }
}
