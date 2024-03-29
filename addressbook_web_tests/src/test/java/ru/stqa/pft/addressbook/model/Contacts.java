package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.HashSet;
import java.util.Set;

    public class Contacts extends ForwardingSet<ContactData> {

    private Set<ContactData> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<ContactData>(contacts.delegate);
  }

  public Contacts() {
    this.delegate = new HashSet<ContactData>();
  }


  @Override
  public Set<ContactData> delegate() {
    return delegate;
  }

  public Contacts withAdded(ContactData contact) {
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;

  }

  public Contacts without(ContactData contact) {
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;
  }
}
