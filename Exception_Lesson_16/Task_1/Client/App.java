package HomeWork.Exception_Lesson_16.Task_1.Client;

import HomeWork.Exception_Lesson_16.Task_1.Core.Infrastructure.Config.Config;
import HomeWork.Exception_Lesson_16.Task_1.Core.Infrastructure.Logger.ILogger;
import HomeWork.Exception_Lesson_16.Task_1.Core.Infrastructure.Logger.Logger;
import HomeWork.Exception_Lesson_16.Task_1.Core.Model;
import HomeWork.Exception_Lesson_16.Task_1.Core.Presenter;
import HomeWork.Exception_Lesson_16.Task_1.Core.View;

import java.time.LocalDate;
import java.util.*;

public class App {
    Presenter presenter;
    View view;
    Model model;
    ILogger logger;

    public App() {
        this.view = new ConsoleView();
        this.model = new Model();
        this.logger = new Logger(Config.getPath("Log", "log.txt"));
        this.presenter = new Presenter(model, view, logger);
    }

    public void start() {
        presenter.writeLog("Запуск программы");
        while (true) {
            view.print(presenter.getMenu());
            String answer = view.get();
            String[] strArr = answer.split(" ");
            try {
                if (strArr.length != 4) {
                    throw new RuntimeException("error");
                }
                Map<String, String> map = new HashMap<>();
                for (int i = 0; i < strArr.length; i++) {
                    map.put(presenter.getParams()[i], strArr[i]);
                }
                Long phone = null;
                String sex = null;
                String initials = null;
                LocalDate dateOfBirth = null;
                String lastName = null;
                for (var item : map.entrySet()) {
                    switch (item.getKey()) {
                        case "ФИО":
                            lastName = presenter.checkInitials(item.getValue());
                            initials = item.getValue();
                            break;
                        case "Дата рождения":
                            dateOfBirth = presenter.checkDateOfBirth(item.getValue());
                            break;
                        case "Номер телефона":
                            phone = presenter.checkString(item.getValue());
                            break;
                        case "Пол":
                            sex = presenter.checkSex(item.getValue());
                    }
                }
                if (phone != null && sex != null && dateOfBirth != null && initials != null && lastName != null) {
                    presenter.save(initials, dateOfBirth, phone, sex, lastName);
                }
            } catch (RuntimeException e) {
                view.print("\nВы неверно заполнили требуемые поля!");
                presenter.writeLog("Пользователь неверно заполнил поля");
            }
            int nextAction = checkInput(new int[]{1, 2});
            if (nextAction == 2) {
                presenter.writeLog("Выход из программы");
                view.print("\nВыход из программы\n");
                return;
            }
            presenter.writeLog("Повтор ввода данных");
        }
    }

    private int checkInput(int[] arr) {
        String message = "\nВыберите дальнейшее действие:\n1.Повторить ввод\n2.Выход\n";
        while (true) {
            view.print(message);
            String nextAction = view.get();
            try {
                int toCheckValue = Integer.parseInt(nextAction);
                int result = Arrays.binarySearch(arr, toCheckValue);
                if (result >= 0) {
                    return toCheckValue;
                }
                view.print("\nВведено неверное значение!");
            } catch (NumberFormatException e) {
                view.print("\nВведено нечисловое значение!");
            }
        }
    }
}


