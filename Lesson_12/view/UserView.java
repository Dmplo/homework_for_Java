package HomeWork.Lesson_12.view;


import HomeWork.Lesson_12.data.User;

import java.util.List;

public interface UserView<T extends User>{
    void sendOnConsole(List<T> list);

}
