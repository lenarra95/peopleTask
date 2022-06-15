import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder setName (String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname (String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge (int age) {
        this.age = OptionalInt.of(age);
        checkAge();
        return this;
    }

    public PersonBuilder setAddress (String address) {
        this.address = address;
        return this;
    }

    private void checkNames () {
        if (name == null && surname == null) {
            throw new IllegalStateException("Не указаны обязательные поля: имя и фамилия");
        }
    }

    private void checkAge () {
        if (age.getAsInt() < 0) {
            throw new IllegalStateException("Указан недопустимы возраст");
        }
    }

    public Person build () {
        checkNames();
        return new Person(name, surname);
    }
}
