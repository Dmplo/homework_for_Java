package HomeWork.Lesson_17.Core.Infrastructure.Model;

public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private int drop;

    public Toy(int id, String name, int drop) {
        this.id = id;
        this.name = name;
        this.drop = drop;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDrop() {
        return drop;
    }

    @Override
    public int compareTo(Toy o) {
        return Integer.compare(this.getDrop(), o.getDrop());
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", drop=" + getDrop() +
                '}';
    }

    public void setDrop(int drop) {
        this.drop = drop;
    }
}
