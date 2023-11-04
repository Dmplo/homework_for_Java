package HomeWork.Lesson_11.Service;


import HomeWork.Lesson_11.Model.Student;
import HomeWork.Lesson_11.Model.StudentGroup;
import HomeWork.Lesson_11.Model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class StudentGroupService {
    List<StudentGroup> studentGroups;

    public StudentGroupService() {
        this.studentGroups = new ArrayList<>();
    }

    public void createGroup(int number, Teacher teacher, List<Student> students) {
        this.studentGroups.add(new StudentGroup(number, teacher, students));
    }

    public List<StudentGroup> getStudentGroups() {
        return studentGroups;
    }
}
