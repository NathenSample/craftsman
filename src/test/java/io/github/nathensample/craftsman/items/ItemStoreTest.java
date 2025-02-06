package io.github.nathensample.craftsman.items;

import io.github.nathensample.craftsman.ItemRequirementTest;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@TestInstance(Lifecycle.PER_CLASS)
public class ItemStoreTest extends TestCase {
    private static final Logger logger = LoggerFactory.getLogger(ItemStoreTest.class);
    private final ItemStore itemStore = new ItemStore();

    @BeforeAll
    public void setup()
    {
        itemStore.init();
    }

    @Test
    public void testStrongWheelHasValidRequirements()
    {
        Optional<Item> myItemOpt = itemStore.getItem("strong wheel");
        logger.info("test");
    }
}