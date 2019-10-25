package repository;

public class Person {
    private String name;
    private int age;
    private String birthDate;

    public Person(String name, int age, String birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nAge: %d\nBirthday: %s", this.name, this.age, this.birthDate);
    }
}
