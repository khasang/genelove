package io.khasang.genelove.model;

public class Contacts {
    private String ContactsOut;

    public Contacts(String ContactsOut) {
        this.ContactsOut = ContactsOut;
    }

    public Contacts() {
    }

    public String getContactsOut() {
        return ContactsOut;
    }

    public void setContactsOut(String ContactsOut) {
        this.ContactsOut = ContactsOut;
    }
}