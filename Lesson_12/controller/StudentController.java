package HomeWork.Lesson_12.controller;

import HomeWork.Lesson_12.data.Student;
import HomeWork.Lesson_12.service.UserService;
import HomeWork.Lesson_12.view.UserView;

import java.time.LocalDate;
import java.util.List;

public class StudentController implements UserController<Student> {
    private final UserService<Student> studentService;
    private final UserView<Student> studentView;

    public StudentController(UserService<Student> studentService, UserView<Student> studentView) {
        this.studentService = studentService;
        this.studentView = studentView;
    }

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        studentService.create(firstName, secondName, patronymic, dateOfBirth);
    }

    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    public void printAllStudent() {
        studentView.sendOnConsole(getAllStudents());
    }
}
