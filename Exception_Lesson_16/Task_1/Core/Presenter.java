package HomeWork.Exception_Lesson_16.Task_1.Core;

import HomeWork.Exception_Lesson_16.Task_1.Core.Infrastructure.Config.Config;
import HomeWork.Exception_Lesson_16.Task_1.Core.Infrastructure.Exceptions.StringFormatException;
import HomeWork.Exception_Lesson_16.Task_1.Core.Infrastructure.Exceptions.UserNumberFormatException;
import HomeWork.Exception_Lesson_16.Task_1.Core.Infrastructure.Logger.ILogger;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Presenter {
    private Model model;
    private final View view;
    private final ILogger logger;
    private final String[] params = new String[4];

    public Presenter(Model model, View view, ILogger logger) {
        this.model = model;
        this.view = view;
        this.logger = logger;
    }

    public String[] getParams() {
        return params;
    }

    public void save(String initials, LocalDate dateOfBirth, Long phone, String sex, String lastName) {
        String fileName = lastName.toLowerCase().concat(".txt");
        String path = Config.getPath("Files", fileName);
        String info;
        try {
            logger.findFile(path, fileName);
            info = String.format("Открытие файла %s для записи", fileName);
        } catch (IOException e) {
            info = String.format("Создание файла %s для записи", fileName);
        }
        writeLog(info);
        view.print(info);
        String userInfo = String.format("Initials: %s, birth: %s, phone: %s, sex: %s", initials.replaceAll(",", " "), dateOfBirth, phone, sex);
        String message = model.writeToFile(userInfo, path) ? "Запись удалась" : "Запись не удалась";
        writeLog(message);
        view.print(message);
    }

    public String getMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nВведите данные используя пробел как разделитель:\n");
        String[] items = new String[]{"ФИО", "Дата рождения", "Номер телефона", "Пол"};
        String[] format = new String[]{"Фамилия,Имя,Отчество", "дд.мм.гггг", "целое беззнаковое число без форматирования", "символ латиницей f или m"};

        ArrayList<String> menuItems = new ArrayList<>(Arrays.asList(items));
        ArrayList<String> formatItems = new ArrayList<>(Arrays.asList(format));
        Random rnd = new Random();
        int i = 1;
        while (menuItems.size() > 0) {
            int index = rnd.nextInt(menuItems.size());
            params[i - 1] = menuItems.get(index);
            String note = menuItems.get(index).equals("ФИО") ? "в формате без пробелов, через запятую:" : "в формате:";
            sb.append(String.format("%d. -->%s<-- (%s %s)\n", i, menuItems.get(index), note, formatItems.get(index)));
            menuItems.remove(index);
            formatItems.remove(index);
            i++;
        }
        return sb.toString();
    }

    public Long checkString(String value) {
        try {
            return model.checkString(value);
        } catch (UserNumberFormatException e) {
            view.print(e.getMessage());
            writeLog("Ошибка при вводе данных в поле \"Номер телефона\"");
        }
        return null;
    }

    public String checkSex(String value) {
        try {
            return model.checkSex(value.toLowerCase());
        } catch (StringFormatException e) {
            view.print(e.getMessage());
            writeLog("Ошибка при вводе данных в поле \"Пол\"");

        }
        return null;
    }

    public LocalDate checkDateOfBirth(String startDateString) {
        try {
            return model.checkDateOfBirth(startDateString);
        } catch (DateTimeParseException e) {
            view.print(String.format("\nВы ввели неверное значение в поле \"Дата рождения\" ->%s<- такой даты не существует!", startDateString));
            writeLog("Ошибка при вводе данных в поле \"Дата рождения\"");
        }
        return null;
    }

    public String checkInitials(String value) {
        try {
            return model.checkInitials(value);
        } catch (StringFormatException e) {
            view.print(e.getMessage());
            writeLog("Ошибка при вводе данных в поле \"ФИО\"");
        }
        return null;
    }

    public void writeLog(String str) {
        logger.createLog();
        logger.log(str);
        logger.closeLog();
    }
}
