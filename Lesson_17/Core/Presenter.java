package HomeWork.Lesson_17.Core;

import HomeWork.Lesson_17.Core.Infrastructure.Logger.ILogger;
import HomeWork.Lesson_17.Core.Infrastructure.Model.Toy;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Presenter {
    Model model;
    View view;
    ILogger logger;

    public Presenter(Model model, View view, ILogger logger) {
        this.model = model;
        this.view = view;
        this.logger = logger;
    }

    public void getDrop(int index) {
        Queue<Toy> queue = new PriorityQueue<>();
        List<Toy> allToys = model.getAllToys();
        Random rnd = new Random();
        if (allToys.size() >= 2) {
            for (Toy toy : allToys) {
                for (int i = 0; i < toy.getDrop(); i++) {
                    Toy temp = new Toy(toy.getId(), toy.getName(), rnd.nextInt(10));
                    queue.add(temp);
                }
            }
        }
        Toy toy = queue.poll();
        view.print(String.format("Выпала игрушка: \"%s\"", toy.getName()));
        writeLog(String.format("Выпала игрушка: \"%s\"", toy.getName()), index);
    }

    public void writeLog(String str, int index) {
        logger.createLog();
        if (index == 1) {
            logger.headMsg();
        }
        logger.log(str, index);
        logger.closeLog();
    }

    public int getToysCount() {
        return model.getAllToys().size();
    }

    public void add() {
        view.print("Введите название:");
        String name = view.get();
        view.print("Введите частоту выпадения игрушки:");
        try {
            int drop = isInt(view.get());
            model.add(name, drop);
            view.print("\nИгрушка успешно добавлена!");
        } catch (NumberFormatException e) {
            view.print("\nОшибка! Неверное значение, попробуйте заново!");
        }
    }

    public void showAllToys() {
        for (Toy toy : model.getAllToys()) {
            view.print(String.format("%s. Название: \"%s\", частота выпадения: %s", toy.getId(), toy.getName(), toy.getDrop()));
        }
    }

    public void changeDropFrequency() {
        view.print("Выберите номер:");
        showAllToys();
        view.print("0. Для возврата в предыдущее меню");
        try {
            String answer = view.get();
            if (answer.equals("0")) {
                return;
            }
            int toyId = isInt(answer);
            if (toyId > 0 && toyId <= model.getAllToys().size()) {
                view.print("Введите частоту выпадения игрушки:");
                int dropFrequency = isInt(view.get());
                view.print(model.dropFrequency(--toyId, dropFrequency));
            } else throw new ArrayIndexOutOfBoundsException();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            view.print("\nОшибка! Неверное значение, попробуйте заново!");
        }
    }

    public int isInt(String drop) throws NumberFormatException {
        return Integer.parseInt(drop);
    }
}
