package io.github.nathensample.craftsman.items;

import java.util.Map;
import java.util.Objects;

public class BaseItem extends Item {
    private final String name;

    // Used for simplified BaseItem's in testing
    public BaseItem(String name)
    {
        this.name = name;
    }

    public BaseItem(String name, ItemStore itemStore) {
        this.name = name;
        itemStore.addToItemMap(name, this);
    }

    @Override
    public String getName() {
        return this.name;
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
        return getName() + "(BaseItem)";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BaseItem comparison)) {
            return false;
        }
        return comparison.getName().equalsIgnoreCase(this.getName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getName().toLowerCase());
    }
}
