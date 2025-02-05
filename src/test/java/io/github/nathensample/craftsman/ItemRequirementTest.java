package io.github.nathensample.craftsman;

import io.github.nathensample.craftsman.items.Item;
import io.github.nathensample.craftsman.items.ItemStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ItemRequirementTest {
    private static final Logger logger = LoggerFactory.getLogger(ItemRequirementTest.class);
    @InjectMocks
    private ItemStore itemStore;

    @Test
    public void testComputeRequirements() {
        itemStore.init();
        Optional<Item> myItemOpt = itemStore.getItem("sealed epherium sash");
        assertTrue(myItemOpt.isPresent());
        Item myItem = myItemOpt.get();
        Map<Item, Integer> requirements = myItem.computeRequirements();
        assertEquals(5, requirements.size());
        //assertTrue(requirements.containsKey());
        //TODO: Key:value checks
    }
}
