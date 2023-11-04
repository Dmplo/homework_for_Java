package HomeWork.Lesson_11.Service;

import HomeWork.Lesson_11.Enums.Type;
import HomeWork.Lesson_11.Model.Student;
import HomeWork.Lesson_11.Model.Teacher;
import HomeWork.Lesson_11.Model.User;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    private final List<User> list;

    public DataService() {
        this.list = new ArrayList<>();
    }

    public void add(String firstName, String lastName, String patronymic, Type type) {
        if (type == Type.Student) {
            list.add(new Student(firstName, lastName, patronymic, this.getStudentId()));
        } else if (type == Type.Teacher) {
            list.add(new Teacher(firstName, lastName, patronymic, this.getTeacherId()));
        }
    }

    public List<User> getAllStudents() {
        List<User> students = new ArrayList<>();
        for (User user : this.list) {
            if (user instanceof Student) {
                students.add(user);
            }
        }
        return students;
    }

    public User getStudentById(int studentId) {
        User student = null;
        for (User user : this.getAllStudents()) {
            if (((Student) user).getStudentId() == studentId) {
                student = user;
            }
        }
        return student;
    }
    public User getTeacherById(int teacherId) {
        User teacher = null;
        for (User user : this.getAllTeachers()) {
            if (((Teacher) user).getTeacherId() == teacherId) {
                teacher = user;
            }
        }
        return teacher;
    }


    public List<User> getAllTeachers() {
        List<User> teachers = new ArrayList<>();
        for (User user : this.list) {
            if (user instanceof Teacher) {
                teachers.add(user);
            }
        }
        return teachers;
    }

    private int getStudentId() {
        return this.getAllStudents().size() + 1;
    }

    private int getTeacherId() {
        return this.getAllTeachers().size() + 1;
    }


//            private int getTeacherId () {
//                int id = 0;
//                for (User user : list) {
//                    if (user instanceof Teacher) {
//                        id = ((Teacher) user).getTeacherId();
//                    }
//                }
//                return ++id;
//            }


}



