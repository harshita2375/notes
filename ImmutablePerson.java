// Mark the class as final to prevent inheritance
public final class Person {
    private final String name;
    private final int age;
    private final Address address; // Mutable object

    // Constructor for initialization
    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;

        // Defensive copy to prevent external modifications
        this.address = new Address(address.getStreet(), address.getCity());
    }

    // Getters return copies or primitive values (no setters)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return new Address(address.getStreet(), address.getCity()); // Return copy
    }
}

// Mutable class (Should be made immutable or cloned in the main class)
class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }
}
