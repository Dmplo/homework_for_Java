package HomeWork.Exception_Lesson_16.Task_1.Client;

import HomeWork.Exception_Lesson_16.Task_1.Core.View;

import java.util.Scanner;

public class ConsoleView implements View {
    Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public String get() {
        System.out.print("Ввод --> ");
        return scanner.nextLine();
    }

    public void print(String str) {
        System.out.println(str);
    }
}
