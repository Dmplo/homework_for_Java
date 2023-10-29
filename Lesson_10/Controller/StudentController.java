package HomeWork.Lesson_10.Controller;

import HomeWork.Lesson_10.Data.Student;
import HomeWork.Lesson_10.Service.StudentService;
import HomeWork.Lesson_10.View.StudentView;

import java.util.List;

public class StudentController implements UserController<Student>, StudentInterface<Student> {

    private StudentService studentService;
    private StudentView studentView;


    public StudentController() {
//        this.streamService = streamService;
        this.studentService = new StudentService();
        this.studentView = new StudentView();
    }



    @Override
    public void sendOnConsole() {
        studentView.sendOnConsole(studentService.getAll());
    }

    @Override
    public void createStudent(String lastName, String firstName, String patronymic, int age) {
        studentService.create(lastName, firstName, patronymic, age);
    }
}
