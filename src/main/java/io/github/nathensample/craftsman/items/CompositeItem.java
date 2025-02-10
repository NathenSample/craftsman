package io.github.nathensample.craftsman.items;

import io.github.nathensample.craftsman.enums.Proficiency;
import io.github.nathensample.craftsman.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class CompositeItem extends Item {

    private final int craftProduces;
    private final Map<Item, Integer> requirements;
    private final String name;
    private final Proficiency proficiency;
    private final int labourCost;

    // Used for simplified BaseItem's in testing
    CompositeItem(String name, Map<Item, Integer> requirements) {
        this.name = StringUtils.capitalizeWords(name);
        this.requirements = requirements;
        this.craftProduces = 1;
    }

    public CompositeItem(String name, Map<Item, Integer> requirements, ItemStore itemStore) {
        this.name = StringUtils.capitalizeWords(name);
        this.requirements = requirements;
        this.craftProduces = 1;
        itemStore.addToItemMap(name, this);
    }

    public CompositeItem(String name, Map<Item, Integer> requirements, int craftProduces, ItemStore itemStore) {
        this.name = StringUtils.capitalizeWords(name);
        this.requirements = requirements;
        this.craftProduces = craftProduces;
        itemStore.addToItemMap(name, this);
    }

    public Proficiency getProficiency() {
        return proficiency;
    }

    public int getLabourCost() {
        return labourCost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<Item, Integer> computeRequirements() {
        Map<Item, Integer> returnList = new LinkedHashMap<>();
        for (Map.Entry<Item, Integer> craftingRequirement : this.getItemRequirements().entrySet()) {
            Item requiredItem = craftingRequirement.getKey();
            int requiredQuantity = craftingRequirement.getValue();
            // If it's a base item, lets add it to the returnlist
            if (requiredItem instanceof BaseItem) {
                //If the requirements already contain this item
                if (returnList.containsKey(requiredItem)) {
                    // Increase the count of how many is required
                    returnList.put(requiredItem, this.getItemRequirements().get(requiredItem) + craftingRequirement.getValue());
                } else {
                    // Just insert the item as required
                    returnList.put(requiredItem, craftingRequirement.getValue());
                }
            } else if (requiredItem instanceof CompositeItem) {
                Map<Item, Integer> requiredForComposite = requiredItem.computeRequirements();
                for (Map.Entry<Item, Integer> ingredientToQuantity : requiredForComposite.entrySet()) {
                    Item itemToAddToReturnedRequirements = ingredientToQuantity.getKey();
                    Integer quantityOfItemRequired = ingredientToQuantity.getValue();
                    int craftsRequired = (int) Math.ceil((double) requiredQuantity / requiredItem.getCraftProduces());
                    if (returnList.containsKey(ingredientToQuantity.getKey())) {
                        returnList.put(itemToAddToReturnedRequirements, returnList.get(ingredientToQuantity.getKey()) + craftsRequired * quantityOfItemRequired);
                    } else {
                        returnList.put(itemToAddToReturnedRequirements, craftsRequired * quantityOfItemRequired);
                    }
                }
            }
        }
        return returnList;
    }

    @Override
    public String toString() {
        return name + "(Composite Item) - Produces: " + craftProduces + " Requirements: " + requirements;
    }

    public Map<Item, Integer> getItemRequirements() {
        return requirements;
    }

    public int getCraftProduces() {
        return craftProduces;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CompositeItem comparison)) {
            return false;
        }
        if (!comparison.getName().equals(this.getName())) {
            return false;
        }
        return comparison.getItemRequirements().equals(this.getItemRequirements());
    }
}
