package HomeWork.Lesson_13.Client;

import HomeWork.Lesson_13.Core.View.View;

import java.util.Scanner;

public class ConsoleView implements View {
    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }
    @Override
    public String getInputStr() {
        return scanner.next();
    }
    @Override
    public int getInputInt() {
        return scanner.nextInt();
    }

    @Override
    public void print(String str) {
        System.out.print(str);
    }
    @Override
    public void printErr(String str) {
        System.err.print(str);
    }


}
