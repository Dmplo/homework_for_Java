package HomeWork.Lesson_12.controller;

import HomeWork.Lesson_12.data.Student;
import HomeWork.Lesson_12.data.Teacher;
import HomeWork.Lesson_12.data.UserComparator;
import HomeWork.Lesson_12.service.StudentGroupService;
import HomeWork.Lesson_12.view.StudentGroupView;
import HomeWork.Lesson_12.view.UserView;

import java.util.Collections;
import java.util.List;

public class StudentGroupController {

    private final StudentGroupService studentGroupService;
    private final StudentGroupView studentGroupView;
    private final UserView<Student> studentView;

    public StudentGroupController(StudentGroupService studentGroupService, StudentGroupView studentGroupView, UserView<Student> studentView) {
        this.studentGroupService = studentGroupService;
        this.studentGroupView = studentGroupView;
        this.studentView = studentView;
    }

    public void createStudentGroup(Teacher teacher, List<Student> students) {
        studentGroupService.createStudentGroup(teacher, students);
        studentGroupView.sendOnConsoleStudentGroup(studentGroupService.getStudentGroup());
    }

    //
    public void getStudentInStudentGroup(String firstName, String secondName) {
        Student student = studentGroupService.getStudentFromStudentGroup(firstName, secondName);
        studentView.sendOnConsole(Collections.singletonList(student));
    }

    public void getSortedListStudentFromStudentGroup() {
        List<Student> students = studentGroupService.getSortedStudentGroup();
        studentView.sendOnConsole(students);
    }

    public void getSortedListByFIOStudentFromStudentGroup() {
        List<Student> students = studentGroupService.getSortedByFIOStudentGroup(new UserComparator<Student>());
        studentView.sendOnConsole(students);
    }

}
