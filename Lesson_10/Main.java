package HomeWork.Lesson_10;


import HomeWork.Lesson_10.Controller.StudentController;
import HomeWork.Lesson_10.Controller.TeacherController;
import HomeWork.Lesson_10.Enums.LastNames;
import HomeWork.Lesson_10.Enums.Names;
import HomeWork.Lesson_10.Enums.Patronymic;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        studentController.createStudent(getLastName(), getFirstName(), getPatronymic(), randomAge());
        studentController.createStudent(getLastName(), getFirstName(), getPatronymic(), randomAge());
        studentController.createStudent(getLastName(), getFirstName(), getPatronymic(), randomAge());
        studentController.sendOnConsole();
        System.out.println();
        TeacherController teacherController = new TeacherController();
        teacherController.createTeacher(getLastName(), getFirstName(), getPatronymic(), randomAge());
        teacherController.createTeacher(getLastName(), getFirstName(), getPatronymic(), randomAge());
        teacherController.createTeacher(getLastName(), getFirstName(), getPatronymic(), randomAge());
        teacherController.sendOnConsole();

        teacherController.editTeacher();
    }

    private static String getFirstName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }

    private static String getLastName() {
        return String.valueOf(LastNames.values()[new Random().nextInt(LastNames.values().length)]);
    }

    private static String getPatronymic() {
        return String.valueOf(Patronymic.values()[new Random().nextInt(Patronymic.values().length)]);
    }

    public static int randomAge() {
        return new Random().nextInt(22, 51);
    }
}


