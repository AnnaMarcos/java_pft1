package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String fName;
  private final String lName;
  private final String address;
  private final String cellPhone;
  private final String email;

  public ContactData(String fName, String lName, String address, String cellPhone, String email) {
    this.fName = fName;
    this.lName = lName;
    this.address = address;
    this.cellPhone = cellPhone;
    this.email = email;
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
}
