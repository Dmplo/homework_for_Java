package HomeWork.Lesson_10.Controller;

import HomeWork.Lesson_10.Data.User;

public interface StudentInterface<T extends User> {
    void createStudent(String lastName, String firstName, String patronymic, int age);

}
