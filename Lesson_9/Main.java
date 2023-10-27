package HomeWork.Lesson_9;


import HomeWork.Lesson_9.People.LastNames;
import HomeWork.Lesson_9.People.Names;
import HomeWork.Lesson_9.People.Student;
import HomeWork.Lesson_9.People.Teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Stream stream1 = new Stream();
        Stream stream2 = new Stream();
        createStream(stream1);
        createStream(stream2);

        ArrayList<Stream> list = new ArrayList<>();
        list.add(stream1);
        list.add(stream2);

        Controller controller = new Controller(new StreamService());
        controller.streamService.streamSort(list);

        list.forEach(n -> {
            System.out.println(n.getSize());
            while (n.hasNext()) {
                StudyGroup group = n.next();
                System.out.println(group);
            }
        });
    }

    private static String getFName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }

    private static String getLName() {
        return String.valueOf(LastNames.values()[new Random().nextInt(LastNames.values().length)]);
    }

    public static void fillStudents(StudyGroup group) {
        Random rnd = new Random();
        int count = rnd.nextInt(5, 15);
        for (int i = 1; i < count; i++) {
            int age = rnd.nextInt(18, 30);
            group.addStudent(new Student(getFName(), getLName(), age));
        }
    }
    public static void createStream(Stream stream) {
        Random rnd = new Random();
        int count = rnd.nextInt(3, 11);
        for (int i = 1; i < count; i++) {
            stream.addGroup(createAndFillGroup());
        }
    }

    public static StudyGroup createAndFillGroup() {
        Random rnd = new Random();
        int number = rnd.nextInt(1200, 1300);
        int age = rnd.nextInt(25, 51);
        StudyGroup group = new StudyGroup(new Teacher(getFName(), getLName(), age), number);
        fillStudents(group);
        return group;


    }
}


