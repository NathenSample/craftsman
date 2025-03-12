package io.github.nathensample.craftsman.items;

import io.github.nathensample.craftsman.craftingreqs.model.BaseItem;
import io.github.nathensample.craftsman.craftingreqs.model.Item;
import io.github.nathensample.craftsman.craftingreqs.model.ItemLookupTable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class ItemLookupHandlerTest {
    @Autowired
    private Logger logger;

    @Mock
    private Logger mockLogger;

    @InjectMocks
    private ItemLookupTable itemStore;

    @BeforeAll
    public void setup() {
        itemStore = new ItemLookupTable(mock(Logger.class));
        itemStore.init();
    }

    @Test
    public void getBasicItem() {
        Optional<Item> myItemOpt = itemStore.getItem("Azalea");
        assertTrue(myItemOpt.isPresent());
    }

    @Test
    public void strongWheelHasValidRequirements() {
        Optional<Item> myItemOpt = itemStore.getItem("Strong Wheel");
        assertTrue(myItemOpt.isPresent());
        Item myItem = myItemOpt.get();
        Map<Item, Integer> requirements = myItem.computeRequirements();
        assertEquals(7, requirements.size());

        assertTrue(requirements.containsKey(new BaseItem("Archeum Log")));
        assertEquals(4, requirements.get(new BaseItem("Archeum Log")));

        assertTrue(requirements.containsKey(new BaseItem("Copper Ore")));
        assertEquals(3, requirements.get(new BaseItem("Copper Ore")));

        assertTrue(requirements.containsKey(new BaseItem("Silver Ore")));
        assertEquals(3, requirements.get(new BaseItem("Silver Ore")));

        assertTrue(requirements.containsKey(new BaseItem("Azalea")));
        assertEquals(20, requirements.get(new BaseItem("Azalea")));

        assertTrue(requirements.containsKey(new BaseItem("Narcissus")));
        assertEquals(20, requirements.get(new BaseItem("Narcissus")));

        assertTrue(requirements.containsKey(new BaseItem("Charcoal Stabilizer")));
        assertEquals(3, requirements.get(new BaseItem("Charcoal Stabilizer")));

        assertTrue(requirements.containsKey(new BaseItem("Iron Ore")));
        assertEquals(24, requirements.get(new BaseItem("Iron Ore")));
    }
}