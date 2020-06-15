package ru.stqa.pft.addressbook.model;

import java.util.Objects;

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

  @Override
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(name, groupData.name) &&
            Objects.equals(header, groupData.header) &&
            Objects.equals(footer, groupData.footer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, header, footer);
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
