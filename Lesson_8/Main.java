package HomeWork.Lesson_8;

public class Main {
    public static void main(String[] args) {
        Human human = new Human("Peter");
        Human human2 = new Human("John");
        Human human3 = new Human("Will");
        Market market = new Market();
        market.acceptToMarket(human);
        market.acceptToMarket(human2);
        market.acceptToMarket(human3);
        market.update();
    }
}
