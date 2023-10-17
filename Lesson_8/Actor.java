package HomeWork.Lesson_8;

public abstract class Actor implements ActorBehaviour {
    protected String name;
    protected boolean isMakeOrder;
    protected boolean isTakeOrder;



    public Actor(String name, boolean b, boolean b1) {
        this.name = name;
        this.isMakeOrder = b;
        this.isTakeOrder = b1;
    }

    abstract String getName();

}
