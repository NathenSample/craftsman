package io.github.nathensample.craftsman.items;

import java.util.Map;

public class BaseItem extends Item {
    private String name;

    public BaseItem(String name, ItemStore itemStore) {
        this.name = name;
        itemStore.addToItemMap(name, this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<Item, Integer> computeRequirements() {
        return Map.of(this, 1);
    }

    @Override
    public int getCraftProduces() {
        return 1;
    }

    @Override
    public String toString() {
        return name + "(BaseItem)";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BaseItem comparison)) {
            return false;
        }
        return comparison.getName().equals(this.getName());
    }
}
