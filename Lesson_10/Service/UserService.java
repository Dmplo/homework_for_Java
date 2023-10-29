package HomeWork.Lesson_10.Service;

import HomeWork.Lesson_10.Data.Student;
import HomeWork.Lesson_10.Data.User;

import java.util.List;

public interface UserService<T extends User> {
    void create(String firstName, String lastName, String patronymic, int age);

    List<T> getAll();
}
