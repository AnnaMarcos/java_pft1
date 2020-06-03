package ru.stqa.pft.addressbook;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String address;
  private final String cellPhone;
  private final String email;

  public ContactData(String firstName, String lastName, String address, String cellPhone, String email) {
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
}
