package HomeWork.Lesson_17.Client;

import HomeWork.Lesson_17.Core.View;

import java.util.Scanner;

public class ConsoleView implements View {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String str) {
        System.out.println(str);
    }

    @Override
    public String get() {
        System.out.print("--> ");
        return scanner.nextLine();
    }
}
