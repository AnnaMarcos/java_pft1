package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {


  private  int id = Integer.MAX_VALUE ;
  private  String fName;
  private  String lName;
  private  String address;
  private  String cellPhone;
  private  String email;
  private  String group;
  private  String lPhone;
  private  String wPhone;
  private  String allPhones;
  private  String allEmails;
  private  String email1;
  private  String email2;
  private  String email3;
  private  String allAddresses;
  private  String companyAddress;

  public ContactData withAllAddresses(String allAddresses) {
    this.allAddresses = allAddresses;
    return  this;
  }

  public ContactData withCompanyAddress(String companyAddress) {
    this.companyAddress = companyAddress;
    return this;
  }

  public ContactData() {
  }
  public ContactData withEmail1(String email1) {
    this.email1 = email1;
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
    this.email1 = null;
    this.email2 = null;
    this.email3 = null;
    this.address = null;
    this.companyAddress = null;
    this.allAddresses = null;
    this.group = null;
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
  public String getEmail1() {
    return email1;
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
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", fName='" + fName + '\'' +
            ", lName='" + lName + '\'' +
            '}';
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
