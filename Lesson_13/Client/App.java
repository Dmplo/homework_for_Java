package HomeWork.Lesson_13.Client;

import HomeWork.Lesson_13.Infrastructure.Config.Config;
import HomeWork.Lesson_13.Core.Model.Model;
import HomeWork.Lesson_13.Core.Presenter.Presenter;
import HomeWork.Lesson_13.Core.View.View;
import HomeWork.Lesson_13.Infrastructure.Data.Calculator;
import HomeWork.Lesson_13.Infrastructure.Logger.ILogger;
import HomeWork.Lesson_13.Infrastructure.Logger.Logger;

public class App {
    Presenter presenter;
    View view;
    Model model;
    ILogger logger;

    public App() {
        this.view = new ConsoleView();
        this.model = new Model(new Calculator());
        this.logger = new Logger(getPath());
        this.presenter = new Presenter(model, view, logger);
    }

    public void start() {
        presenter.writeLog("Запуск программы");
        StringBuilder sb = new StringBuilder();
        sb.append("===\nВведите команду:\n1 - Сложение\n2 - Умножение \n3 - Деление;\n0 - Выход\n");
        while (true) {
            view.print(sb.toString());
            switch (view.getInputStr()) {
                case "1" -> presenter.getSum();
                case "2" -> presenter.getMultiplication();
                case "3" -> presenter.getDivide();
                case "0" -> {
                    presenter.writeLog("Выход из программы");
                    view.print("Выход из программы\n");
                    return;
                }
                default -> {
                    presenter.writeLog("Пользователь ввел неверное значение команды меню!");
                    view.print("Неверное значение команды меню!\n");
                }
            }
        }
    }

    private static String getPath() {
        String pathProject = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String path = pathProject + separator + "src";
        String fileLogName = separator.concat(Config.getPath());
        return path.concat(fileLogName);
    }
}


