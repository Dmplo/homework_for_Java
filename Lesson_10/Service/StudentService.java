package HomeWork.Lesson_10.Service;

import HomeWork.Lesson_10.Data.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements UserService<Student> {

    private final List<Student> students;
    private int countStudentsId;

    public StudentService() {
        this.students = new ArrayList<>();
    }

    @Override
    public void create(String firstName, String lastName, String patronymic, int age) {
        if (countStudentsId < this.students.size()) {
            countStudentsId = this.students.size();
        }
        Student student = new Student(firstName, lastName, patronymic, age, ++countStudentsId);
        students.add(student);
    }

    public List<Student> getAll() {
        return students;
    }

}
