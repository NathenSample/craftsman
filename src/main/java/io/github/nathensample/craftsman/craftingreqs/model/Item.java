package io.github.nathensample.craftsman.craftingreqs.model;

import java.util.Map;

public abstract class Item {
    public abstract String getName();

    public abstract Map<Item, Integer> computeRequirements();

    public abstract int getCraftProduces();

}
