package HomeWork.Exception_Lesson_16.Task_1.Core.Infrastructure.Logger;

import java.io.IOException;

public interface ILogger {

    void closeLog();

    void findFile(String path, String fileName) throws IOException;

    void log(String note);

    void createLog();
}
