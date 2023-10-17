package HomeWork.Lesson_8;

public interface QueueBehaviour {
    void takeInQueue(Actor actor);
    void takeOrders();
    void giveOrders();
    void releaseFromQueue();
}
