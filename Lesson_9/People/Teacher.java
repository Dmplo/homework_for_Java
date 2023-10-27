package HomeWork.Lesson_9.People;

public class Teacher extends User {
    protected int id;

    public Teacher(String fName, String lName, int age) {
        super(fName, lName, age);
        this.id = User.number;
    }

    @Override
    public String toString() {
        return "[" + super.toString() + ", id=" + id + "]";
    }
}
