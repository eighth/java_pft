package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Nechepurenko on 16.04.2017.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void initCreationContact() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWork());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.geteMail());
    type(By.name("email2"), contactData.geteMail2());
    type(By.name("email3"), contactData.geteMail3());
    type(By.name("homepage"), contactData.getHomePage());
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[3]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[2]"));
    }
    type(By.name("byear"), contactData.getbYear());
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[4]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[3]//option[4]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[3]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[4]//option[3]"));
    }
    type(By.name("ayear"), contactData.getaYear());
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[5]//option[2]"));
    }
    type(By.name("address2"), contactData.getAddress2());
    type(By.name("phone2"), contactData.getPhone2());
    type(By.name("notes"), contactData.getNotes());
  }

  public void submitCreationContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }
}
