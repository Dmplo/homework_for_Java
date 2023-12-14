package HomeWork.Exception_Lesson_14.Task_2;

//Реализуйте метод subArrays, принимающий в качестве аргументов два целочисленных массива a и b, и возвращающий новый массив c,
// каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
//        Если длины массивов не равны - верните нулевой массив длины 1.
//        Напишите свой код в методе subArrays класса Answer. Метод subArrays принимает на вход два параметра:
//        int[] a - первый массив
//        int[] b - второй массив
//        Пример
//        a = new int[]{4, 5, 6};
//        b = new int[]{1, 2, 3};
//        Вывод: [3, 3, 3]
//        a = new int[]{4, 5, 6};
//        b = new int[]{1, 2, 3, 5};
//        Вывод: [0]

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{4, 5, 6, 1};
            b = new int[]{1, 2, 3};
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
            b = Arrays.stream(args[1].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        String itresume_res = Arrays.toString(Answer.subArrays(a, b));
        System.out.println(itresume_res);
    }
}

class Answer {
    public static int[] subArrays(int[] a, int[] b) {
        if (a.length != b.length) return new int[1];
        int[] ints = new int[a.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = a[i] - b[i];
        }
        return ints;
    }
}

