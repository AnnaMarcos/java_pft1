package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper {
  private WebDriver wd;

  public GroupHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void returnToGroupPage() {
    click(By.linkText("groups"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  private void click(By locator) {
    wd.findElement(locator).click();
  }

  public void fillGroupForm(ru.stqa.pft.addressbook.model.ContactData.GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  private void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
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

  public void returnToHomePage() {

    click(By.linkText("home"));
  }

  public void submitContactForm() {

    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fiiContactForm(GroupData.ContactData contactData) {
    type("firstname", contactData.getFirstName());
    type("lastname", contactData.getLastName());
    type("address", contactData.getAddress());
    type("mobile", contactData.getCellPhone());
    type("email", contactData.getEmail());
  }

  private void type(String firstname, String firstName) {
    wd.findElement(By.name(firstname)).clear();
    wd.findElement(By.name(firstname)).sendKeys(firstName);
  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }
}
