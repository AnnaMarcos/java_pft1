package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"),contactData.getfName());
    type(By.name("lastname"),contactData.getlName());
    type(By.name("address"),contactData.getAddress());
    type(By.name("mobile"),contactData.getCellPhone());
    type(By.name("email"),contactData.getEmail());

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

  public void selectContact() {
    click(By.xpath("//td/input"));
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactUpdate() {
    click(By.name("update"));
  }
}
