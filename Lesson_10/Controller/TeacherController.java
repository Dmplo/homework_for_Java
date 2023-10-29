package HomeWork.Lesson_10.Controller;

import HomeWork.Lesson_10.Data.Teacher;
import HomeWork.Lesson_10.Service.TeacherService;
import HomeWork.Lesson_10.View.TeacherView;

import java.util.Collections;
import java.util.Scanner;

public class TeacherController implements UserController<Teacher>, TeacherInterface<Teacher> {

    private final TeacherService teacherService;
    private final TeacherView teacherView;

    protected static String[] fields;

    static {
        fields = new String[]{"Фамилия", "Имя", "Отчество", "Возраст"};
    }

    public TeacherController() {
        this.teacherService = new TeacherService();
        this.teacherView = new TeacherView();
    }


    @Override
    public void sendOnConsole() {
        teacherView.sendOnConsole(teacherService.getAll());
    }

    public int getCountTeachers() {
        return teacherService.getAll().size();
    }

    @Override
    public void createTeacher(String lastName, String firstName, String patronymic, int age) {
        teacherService.create(lastName, firstName, patronymic, age);
    }

    private static void getEditVariants() {

        for (int i = 0; i < fields.length; i++) {
            System.out.printf("%d %s\n", i + 1, fields[i]);
        }
    }

    public void editTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите id учителя, которого будете редактировать: ");
        if (scanner.hasNextInt()) {
            int teacherId = scanner.nextInt();
            if (teacherId > this.getCountTeachers() || teacherId <= 0) {
                System.out.println("Неверный номер id. Перезапустите программу и попробуйте снова!");
                return;
            }
                System.out.println("Выберите номер параметра для редактирования: ");
                getEditVariants();
                if (scanner.hasNextInt()) {
                   int variant = scanner.nextInt();
                    if (variant > 0 && variant <= fields.length) {
                        this.selectField(teacherId, variant);
                    } else {
                        System.out.println("Неверный номер параметра. Перезапустите программу и попробуйте снова!");
                    }
                } else {
                    System.out.println("Извините, но это явно не число. Перезапустите программу и попробуйте снова!");
                }
        } else {
            System.out.println("Извините, но это явно не число. Перезапустите программу и попробуйте снова!");
        }

    }

    private void selectField(int teacherId, int variant) {
        Scanner input = new Scanner(System.in);
        switch (variant) {
            case 1 -> {
                System.out.println("Введите значение поля \"Фамилия\"");
                String lastName = input.nextLine();
                this.editTeacherField(teacherId, "lastName", lastName);
            }
            case 2 -> {
                System.out.println("Введите значение поля \"Имя\"");
                String firstName = input.nextLine();
                this.editTeacherField(teacherId, "firstName", firstName);
            }
            case 3 -> {
                System.out.println("Введите значение поля \"Отчество\"");
                String patronymic = input.nextLine();
                this.editTeacherField(teacherId, "patronymic", patronymic);
            }
            case 4 -> {
                System.out.println("Введите значение поля \"Возраст\" от 20 до 100 лет");
                if (input.hasNextInt()) {
                    int age = input.nextInt();
                    if (age >= 20 && age <= 100) {
                        this.editTeacherField(teacherId, age);
                    } else {
                        System.out.println("Неверное значение возраста. Перезапустите программу и попробуйте снова!");
                    }
                } else {
                    System.out.println("Извините, но это явно не число. Перезапустите программу и попробуйте снова!");
                }
            }
        }
    }

    public void editTeacherField(int id, String field, String param) {
        Teacher teacher = teacherService.edit(id, field, param);
        if (teacher != null) {
            System.out.printf("%s %s\n", "Изменение прошло успешно", Collections.singletonList(teacher));
        }
    }

    public void editTeacherField(int id, int param) {
        Teacher teacher = teacherService.edit(id, param);
        if (teacher != null) {
            System.out.printf("%s %s\n", "Изменение прошло успешно", Collections.singletonList(teacher));
        }
    }
}
