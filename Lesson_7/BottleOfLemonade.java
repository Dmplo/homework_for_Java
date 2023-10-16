package HomeWork.Lesson_7;

public class BottleOfLemonade extends Product{
    private double volume;
    public BottleOfLemonade(String name, double cost, double volume) {
        super(name, cost);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "BottleOfLemonade{" +
                 "name = " + super.getName() +
                ";volume = " + volume +
                ";cost = " + super.getCost() +
                '}';
    }
}
