package HomeWork.Lesson_11.Model;

public class Student extends User {
    protected int studentId;

    public Student(String firstName, String lastName, String patronymic, int studentId) {
        super(firstName, lastName, patronymic);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }


    @Override
    public String toString() {
        return "Student" + "[" + super.toString() + ", id = " + studentId + "]";
    }


}
