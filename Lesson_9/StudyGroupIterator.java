package HomeWork.Lesson_9;

import HomeWork.Lesson_9.People.Student;

import java.util.Iterator;
import java.util.List;

public class StudyGroupIterator implements Iterator<Student> {

    int index;
    private List<Student> list;

    public StudyGroupIterator(StudyGroup group) {
        this.index = 0;
        this.list = group.getAll();
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Student next() {
        return list.get(index++);
    }

    @Override
    public void remove() {
        list.remove(--index);
    }
}
