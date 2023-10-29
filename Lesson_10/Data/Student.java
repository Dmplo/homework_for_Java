package HomeWork.Lesson_10.Data;

public class Student extends User implements Comparable<Student> {
    protected int id;

    public Student(String lastName, String firstName, String patronymic, int age, int id) {
        super(lastName, firstName, patronymic, age);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student" + "[" + super.toString() + ", id = " + id + "]";
    }

    public long getId() {
        return id;
    }

    @Override
    public int compareTo(Student o) {
        if (this.id > o.id) {
            return 1;
        } else if (this.id < o.id) {
            return -1;
        }
        return 0;

//        return Integer.compare(this.id, o.id);

    }
}
