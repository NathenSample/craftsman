package io.github.nathensample.craftsman.items;

import io.github.nathensample.craftsman.util.StringUtils;

import java.util.Map;
import java.util.Objects;

public class BaseItem extends Item {
    private final String name;

    public BaseItem(String name) {
        this.name = StringUtils.capitalizeWords(name);
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
        return getName();
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
