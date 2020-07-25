package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {


  private  int id;
  private final String fName;
  private final String lName;
  private final String address;
  private final String cellPhone;
  private final String email;

  private String group;



  public ContactData( String lName, String fName,  String address, String cellPhone, String email, String group) {
    this.id =  0 ;
    this.fName = fName;
    this.lName = lName;
    this.address = address;
    this.cellPhone = cellPhone;
    this.email = email;
    this.group = group;
  }

  public ContactData(int id, String lName, String fName,  String address, String cellPhone, String email, String group) {
    this.id =  id;
    this.fName = fName;
    this.lName = lName;
    this.address = address;
    this.cellPhone = cellPhone;
    this.email = email;
    this.group = group;
  }




  public int getId() {
    return id;
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

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
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
