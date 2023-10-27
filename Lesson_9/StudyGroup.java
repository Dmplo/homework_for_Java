package HomeWork.Lesson_9;

import HomeWork.Lesson_9.People.Student;
import HomeWork.Lesson_9.People.Teacher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudyGroup implements Iterable<Student> {
    private List<Student> list;
    Teacher teacher;
    private int number;

    public StudyGroup(Teacher teacher, int number) {
        this.list = new ArrayList<>();
        this.teacher = teacher;
        this.number = number;
    }

    public void addStudent(Student student) {
        if (!list.contains(student))
            list.add(student);
    }

    public List<Student> getAll() {
        return list;
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudyGroupIterator(this);
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public String toString() {
        return "StudyGroup" +
                ", number=" + this.number +
                " [" + "countStudents=" + this.list.size() +
                ", teacher=" + this.teacher +
                "]";
    }
}


