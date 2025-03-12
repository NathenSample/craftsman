package io.github.nathensample.craftsman.craftingreqs.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class ItemRequirementTest {

    private Logger logger = LoggerFactory.getLogger(ItemRequirementTest.class);

    private ItemLookupTable itemStore = new ItemLookupTable(mock(Logger.class));

    @Mock
    private ItemLookupTable mockItemStore;

    @Test
    public void testComputeRequirements() {
        //TODO: Replace with test which doesn't use the itemstore
        itemStore.init();
        Optional<Item> myItemOpt = itemStore.getItem("Sealed Epherium Sash");
        assertTrue(myItemOpt.isPresent());
        Item myItem = myItemOpt.get();
        Map<Item, Integer> requirements = myItem.computeRequirements();
        logger.info(myItem.getName() + " " + requirements.toString());
        assertEquals(5, requirements.size());
        //assertTrue(requirements.containsKey());
        //TODO: Key:value checks
    }

    @Test
    public void testRecipeWhichProducesMultiple() {
        //Create a test Ingot which requires 3 ore, to make 2 ingots
        BaseItem testOre = new BaseItem("Test Ore");
        CompositeItem testIngot = new CompositeItem("Test Ingot", Map.of(testOre, 3), 2);

        //Create  a test composite which should require 2 crafts of test Ingot
        CompositeItem testComposite = new CompositeItem("Test Composite", Map.of(testIngot, 4));

        Map<Item, Integer> requirements = testComposite.computeRequirements();
        assertEquals(1, requirements.size());
        assertEquals(Integer.valueOf(6), requirements.get(testOre));
    }

    @Test
    public void testRecipeWhichProducesMultipleAndHasFloatCraftRequirements() {
        //Create a test Ingot which requires 3 ore, to make 2 ingots
        BaseItem testOre = new BaseItem("Test Ore");
        CompositeItem testIngot = new CompositeItem("Test Ingot", Map.of(testOre, 3), 2);

        //Create  a test composite which should require 2.5 crafts of test Ingot
        CompositeItem testComposite = new CompositeItem("Test Composite", Map.of(testIngot, 5));

        Map<Item, Integer> requirements = testComposite.computeRequirements();
        assertEquals(1, requirements.size());
        assertEquals(Integer.valueOf(9), requirements.get(testOre));
    }
}
