package HomeWork.Lesson_17.Core;

import HomeWork.Lesson_17.Core.Infrastructure.Model.Toy;

import java.util.ArrayList;
import java.util.List;

public class Model {
    List<Toy> list;
    String path;

    public Model(String path) {
        this.list = new ArrayList<>();
        this.path = path;
    }

    private int getId() {
        int id = 0;
        if (list.size() > 0) {
            for (Toy toy : list) {
                if (toy.getId() > id) {
                    id = toy.getId();
                }
            }
            id++;
        } else {
            id = 1;
        }
        return id;
    }

    public String dropFrequency(int toyId, int dropFrequency) throws ArrayIndexOutOfBoundsException {
        Toy toy = list.get(toyId);
        if (toy.getDrop() == dropFrequency) {
            return "\nОшибка! Игрушка уже содержит такое значение!";
        }
        int oldDropFrequency = toy.getDrop();
        toy.setDrop(dropFrequency);
        return String.format("\nЧастота выпадения у игрушки \"%s\" изменена. Старое значение: %d, новое значение: %d.", toy.getName(), oldDropFrequency, dropFrequency);
    }

    void add(String name, int drop) {
        list.add(new Toy(getId(), name, drop));
    }

    public List<Toy> getAllToys() {
        return list;
    }
}
