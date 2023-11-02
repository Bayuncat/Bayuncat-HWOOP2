package org.example;

import java.util.List;

public interface MarketBehavior {

    void acceptToMarket(Actor actor);

    void releaseFromMarket(List<Actor> actorList);

    void update();
}
