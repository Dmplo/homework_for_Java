package HomeWork.Lesson_11.Controller;

import HomeWork.Lesson_10.Enums.LastNames;
import HomeWork.Lesson_10.Enums.Names;
import HomeWork.Lesson_10.Enums.Patronymic;
import HomeWork.Lesson_11.Enums.Type;
import HomeWork.Lesson_11.Model.Student;
import HomeWork.Lesson_11.Model.Teacher;
import HomeWork.Lesson_11.Model.User;
import HomeWork.Lesson_11.Service.DataService;
import HomeWork.Lesson_11.Service.StudentGroupService;
import HomeWork.Lesson_11.View.StudentGroupView;
import HomeWork.Lesson_11.View.UserView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {
    private DataService dataService;
    private StudentGroupService studentGroupService;
    private UserView studentView;
    private StudentGroupView studentGroupView;

    private Random rnd;

    public Controller() {
        this.dataService = new DataService();
        this.studentGroupView = new StudentGroupView();
        this.studentView = new UserView();
        this.studentGroupService = new StudentGroupService();
        this.rnd = new Random();
        this.createStudents(30);
        this.createTeachers(20);
    }

    public void createUser(String firstName, String lastName, String patronymic, Type type) {
        dataService.add(firstName, lastName, patronymic, type);
    }

    public void createGroup(int quantityStudents) {
        int number = this.rnd.nextInt(1200, 1300);
        int teacherId = this.rnd.nextInt(1, dataService.getAllTeachers().size());
        User teacher = dataService.getTeacherById(teacherId);
        if (teacher != null) {
            List<Student> students = new ArrayList<>();
            for (int i = 0; i < quantityStudents; i++) {
                int studentId = this.rnd.nextInt(1, dataService.getAllStudents().size());
                User student = dataService.getStudentById(studentId);
                if (student != null) {
                    students.add(((Student) student));
                } else {
                    System.out.printf("%s%d\n" ,"Произошла ошибка при добавлении студента с id:", studentId);
                    return;
                }
            }
            this.studentGroupService.createGroup(number, (Teacher) teacher, students);
        } else {
            System.out.printf("%s%d\n" ,"Произошла ошибка при добавлении учителя с id:", teacherId);
        }

    }

    private void createStudents(int qty) {
        for (int i = 0; i < qty; i++) {
            this.createUser(this.rndFirstName(), rndLastName(), rndPatronymic(), Type.Student);
        }
    }

    private void createTeachers(int qty) {
        for (int i = 0; i < qty; i++) {
            this.createUser(this.rndFirstName(), rndLastName(), rndPatronymic(), Type.Teacher);
        }
    }

    public void printGroupInfo() {
        studentGroupService.getStudentGroups().forEach(n -> studentGroupView.printOnConsole(n));
    }

    public void printAllStudents() {
        dataService.getAllStudents().forEach(n -> studentView.printOnConsole(n));
    }

    public void printAllTeachers() {
        dataService.getAllTeachers().forEach(n -> studentView.printOnConsole(n));
    }

    public void getStudentById(int studentId) {
        User result = dataService.getStudentById(studentId);

        if (result == null) {
            System.out.printf("%s%d %s\n", "Студент с id:", studentId, "не найден!");
        } else {
            this.studentView.printOnConsole(result);
        }
    }

    public void getTeacherById(int teacherId) {
        User result = dataService.getTeacherById(teacherId);
        if (result == null) {
            System.out.printf("%s%d %s\n", "Учитель с id:", teacherId, "не найден!");
        } else {
            this.studentView.printOnConsole(result);
        }
    }

    public String rndFirstName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }

    public String rndLastName() {
        return String.valueOf(LastNames.values()[new Random().nextInt(LastNames.values().length)]);
    }

    public String rndPatronymic() {
        return String.valueOf(Patronymic.values()[new Random().nextInt(Patronymic.values().length)]);
    }


}
