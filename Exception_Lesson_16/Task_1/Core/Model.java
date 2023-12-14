package HomeWork.Exception_Lesson_16.Task_1.Core;

import HomeWork.Exception_Lesson_16.Task_1.Core.Infrastructure.Exceptions.StringFormatException;
import HomeWork.Exception_Lesson_16.Task_1.Core.Infrastructure.Exceptions.UserNumberFormatException;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Model {

    public Long checkString(String value) throws UserNumberFormatException {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new UserNumberFormatException(value);
        }
    }

    public Boolean writeToFile(String str, String path) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write(str);
            writer.write("\n");
            writer.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String checkSex(String value) throws StringFormatException {
        if (value.equals("f") || value.equals("m")) {
            return value;
        } else {
            throw new StringFormatException("\nВы ввели неверное значение в поле \"Пол\" -> " + value + " <- ожидается: f или m");
        }
    }

    public LocalDate checkDateOfBirth(String startDateString) {
//
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        f = f.withResolverStyle(ResolverStyle.STRICT);
        try {
            return LocalDate.parse(startDateString, f);
        } catch (DateTimeParseException e) {
            throw e;
        }

    }

    public String checkInitials(String value) throws StringFormatException {
        String[] initials = value.split(",");
        if (initials.length != 3) {
            throw new StringFormatException("\nВы ввели неверные значения в поле \"ФИО\"!");
        } else {
            for (String initial : initials) {
                if (!initial.matches("^[a-zA-ZА-Яа-я]+$")) {
                    throw new StringFormatException("\nДанные в поле \"ФИО\" должны содержать только буквы!");
                }
            }
        }
        return initials[0];
    }
}
