package HomeWork.Lesson_9;

import java.util.Comparator;
import java.util.List;

public class StreamService {

    public void streamSort(List<Stream> list) {
        list.sort(new StreamComparator());
    }

}
