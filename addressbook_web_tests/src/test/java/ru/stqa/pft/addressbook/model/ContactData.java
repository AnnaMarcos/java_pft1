package ru.stqa.pft.addressbook.model;

public class ContactData {
  private  String firstName;
  private  String lastName;
  private  String title;
  private  String company;
  private  String address;
  private  String cellPhone;
  private  String email;
  private  String dateOfBirth;
  private  String monthOfBirth;
  private  String yearOfBirth;
  public String group;

  public ContactData(String firstName, String lastName, String title, String company, String address, String cellPhone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.title = title;
    this.company = company;
    this.address = address;
    this.cellPhone = cellPhone;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    this.monthOfBirth = monthOfBirth;
    this.yearOfBirth = yearOfBirth;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
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

  public String getCellPhone() {
    return cellPhone;
  }

  public String getEmail() {
    return email;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public String getMonthOfBirth() {
    return monthOfBirth;
  }

  public String getYearOfBirth() {
    return yearOfBirth;
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
