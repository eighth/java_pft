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

/**
 * Created by Nechepurenko on 16.04.2017.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initCreationContact() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
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
    type(By.name("address2"), contactData.getAddress2());
    type(By.name("phone2"), contactData.getPhone2());
    type(By.name("notes"), contactData.getNotes());

    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitCreationContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void returnToHomePage() {
    click(By.cssSelector("#nav > ul > li:nth-child(1) > a"));
  }

  public void initModificationContact() {
    wd.findElement(By.cssSelector("td:nth-child(8) > a")).click();//By.cssSelector("td:nth-child(8) > a")
  }

  public void submitModificationContact() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void checkContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();

  }

  public void submitDeletionContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void applyAlert() {
    wd.switchTo().alert().accept();
  }

  public void create(ContactData contact, boolean creation) {
    initCreationContact();
    fillContactForm(contact, creation);
    submitCreationContact();
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    checkContactById(contact.getId());
    initModificationContact();
    fillContactForm(contact,false);
    submitModificationContact();
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    checkContactById(contact.getId());
    submitDeletionContact();
    applyAlert();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
    for (WebElement element : elements) {
      String firstName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      String lastName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
    }
    return contacts;
  }

  public Set<ContactData> alls() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows){
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String firstName = cells.get(1).getText();
      String lastName = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allPhones = cells.get(5).getText();
      String allEMails = cells.get(4).getText();
//      String[] emails = cells.get(4).getText().split("\n");
      contacts.add(new ContactData()
              .withId(id)
              .withFirstName(firstName)
              .withLastName(lastName)
              .withAddress(address)
              .withAllEMails(allEMails)
              .withAllPhones(allPhones));
    }
    return contacts;
  }


  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");

    String address = wd.findElement(By.name("address")).getAttribute("value");

    String eMail = wd.findElement(By.name("email")).getAttribute("value");
    String eMail2 = wd.findElement(By.name("email2")).getAttribute("value");
    String eMail3 = wd.findElement(By.name("email3")).getAttribute("value");


    wd.navigate().back();
    return new ContactData().withId(contact.getId())
            .withFirstName(firstName)
            .withLastName(lastName)
            .withHome(home)
            .withMobile(mobile)
            .withWork(work)
            .withAddress(address)
            .witheMail(eMail)
            .witheMail2(eMail2)
            .witheMail3(eMail3);
  }

  private void initContactModificationById(int id) {
//    //Находим чекбокс
//    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
//    //Выполняем поиск относительно этого чекбокса
//    WebElement row = checkbox.findElement(By.xpath("./../.."));
//    //Попадаем в ту ячейку где находится карандашик(список ячеек, все элементы тэгнейм тиди)
//    List<WebElement> cells = row.findElements(By.tagName("id"));
//    //Среди этих находим нужный и кликаем(седьмой столбец, внутри ячейки находим ссылку с тэгом а, кликаем)
//    cells.get(7).findElement(By.tagName("a")).click();

    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
//    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
//    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }



  public String contactDetails() {
    String details = wd.findElement(By.cssSelector("#content")).getText();
    return details;
  }
  public void infoContactById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
  }
}
