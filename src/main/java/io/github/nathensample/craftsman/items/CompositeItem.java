package io.github.nathensample.craftsman.items;

import java.util.LinkedHashMap;
import java.util.Map;

public class CompositeItem extends Item {

    private Map<Item, Integer> requirements;
    private String name;

    public CompositeItem(String name, Map<Item, Integer> requirements)
    {
        this.name = name;
        this.requirements = requirements;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<Item, Integer> computeRequirements()
    {
        Map<Item, Integer> returnList = new LinkedHashMap<>();
        for (Map.Entry<Item, Integer> entry : this.getItemRequirements().entrySet())
        {
            Item requiredItem = entry.getKey();

            // If it's a base item, lets add it to the returnlist
            if (requiredItem instanceof BaseItem) {
                //If the requirements already contain this item
                if (returnList.containsKey(requiredItem)) {
                    // Increase the count of how many is required
                    returnList.put(requiredItem, this.getItemRequirements().get(requiredItem) + entry.getValue());
                } else {
                    // Just insert the item as required
                    returnList.put(requiredItem, entry.getValue());
                }
            }
            else if (requiredItem instanceof CompositeItem)
            {
                Map<Item, Integer> requiredForComposite = requiredItem.computeRequirements();
                for (Map.Entry<Item, Integer> subEntry : requiredForComposite.entrySet()) {
                    if (returnList.containsKey(subEntry.getKey())) {
                        // Increase the count of how many is required
                        returnList.put(subEntry.getKey(), this.getItemRequirements().get(subEntry.getKey()) + (subEntry.getValue() * entry.getValue()));
                    } else {
                        // Just insert the item as required
                        returnList.put(subEntry.getKey(), subEntry.getValue() * entry.getValue());
                    }
                }
            }
        }
        return returnList;
    }

    @Override
    public String toString() {
        return name + "(Composite Item) - Requirements: " + requirements;
    }

    public Map<Item, Integer> getItemRequirements() {
        return requirements;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CompositeItem comparison))
        {
            return false;
        }
        if (!comparison.getName().equals(this.getName()))
        {
            return false;
        }
        if (!comparison.getItemRequirements().equals(this.getItemRequirements()))
        {
            return false;
        }

        return true;
    }
}
