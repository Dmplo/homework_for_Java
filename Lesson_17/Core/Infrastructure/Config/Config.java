package HomeWork.Lesson_17.Core.Infrastructure.Config;

public class Config {
    public static String getPath(String dir, String name) {
        String pathProject = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String path = pathProject + separator + "src" + separator + "Homework" + separator + "Lesson_17" + separator + dir;
        String fileName = separator.concat(name);
        return path.concat(fileName);
    }

    ;
}
