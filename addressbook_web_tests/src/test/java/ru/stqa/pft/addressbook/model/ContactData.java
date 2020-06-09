package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String title;
  private final String company;
  private final String address;
  private final String cellPhone;
  private final String email;
  private final String dateOfBirth;
  private final String monthOfBirth;
  private final String yearOfBirth;

  public ContactData(String firstName, String lastName, String title, String company, String address, String cellPhone, String email, String dateOfBirth, String monthOfBirth, String yearOfBirth) {
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

  public static class GroupData {
    private final String name;
    private final String header;
    private final String footer;

    public GroupData(String name, String header, String footer) {
      this.name = name;
      this.header = header;
      this.footer = footer;
    }

    public String getName() {
      return name;
    }

    public String getHeader() {
      return header;
    }

    public String getFooter() {
      return footer;
    }
  }
}
