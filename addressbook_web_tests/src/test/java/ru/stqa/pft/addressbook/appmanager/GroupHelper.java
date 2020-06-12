package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("groups"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(ru.stqa.pft.addressbook.model.ContactData.GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroup() {

    click(By.name("delete"));
  }

  public void selectGroup() {

    click(By.name("selected[]"));
  }


  public void submitContactForm() {

    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fiiContactForm(GroupData.ContactData contactData, boolean creation) {
    type("firstname", contactData.getFirstName());
    type("lastname", contactData.getLastName());
    type("address", contactData.getAddress());
    type("mobile", contactData.getCellPhone());
    type("email", contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  //drop down menu
  // if (isElementPresent(By.name("new_group"))) {
  // new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup()); }


  public void addNewContact() {

    click(By.linkText("add new"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void selectContact() {
    click(By.name("selected[]"));

  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void submitContactDeletion() {
    wd.switchTo().alert().accept();
    wd.findElement(By.xpath("//input[@value='Delete']"));

  }


  public void editContact() {
    click(By.xpath("//img[@alt='Edit']"));

  }

  public void submitContactUpdate() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void gotoHomepage() {
    click(By.linkText("home"));
  }

  public void createGroup(ContactData.GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }


  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//td/input"));

  }

  public void createContact(GroupData.ContactData table, boolean b) {
    addNewContact();
    fiiContactForm(table, true);
    submitContactForm();
    gotoHomepage();
  }

}


