package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

  @Entity
  @Table(name = "addressbook")

  @XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField

  @Id
  @Column (name = "id")
  private  int id = Integer.MAX_VALUE ;
    @Expose

    @Column(name = "firstname")
  private  String fName;
    @Expose

    @Column(name = "lastname")
  private  String lName;
    @Expose

    @Column (name = "address")
    @Type(type = "text")
    private  String address;
    @Expose

    @Column (name = "mobile")
    @Type(type = "text")
  private  String cellPhone;
    @Expose

    @Column (name = "email")
    @Type(type = "text")
    private  String email;

    @Transient
  private  String group;
    @Expose

    @Column (name = "home")
    @Type(type = "text")
    private  String lPhone;
    @Expose

    @Column (name = "work")
    @Type(type = "text")
    private  String wPhone;

    @Transient
  private  String allPhones;

    @Transient
  private  String allEmails;

    @Transient
  private  String email2;

    @Transient
  private  String email3;

    @Transient
  private  String allAddresses;

    @Transient
  private  String companyAddress;

    @Override
    public String toString() {
      return "ContactData{" +
              "id=" + id +
              ", fName='" + fName + '\'' +
              ", lName='" + lName + '\'' +
              '}';
    }

    @Column (name = "photo")
    @Type(type = "text")
    private String photo;


  public ContactData() {
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContactData withAllAddresses(String allAddresses) {
    this.allAddresses = allAddresses;
    return  this;
  }

  public ContactData withCompanyAddress(String companyAddress) {
    this.companyAddress = companyAddress;
    return this;
  }
  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }
  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }
  public ContactData withAllEmails (String allEmails) {
    this.allEmails = allEmails;
    return this;
  }
  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }
  public ContactData withId (int id) {
    this.id = id;
    return this;
  }

  public ContactData withfName (String fName) {
    this.fName = fName;
    return this;
  }

  public ContactData withlName(String lName) {
    this.lName = lName;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }
  public ContactData withallPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withCellPhone(String cellPhone) {
    this.cellPhone = cellPhone;
    return this;
  }
  public ContactData withlPhone (String lPhone) {
    this.lPhone = lPhone;
    return this;
  }


  public ContactData withwPhone(String wPhone) {
    this.wPhone = wPhone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData(String fName, String lName) {
    this.id = Integer.MAX_VALUE;
    this.fName = fName;
    this.lName = lName;
    this.lPhone = lPhone;
    this.cellPhone = cellPhone;
    this.wPhone = wPhone;
    this.email2 = null;
    this.email3 = null;
    this.address = null;
    this.companyAddress = null;
    this.allAddresses = null;
    this.group = null;
  }
  public File getPhoto() {
    return new File(photo);
  }
  public String getCompanyAddress() {
    return companyAddress;
  }
  public String getAllAddresses() {
    return allAddresses;
  }
  public String getEmail3() {
    return email3;
  }
  public String getEmail2() {
    return email2;
  }
  public String getAllEmails() {
    return allEmails;
  }
  public String getAllPhones() {
    return allPhones;
  }

  public int getId() {
    return id;
  }

  public String getlPhone() {
    return lPhone;
  }

  public String getwPhone() {
    return wPhone;
  }

  public String getfName() {
    return fName;
  }

  public String getlName() {
    return lName;
  }

  public String getAddress() {
    return address;
  }

  public String getCellPhone() {
    return cellPhone;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }


    @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(fName, that.fName) &&
            Objects.equals(lName, that.lName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fName, lName);
  }


}
