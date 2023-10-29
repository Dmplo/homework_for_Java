package HomeWork.Lesson_10.Data;

public class Teacher extends User {
    protected int id;

    public Teacher(String lastName, String firstName, String patronymic, int age, int id) {
        super(lastName, firstName, patronymic, age);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Teacher" + "[" + super.toString() + ", id = " + id + "]";
    }

    public int getId() {
        return id;
    }
}
