package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;;
  @Expose
  @Column(name = "firstname")
  private String firstName;
  @Expose
  @Column(name = "middlename")
  private String middleName;
  @Expose
  @Column(name = "lastname")
  private String lastName;
  @Expose
  @Column(name = "nickname")
  private String nickname;
  @Expose
  @Column(name = "title")
  private String title;
  @Expose
  @Column(name = "company")
  private String company;
  @Expose
  @Column(name = "address")
  private String address;
  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String home;
  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobile;
  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String work;

  private String fax;
  private String eMail;
  private String eMail2;
  private String eMail3;
  private String homePage;
  private String address2;
  private String phone2;
  private String notes;

//  @Transient
//  private String group;

  @Transient
  private String allPhones;

  @Transient
  private String allEMails;

  @Column(name = "photo")
  @Type(type = "mediumtext")
  private String photo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"),
          inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();



  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public String getAllEMails() {
    return allEMails;
  }

  public ContactData withAllEMails(String allEMails) {
    this.allEMails = allEMails;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHome(String home) {
    this.home = home;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withWork(String work) {
    this.work = work;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData witheMail(String eMail) {
    this.eMail = eMail;
    return this;
  }

  public ContactData witheMail2(String eMail2) {
    this.eMail2 = eMail2;
    return this;
  }

  public ContactData witheMail3(String eMail3) {
    this.eMail3 = eMail3;
    return this;
  }

  public ContactData withHomePage(String homePage) {
    this.homePage = homePage;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData withPhone2(String phone2) {
    this.phone2 = phone2;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public ContactData withGroup(GroupData group) {
    groups.add(group);
    return this;
  }

  public Groups getGroups() {
    return new Groups(groups);
  }

  public int getId() {
    return id;
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

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//
//    ContactData that = (ContactData) o;
//
//    if (id != that.id) return false;
//    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
//    if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
//    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
//    if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
//    if (title != null ? !title.equals(that.title) : that.title != null) return false;
//    if (company != null ? !company.equals(that.company) : that.company != null) return false;
//    if (address != null ? !address.equals(that.address) : that.address != null) return false;
//    if (home != null ? !home.equals(that.home) : that.home != null) return false;
//    if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
//    if (work != null ? !work.equals(that.work) : that.work != null) return false;
//    return group != null ? group.equals(that.group) : that.group == null;
//  }

//  @Override
//  public int hashCode() {
//    int result = id;
//    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
//    result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
//    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
//    result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
//    result = 31 * result + (title != null ? title.hashCode() : 0);
//    result = 31 * result + (company != null ? company.hashCode() : 0);
//    result = 31 * result + (address != null ? address.hashCode() : 0);
//    result = 31 * result + (home != null ? home.hashCode() : 0);
//    result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
//    result = 31 * result + (work != null ? work.hashCode() : 0);
//    result = 31 * result + (group != null ? group.hashCode() : 0);
//    return result;
//  }

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

  public String getAddress2() {
    return address2;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getNotes() {
    return notes;
  }

//  public String getGroup() {
//    return group;
//  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

}
