package HomeWork.Lesson_13.Infrastructure.Logger;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger implements ILogger {
    String path;

    private static FileWriter fileWriter;

    public Logger(String path) {
        this.path = path;
    }

    public void createLog() {
        try {
            fileWriter = new FileWriter(path, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void log(String note) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String timeStamp = dateFormat.format(new Date());
            fileWriter.write(timeStamp + " " + note + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeLog() {
        try {
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
