package HomeWork.Exception_Lesson_16.Task_1.Core.Infrastructure.Config;

public class Config {
    public static String getPath(String dir, String name) {
        String pathProject = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String path = pathProject + separator + "src" + separator + "Homework" + separator + "Exception_Lesson_16" + separator + "Task_1" + separator + dir;
        String fileName = separator.concat(name);
        return path.concat(fileName);
    }

    ;
}
