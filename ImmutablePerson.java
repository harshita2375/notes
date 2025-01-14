public final class ImmutablePerson {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address;

    // Private constructor to prevent direct instantiation
    private ImmutablePerson(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.address = builder.address;
    }

    // only Getters, so seeter in theis class provides immutibility
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    // Static nested Builder class
    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String address;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        // Build method to create ImmutablePerson object
        public ImmutablePerson build() {
            return new ImmutablePerson(this);
        }
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // Example usage
        ImmutablePerson person = new ImmutablePerson.Builder()
                .setFirstName("John")
                .setLastName("Doe")
                .setAge(30)
                .setAddress("123 Main St")
                .build();

        System.out.println(person);
    }
}
