package ru.stqa.pft.addressbook.model;

public class GroupData {
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

  public static class ContactData {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String cellPhone;
    private final String email;
    private String group;

    public ContactData(String firstName, String lastName, String address, String cellPhone, String email, String group) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.address = address;
      this.cellPhone = cellPhone;
      this.email = email;
      this.group = group;
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
  }
}
