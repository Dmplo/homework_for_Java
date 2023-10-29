package HomeWork.Lesson_10.View;
import HomeWork.Lesson_10.Data.User;
import java.util.List;

public interface UserView<T extends User>{

   void sendOnConsole(List<T> students);


}
