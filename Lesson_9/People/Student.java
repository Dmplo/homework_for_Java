package HomeWork.Lesson_9.People;

public class Student extends User implements Comparable<Student> {
    protected int id;

    public Student(String fName, String lName, int age) {
        super(fName, lName, age);
        this.id = User.number;
    }

    @Override
    public String toString() {
        return "Student" + "[" + super.toString() + ", id=" + id + "]";
    }

    public int getId() {
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
