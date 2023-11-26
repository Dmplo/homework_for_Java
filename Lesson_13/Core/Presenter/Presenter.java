package HomeWork.Lesson_13.Core.Presenter;

import HomeWork.Lesson_13.Core.Model.Model;
import HomeWork.Lesson_13.Core.View.View;
import HomeWork.Lesson_13.Infrastructure.Logger.ILogger;

public class Presenter {
    Model model;
    View view;
    ILogger logger;

    public Presenter(Model model, View view, ILogger logger) {
        this.model = model;
        this.view = view;
        this.logger = logger;
    }

    private double[] userInput() {
        double[] arr = new double[2];
        view.print("Введите первое число: ");
        arr[0] = view.getInputInt();
        view.print("Введите второе число: ");
        arr[1] = view.getInputInt();
        return arr;
    }

    public void getSum() {
        double[] arr = userInput();
        double result = model.getSum(arr[0], arr[1]);
        writeLog("Операция: сложение. Первое слагаемое: " + arr[0] + ", второе слагаемое: " + arr[1] + ", сумма = " + result);
        view.print(String.format("Результат %.1f\n", result));
    }

    public void getMultiplication() {
        double[] arr = userInput();
        double result = model.getMultiplication(arr[0], arr[1]);
        writeLog("Операция: умножение. Первый множитель: " + arr[0] + ", второй множитель: " + arr[1] + ", произведение = " + result);
        view.print(String.format("Результат %.1f\n", result));
    }

    public void getDivide() {
        double[] arr = userInput();
        if (arr[1] == 0) {
            view.printErr("Ошибка, деление на ноль!\n===\n");
            writeLog("Ошибка, деление на ноль!");
        } else {
            double result = model.getDivide(arr[0], arr[1]);
            writeLog("Операция: деление. Делимое число: " + arr[0] + ", делитель: " + arr[1] + ", частное = " + result);
            view.print(String.format("Результат %.1f\n", result));
        }
    }

    public void writeLog(String str) {
        logger.createLog();
        logger.log(str);
        logger.closeLog();
    }

}
