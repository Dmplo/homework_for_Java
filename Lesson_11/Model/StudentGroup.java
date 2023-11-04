package HomeWork.Lesson_11.Model;

import java.util.List;

public class StudentGroup {
    private int number;
    private Teacher teacher;
    private List<Student> students;

    public StudentGroup(int number, Teacher teacher, List<Student> students) {
        this.number = number;
        this.teacher = teacher;
        this.students = students;
    }


    public int getNumber() {
        return number;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "number=" + number +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }
}
