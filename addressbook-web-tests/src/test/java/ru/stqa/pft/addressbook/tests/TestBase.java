package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

/**
 * Created by Nechepurenko on 15.04.2017.
 */
public class TestBase {
  protected final ApplicationManager app = new ApplicationManager();


  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

//  @BeforeMethod
//  public void setUp() throws Exception {
//    wd = new FirefoxDriver();
//    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//    wd.get("http://localhost/addressbook/");
//    login("admin", "secret");
//  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

//  @AfterMethod
//  public void tearDown() {
//    wd.quit();
//  }
}
