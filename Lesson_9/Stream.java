package HomeWork.Lesson_9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stream implements Iterator<StudyGroup> {

    private List<StudyGroup> list;
    private int index;

    public Stream() {
        this.list = new ArrayList<>();
        this.index = 0;
    }

    public List<StudyGroup> getGroups() {
        return list;
    }

    public void addGroup(StudyGroup group) {
        list.add(group);
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public StudyGroup next() {
        return list.get(index++);
    }
}
