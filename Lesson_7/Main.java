package HomeWork.Lesson_7;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HotChocolate hc1 = new HotChocolate("1", 1, 1, 1);
        HotChocolate hc2 = new HotChocolate("2", 2, 2, 2);
        HotChocolate hc3 = new HotChocolate("3", 3, 3, 3);
        HotChocolate hc4 = new HotChocolate("4", 4, 4, 4);
        HotChocolateVendingMachine vendingMachine = new HotChocolateVendingMachine(new ArrayList<>());
        vendingMachine.addHotChocolate(hc1);
        vendingMachine.addHotChocolate(hc2);
        vendingMachine.addHotChocolate(hc3);
        vendingMachine.addHotChocolate(hc4);

        System.out.println(vendingMachine.getProduct("1", 1, 1));
        System.out.println(vendingMachine.getProduct("1", 5, 1));
    }

}