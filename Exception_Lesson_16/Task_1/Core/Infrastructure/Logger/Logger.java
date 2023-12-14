package HomeWork.Exception_Lesson_16.Task_1.Core.Infrastructure.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Logger implements ILogger {
    String path;

    private static FileWriter fileWriter;

    public Logger(String path) {
        this.path = path;
    }
    @Override
    public void createLog() {
        try {
            fileWriter = new FileWriter(path, true);
        } catch (IOException e) {
            System.out.println("\nОшибка записи в лог, файл не найден\n");
            e.printStackTrace();
        }
    }

    @Override
    public void findFile(String path, String fileName) throws IOException {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("regex:.*" + fileName);
        Collection<Path> find = find(path, matcher);
        System.out.println(find);
    }

    protected static Collection<Path> find(String searchDirectory, PathMatcher matcher) throws IOException {
        try (Stream<Path> files = Files.walk(Paths.get(searchDirectory))) {
            return files
                    .filter(matcher::matches)
                    .collect(Collectors.toList());

        }
    }

    @Override
    public void log(String note) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String timeStamp = dateFormat.format(new Date());
            fileWriter.write(timeStamp + " " + note + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void closeLog() {
        try {
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
