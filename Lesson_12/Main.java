package HomeWork.Lesson_12;

import HomeWork.Lesson_12.controller.StudentController;
import HomeWork.Lesson_12.controller.StudentGroupController;
import HomeWork.Lesson_12.data.Teacher;
import HomeWork.Lesson_12.service.StudentGroupService;
import HomeWork.Lesson_12.service.StudentService;
import HomeWork.Lesson_12.view.StudentGroupView;
import HomeWork.Lesson_12.view.StudentView;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        StudentController studentController = new StudentController(new StudentService(), new StudentView());


        studentController.create("Will", "Smith", "Nikolaevich", LocalDate.parse("2002-04-12"));
        studentController.create("John", "Conor", "Eduardovich", LocalDate.parse("1982-08-30"));
        studentController.create("Peter", "Parker", "Vladimirovich", LocalDate.parse("1978-12-25"));
        studentController.create("Ozzy", "Osborne", "Ceviche", LocalDate.parse("1965-01-17"));
        studentController.create("Erik", "Hartman", "Gennadievich", LocalDate.parse("2012-07-21"));
//        studentController.printAllStudent();


        StudentGroupController studentGroupController = new StudentGroupController(new StudentGroupService(), new StudentGroupView(), new StudentView());
        Teacher teacher = new Teacher("1", "2", "3", LocalDate.parse("2022-04-17"));
        studentGroupController.createStudentGroup(teacher, studentController.getAllStudents());
        System.out.println("++");
        studentGroupController.getSortedListByFIOStudentFromStudentGroup();
//        studentGroupController.getStudentInStudentGroup("Will", "Smith");
//        studentGroupController.getSortedListStudentFromStudentGroup();
    }
}
