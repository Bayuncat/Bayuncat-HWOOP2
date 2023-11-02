package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Market implements MarketBehavior, QueueBehavior{

    private List<Actor> queue = new ArrayList<>();;
    private List<Actor> releasefromqueue = new ArrayList<>();

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + "ѕришел в магазин");
        takeInQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> releasefromqueue) {
        queue.remove(releasefromqueue);
        System.out.println("ѕокинули магазин довольные: ");
        queue.forEach((s) -> System.out.println(s.getName()));
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }

    @Override
    public void takeInQueue(Actor actor) {
        queue.add(actor);
        System.out.println(actor.getName() + " встал в очередь");
    }

    @Override
    public void takeOrders() {

        for (Iterator<Actor> i = queue.iterator(); i.hasNext();) {
            Actor item = i.next();
            if (!item.isMakeOrder()) {
                item.setMakeOrder(true);

            }
        }
    }

    @Override
    public void giveOrders() {
        for (Iterator<Actor> i = queue.iterator(); i.hasNext();) {
            Actor item = i.next();
            if (item.isMakeOrder()) {
                item.setTakeOrder(true);
                System.out.println(item.getName() + " сделал заказ");;
            }
        }
    }

    @Override
    public void releaseFromQueue() {

        for (Iterator<Actor> i = queue.iterator(); i.hasNext();) {
            Actor item = i.next();
            if (item.isTakeOrder()) {
                releasefromqueue.add(item);
                System.out.println(item.getName() + " вышел из очереди");
            }
            releaseFromMarket(releasefromqueue);
        }
    }
}
