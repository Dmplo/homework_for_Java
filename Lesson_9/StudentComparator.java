package HomeWork.Lesson_9;

import HomeWork.Lesson_9.People.Student;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {

        int studentComparator = o1.getfName().compareTo(o2.getfName());
        if (studentComparator == 0) {
            studentComparator = o1.getlName().compareTo(o2.getlName());
            if (studentComparator == 0) {
                return Integer.compare(o1.getAge(), o2.getAge());
            } else {
                return studentComparator;
            }
        }
        return studentComparator;
    }
}
