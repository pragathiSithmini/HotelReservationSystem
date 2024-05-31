package model;

public class Room {
    private String name;
    private Person payingCustomer;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPayingCustomer() {
        return payingCustomer;
    }

    public void setPayingCustomer(Person payingCustomer) {
        this.payingCustomer = payingCustomer;
    }
}
