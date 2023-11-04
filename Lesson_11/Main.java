package HomeWork.Lesson_11;

import HomeWork.Lesson_10.Enums.LastNames;
import HomeWork.Lesson_10.Enums.Names;
import HomeWork.Lesson_10.Enums.Patronymic;
import HomeWork.Lesson_11.Controller.Controller;
import HomeWork.Lesson_11.Enums.Type;
import HomeWork.Lesson_11.Service.DataService;
import HomeWork.Lesson_9.People.Student;
import HomeWork.Lesson_9.People.Teacher;
import HomeWork.Lesson_9.Stream;
import HomeWork.Lesson_9.StudyGroup;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createGroup(5);
        controller.createGroup(5);

        controller.printGroupInfo();

        controller.createUser(controller.rndFirstName(), controller.rndLastName(), controller.rndPatronymic(), Type.Student);
        System.out.println();
        controller.printAllStudents();

    }
}
