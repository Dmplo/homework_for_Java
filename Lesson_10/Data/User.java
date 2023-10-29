package HomeWork.Lesson_10.Data;

import Lectures.Lesson_07.Ex007.BaseHero;

import java.util.Random;

public class User {
    protected String firstName;
    protected String lastName;
    protected String patronymic;
    protected int age;



    public User(String lastName, String firstName, String patronymic, int age) {
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.lastName = lastName;
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return  "lastName = " + lastName +
                ", firstName = " + firstName +
                ", patronymic = " + patronymic +
                ", age = " + age;
    }
}
