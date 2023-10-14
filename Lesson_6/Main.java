package HomeWork.Lesson_6;


import java.util.*;

public class Main {
    /*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например:
"Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …"
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
Работу сдать как обычно ссылкой на гит репозиторий
Частые ошибки:
1. Заставляете пользователя вводить все существующие критерии фильтрации
2. Невозможно использовать более одного критерия фильтрации одновременно
3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков или добавить еще
ноутбук, то программа начинает работать некорректно
     */
    public static void main(String[] args) {
        int qtyProducts = 5;
        Set<Notebook> notebooks = generateNotebooks(qtyProducts);
        printValue(notebooks);
        talkWithUser(notebooks);
    }

    public static void talkWithUser(Set<Notebook> notebooks) {
        Map<String, Integer> map = new HashMap<>();
        Set<Notebook> findNotebooks = new HashSet<>();
        boolean find = false;
        String[] startStr = {"ОЗУ", "Объем ЖД", "Операционная система", "Цвет", "Поиск"};
        StringBuilder str = new StringBuilder("\nВведите цифру, соответствующую необходимой категории:\n");
        for (int i = 0; i < startStr.length; i++) {
            str.append(String.format("%d - %s\n", i + 1, startStr[i]));
        }
        Scanner scanner = new Scanner(System.in);
        boolean work = true;
        while (work) {
            System.out.println(str);
            if (map.size() > 0) {
                showUserFilter(map);
            }
            if (map.size() == (startStr.length - 1)) {
                findItem(notebooks, map, findNotebooks);
                find = true;
            }
            System.out.print("Категория: >> ");
            int answer = Integer.parseInt(scanner.nextLine());
            switch (answer) {
                case 1:
                    showSubMenu(map, scanner, Notebook.memoryVariants, "memory");
                    break;
                case 2:
                    showSubMenu(map, scanner, Notebook.hardDiskVariants, "hardDisk");
                    break;
                case 3:
                    showSubMenu(map, scanner, Notebook.osVariants, "os");
                    break;
                case 4:
                    showSubMenu(map, scanner, Notebook.colors, "color");
                    break;
                case 5:
                    if (map.size() < 1) {
                        System.out.printf("%s %d %s\n", "---> Фильтр не задан, показаны все товары в количестве:", notebooks.size(), "шт <---");
                        System.out.printf("%s", "----------------\n");
                        printValue(notebooks);
                        System.out.printf("%s", "----------------\n");
                        return;
                    } else {
                        findItem(notebooks, map, findNotebooks);
                    }
                    find = true;
            }
            if (find) {
                if (findNotebooks.size() > 0) {
                    System.out.printf("%s %d %s\n", "---> Успешно, количество совпадений:", findNotebooks.size(), "<---");
                    System.out.printf("%s", "----------------\n");
                    for (Notebook note : findNotebooks) {
                        System.out.println(note);
                    }
                    System.out.printf("%s", "----------------\n");
                } else {
                    System.out.println("Совпадений не найдено");
                }
                work = false;
            }
        }

    }

    public static void showSubMenu(Map<String, Integer> map, Scanner scanner, int[] array, String str) {
        System.out.println("Выберите необходимый вариант: ");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d. %s\n", i + 1, String.format("%d%s", array[i], "Гб"));
        }
        System.out.print("Вариант: >> ");
        int answer = Integer.parseInt(scanner.nextLine());
        map.put(str, answer - 1);
    }

    public static void showSubMenu(Map<String, Integer> map, Scanner scanner, String[] array, String str) {
        System.out.println("Выберите необходимый вариант: ");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d. %s\n", i + 1, array[i]);
        }
        System.out.print("Вариант: >> ");
        int answer = Integer.parseInt(scanner.nextLine());
        map.put(str, answer - 1);
    }

    public static void showUserFilter(Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder("Значения в фильтре: ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            switch (key) {
                case "memory":
                    sb.append(String.format("%s - %s; ", "ОЗУ", String.format("%d%s", Notebook.memoryVariants[value], "Гб")));
                    break;
                case "hardDisk":
                    sb.append(String.format("%s - %s;", "Объем ЖД", String.format("%d%s", Notebook.hardDiskVariants[value], "Гб")));
                    break;
                case "os":
                    sb.append(String.format("%s - %s; ", "Операционная система", Notebook.osVariants[value]));
                    break;
                case "color":
                    sb.append(String.format("%s - %s; ", "Цвет", Notebook.colors[value]));
                    break;
            }
        }
        System.out.println(sb);
    }

    public static Set<Notebook> generateNotebooks(int qty) {
        Set<Notebook> set = new HashSet<>();
        for (int i = 0; i < qty; i++) {
            set.add(new Notebook());
        }
        return set;
    }

    public static Set<Notebook> findItem(Set<Notebook> notebooks, Map<String, Integer> map, Set<Notebook> findNotebooks) {
        for (Notebook note : notebooks) {
            int count = map.size();
            if (map.containsKey("memory")) {
                if (note.getMemory() == Notebook.memoryVariants[map.get("memory")]) {
                    count--;
                }
            }
            if (map.containsKey("hardDisk")) {
                if (note.getHardDisk() == Notebook.hardDiskVariants[map.get("hardDisk")]) {
                    count--;
                }
            }
            if (map.containsKey("os")) {
                if (note.getOs().equals(Notebook.osVariants[map.get("os")])) {
                    count--;
                }
            }
            if (map.containsKey("color")) {
                if (note.getColor().equals(Notebook.colors[map.get("color")])) {
                    count--;
                }
            }
            if (count == 0) {
                findNotebooks.add(note);
            }
        }
        return findNotebooks;
    }

    public static void printValue(Set<Notebook> notebooks) {
        for (Notebook note : notebooks) {
            System.out.println(note);
        }
    }

}

