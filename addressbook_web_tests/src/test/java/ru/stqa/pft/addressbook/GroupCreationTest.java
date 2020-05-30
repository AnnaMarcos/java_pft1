package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupCreationTest {
  ///private WebDriver driver; rename variable 'driver'
     private WebDriver wd;
  // we do not need this variables anymore
 // private String baseUrl;
  //private boolean acceptNextAlert = true;
  //private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    //baseUrl = "https://www.google.com/"; do not need anymore
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testGroupCreation() throws Exception {
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.id("LoginForm")).submit();
    wd.findElement(By.linkText("groups")).click();
    wd.findElement(By.name("new")).click();
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys("Test1");
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys("Test2");
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys("Test3");
    wd.findElement(By.name("submit")).click();
    wd.findElement(By.linkText("groups")).click();
    wd.findElement(By.linkText("Logout")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
    // do not need this verifications anymore
    //String verificationErrorString = verificationErrors.toString();
    //if (!"".equals(verificationErrorString)) {
      //fail(verificationErrorString);
   // }
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
  // do not need this method anymore
  //private String closeAlertAndGetItsText() {
    //try {
      //Alert alert = driver.switchTo().alert();
      //String alertText = alert.getText();
      //if (acceptNextAlert) {
        //alert.accept();
     // } else {
       // alert.dismiss();
      //}
      //return alertText;
    //} finally {
     // acceptNextAlert = true;
    }
  //}
//}
