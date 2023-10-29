package HomeWork.Lesson_10.Controller;

import HomeWork.Lesson_10.Data.User;

public interface TeacherInterface<T extends User> {
    void createTeacher(String lastName, String firstName, String patronymic, int age);

}
