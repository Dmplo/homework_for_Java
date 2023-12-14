package HomeWork.Exception_Lesson_14.Task_1;

//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.
//        Метод arrayOutOfBoundsException - Ошибка, связанная с выходом за пределы массива
//        Метод divisionByZero - Деление на 0
//        Метод numberFormatException - Ошибка преобразования строки в число

public class Main {
    public static void main(String[] args) {
        try {
            Answer.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            Answer.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            Answer.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }

}

class Answer {
    public static void arrayOutOfBoundsException() {
        int[] arr = new int[4];
        int b = arr[10];

    }

    public static void divisionByZero() {
        int a = 5;
        int b = 0;
        int c = a/b;
    }

    public static void numberFormatException() {
        String str = "657567bbvcd";
        int a = Integer.parseInt(str);
    }
}

