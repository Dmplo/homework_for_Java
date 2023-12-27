package HomeWork.Lesson_17.Client;

import HomeWork.Lesson_17.Core.Infrastructure.Config.Config;
import HomeWork.Lesson_17.Core.Infrastructure.Logger.ILogger;
import HomeWork.Lesson_17.Core.Infrastructure.Logger.Logger;
import HomeWork.Lesson_17.Core.Model;
import HomeWork.Lesson_17.Core.Presenter;
import HomeWork.Lesson_17.Core.View;

public class App {
    Presenter presenter;
    Model model;
    View view;
    String path;
    ILogger logger;

    public App() {
        this.path = "proba.txt";
        this.model = new Model(path);
        this.view = new ConsoleView();
        this.logger = new Logger(Config.getPath("Log", "log.txt"));
        this.presenter = new Presenter(model, view, logger);
    }

    public void start() {
        int index = 1;
        while (true) {
            view.print("\n> Главное меню <");
            view.print(String.format("Количество игрушек: %d шт", presenter.getToysCount()));
            view.print("Выберите номер:\n1.Добавить игрушку\n2.Разыграть игрушку\n3.Изменить частоту выпадения\n4.Показать все игрушки\n0.Выход");
            String result = view.get();
            if (result.equals("0")) {
                view.print("\n> Выход из программы <");
                break;
            }
            switch (result) {
                case "1":
                    view.print("\n> Добавление новой игрушки <");
                    presenter.add();
                    break;
                case "2":
                    if (presenter.getToysCount() > 1) {
                        view.print(String.format("\nРозыгрыш игрушки №%s", index));
                        presenter.getDrop(index);
                        index++;
                    } else {
                        view.print("\nОшибка! Количество игрушек должно быть 2 или более!");
                    }
                    break;
                case "3":
                    if (presenter.getToysCount() > 0) {
                        view.print("\n> Изменение частоты выпадения <");
                        presenter.changeDropFrequency();
                        index = 1;
                    } else {
                        view.print("\nПусто!");
                    }
                    break;
                case "4":
                    if (presenter.getToysCount() > 0) {
                        view.print("\n> Список игрушек: <");
                        presenter.showAllToys();
                    } else {
                        view.print("\nПусто!");
                    }
                    break;
                default:
                    view.print("\nНеверная команда!");
            }
        }

    }
}
