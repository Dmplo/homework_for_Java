package HomeWork.Lesson_13.Infrastructure.Logger;

public interface ILogger {

    void closeLog();

    void log(String note);

    void createLog();


}
