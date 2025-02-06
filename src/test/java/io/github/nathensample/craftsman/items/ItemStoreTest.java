package io.github.nathensample.craftsman.items;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class ItemStoreTest {
    private static final Logger logger = LoggerFactory.getLogger(ItemStoreTest.class);
    private final ItemStore itemStore = new ItemStore();

    @BeforeAll
    public void setup()
    {
        itemStore.init();
    }

    @Test
    public void getBasicItem()
    {
        Optional<Item> myItemOpt = itemStore.getItem("azalea");
        assertTrue(myItemOpt.isPresent());
    }
    //TODO: Currently expected to fail since composites have not been converted to new registration method
    @Test
    public void strongWheelHasValidRequirements()
    {
        Optional<Item> myItemOpt = itemStore.getItem("strong wheel");
        assertTrue(myItemOpt.isPresent());
        Item myItem = myItemOpt.get();
        Map<Item, Integer> requirements = myItem.computeRequirements();
        logger.info("test");
    }
}