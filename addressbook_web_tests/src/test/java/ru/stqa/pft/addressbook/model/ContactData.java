package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String fName;
  private final String lName;
  private final String address;
  private final String cellPhone;
  private final String email;
  private String group;

  public ContactData(String fName, String lName, String address, String cellPhone, String email, String group) {
    this.fName = fName;
    this.lName = lName;
    this.address = address;
    this.cellPhone = cellPhone;
    this.email = email;
    this.group = group;
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
}
