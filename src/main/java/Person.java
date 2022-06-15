import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private OptionalInt age;
    private String address;

    public Person (String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person (String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public Person (String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.address = address;
    }

    public String getName () {
        return name;
    }

    public String getSurname () {
        return surname;
    }

    public boolean hasAge () {
        return age.isPresent();
    }

    public void happyBirthday () {
        if (hasAge()) {
            age = OptionalInt.of(age.getAsInt() + 1);
            return;
        }
        age = OptionalInt.of(1);
    }

    public int getAge () {
        if (hasAge()) {
            return age.getAsInt();
        }
        return 0;
    }

    public boolean hasAddress () {
        return address == null;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getAddress () {
        if (hasAddress()) {
            return address;
        }
        return null;
    }

    PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname)
                .setAge(0)
                .setAddress(address);
    }

    public String toString() {
        return "Имя: " + name + ", фамилия: " + surname;
    }
}