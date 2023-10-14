package HomeWork.Lesson_6;

import java.util.*;

class Notebook {
    private int memory;
    private int hardDisk;
    private String os;
    private String color;

    static String[] colors = new String[]{"белый", "черный", "серый", "розовый", "синий"};
    static String[] osVariants = new String[]{"linux", "windows", "пусто"};
    static int[] memoryVariants = new int[]{4, 8, 16, 32, 64};
    static int[] hardDiskVariants = new int[]{128, 256, 512, 1024};

    Random rnd = new Random();

    public Notebook() {
        this.memory = getRndMemory();
        this.hardDisk = getRndHardDisk();
        this.os = getRndOs();
        this.color = getRndColor();
    }

    private String getRndColor() {
        return colors[rnd.nextInt(0, colors.length)];
    }

    private String getRndOs() {
        return osVariants[rnd.nextInt(0, osVariants.length)];
    }

    private int getRndMemory() {
        return memoryVariants[rnd.nextInt(0, memoryVariants.length)];
    }

    private int getRndHardDisk() {
        return hardDiskVariants[rnd.nextInt(0, hardDiskVariants.length)];
    }

    public int getMemory() {
        return memory;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Ноутбук [" +
                "ОЗУ = " + memory + "Гб" +
                ", Объем ЖД = " + hardDisk + "Гб" +
                ", Операционная система = " + os +
                ", Цвет = " + color + ']';
    }
}
