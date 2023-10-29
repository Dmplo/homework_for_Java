package HomeWork.Lesson_10.View;

import HomeWork.Lesson_10.Data.Student;
import HomeWork.Lesson_10.Data.Teacher;

import java.util.List;

public class TeacherView implements UserView<Teacher>{
    @Override
    public void sendOnConsole(List<Teacher> teachers) {
        for (Teacher teacher: teachers) {
            System.out.println(teacher);
        }
    }
    public void edit(Teacher teacher) {

    }
}
