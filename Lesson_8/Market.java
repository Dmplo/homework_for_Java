package HomeWork.Lesson_8;

import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour {

    private List<Actor> actorsInQueue;

    public Market() {
        this.actorsInQueue = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.printf("%s %s %s", "Покупатель", actor.getName(), "зашел в магазин\n");
        this.takeInQueue(actor);
    }

    @Override
    public void takeInQueue(Actor actor) {
        this.actorsInQueue.add(actor);
        actor.setMakeOrder(true);
        System.out.printf("%s %s %s", "Покупатель", actor.getName(), "встал в очередь\n");
    }


    @Override
    public void update() {
        this.takeOrders();
        this.giveOrders();
        this.releaseFromQueue();
    }


    @Override
    public void takeOrders() {
        for (Actor actor : this.actorsInQueue) {
            if (!actor.isTakeOrder()) {
                actor.setMakeOrder(true);
                System.out.printf("%s %s %s", "Покупатель", actor.getName(), "сделал заказ\n");
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : this.actorsInQueue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.printf("%s %s %s", "Покупатель", actor.getName(), "получил заказ\n");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> actors = new ArrayList<>();
        for (Actor actor : this.actorsInQueue) {
            if (actor.isTakeOrder()) {
                actors.add(actor);
                System.out.printf("%s %s %s", "Покупатель", actor.getName(), "вышел из очереди\n");
            }
        }
        this.releaseFromMarket(actors);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            this.actorsInQueue.remove(actor);
            System.out.printf("%s %s %s", "Покупатель", actor.getName(), "вышел из магазина\n");

        }
    }
}
