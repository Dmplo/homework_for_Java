package HomeWork.Lesson_12.view;



import HomeWork.Lesson_12.data.Student;
import HomeWork.Lesson_12.data.StudentGroup;

import java.util.List;
import java.util.logging.Logger;

public class StudentView implements UserView<Student>{

//    Logger logger = Logger.getLogger(StudentView.class.getName());

    @Override
    public void sendOnConsole(List<Student> students) {
        for(Student user: students){
            System.out.println(user.toString());
//            logger.info(user.toString());
        }
    }

}
