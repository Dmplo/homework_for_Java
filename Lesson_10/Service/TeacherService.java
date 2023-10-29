package HomeWork.Lesson_10.Service;

import HomeWork.Lesson_10.Data.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherService implements UserService<Teacher> {

    List<Teacher> teachers;
    int countTeachersId;

    public TeacherService() {
        this.teachers = new ArrayList<>();
    }

    @Override
    public void create(String firstName, String lastName, String patronymic, int age) {
        if (countTeachersId < this.teachers.size()) {
            countTeachersId = this.teachers.size();
        }
        Teacher teacher = new Teacher(firstName, lastName, patronymic, age, ++countTeachersId);
        teachers.add(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    public Teacher edit(int id, int value) {
        if (findTeacher(id) == null) {
            System.out.println("Teacher не найден");
            return null;
        }
        Teacher teacher = findTeacher(id);
        teacher.setAge(value);
        return teacher;
    }

    public Teacher edit(int id, String param, String value) {
        if (findTeacher(id) == null) {
            System.out.println("Teacher не найден");
            return null;
        }
        Teacher teacher = findTeacher(id);
        switch (param) {
            case "firstName" -> teacher.setFirstName(value);
            case "lastName" -> teacher.setLastName(value);
            case "patronymic" -> teacher.setPatronymic(value);
        }
        return teacher;
    }


    private Teacher findTeacher(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }
}
