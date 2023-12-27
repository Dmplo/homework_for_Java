package HomeWork.Lesson_17.Core.Infrastructure.Logger;

import java.io.IOException;

public interface ILogger {

    void closeLog();

    void findFile(String path, String fileName) throws IOException;

    void log(String note, int index);

    void createLog();

    void headMsg();
}
