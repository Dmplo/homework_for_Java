package HomeWork.Lesson_7;

public class HotChocolate extends BottleOfLemonade {

    private int temperature;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public HotChocolate(String name, double cost, double volume, int temperature) {
        super(name, cost, volume);
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return String.format("HotChocolate [name: %s, cost: %.1f, volume: %.1f, temperature: %d]", super.getName(), super.getCost(), super.getVolume(), temperature);
    }
}
