package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String home;
  private final String mobile;
  private final String work;
  private final String fax;
  private final String eMail;
  private final String eMail2;
  private final String eMail3;
  private final String homePage;
  private final String bYear;
  private final String aYear;
  private final String address2;
  private final String phone2;
  private final String notes;

  public ContactData(String firstName, String middleName, String lastName, String nickname, String title, String company, String address, String home, String mobile, String work, String fax, String eMail, String eMail2, String eMail3, String homePage, String bYear, String aYear, String address2, String phone2, String notes) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.eMail = eMail;
    this.eMail2 = eMail2;
    this.eMail3 = eMail3;
    this.homePage = homePage;
    this.bYear = bYear;
    this.aYear = aYear;
    this.address2 = address2;
    this.phone2 = phone2;
    this.notes = notes;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getFax() {
    return fax;
  }

  public String geteMail() {
    return eMail;
  }

  public String geteMail2() {
    return eMail2;
  }

  public String geteMail3() {
    return eMail3;
  }

  public String getHomePage() {
    return homePage;
  }

  public String getbYear() {
    return bYear;
  }

  public String getaYear() {
    return aYear;
  }

  public String getAddress2() {
    return address2;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getNotes() {
    return notes;
  }
}
