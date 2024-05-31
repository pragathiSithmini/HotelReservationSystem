package model;

public class Person {
    private String name;
    private String firstName;
    private String  surName;
    private int creditCardNo;
    private int noOfGuests;

    public Person(String name, String firstName, String surName, int creditCardNo, int noOfGuests) {
        this.name = name;
        this.firstName = firstName;
        this.surName = surName;
        this.creditCardNo = creditCardNo;
        this.noOfGuests = noOfGuests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(int creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public int getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(int noOfGuests) {
        this.noOfGuests = noOfGuests;
    }
}
