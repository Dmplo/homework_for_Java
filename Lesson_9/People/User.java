package HomeWork.Lesson_9.People;

import Lectures.Lesson_07.Ex007.BaseHero;

import java.util.Random;

public class User {
    protected String fName;
    protected String lName;
    protected static int number;

    protected int age;

    static {
        User.number = 0;
    }
    public User(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        User.number++;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return  "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age;
    }
}
