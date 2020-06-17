package ru.stqa.pft.addressbook.model;

public class ContactData {
  public String firstName;
  public String lastName;
  public String address;
  public String cellPhone;
  public String email;
  public String group;

  public ContactData(String firstName, String lastName, String address, String cellPhone, String email, String group) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.cellPhone = cellPhone;
    this.email = email;

  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
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

  public static class GroupData {
    private  String name;
    private  String header;
    private  String footer;


  }
}
