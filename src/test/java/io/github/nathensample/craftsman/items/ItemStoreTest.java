package io.github.nathensample.craftsman.items;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ItemStoreTest {
    @Autowired
    private Logger logger;

    @Mock
    private Logger mockLogger;

    @InjectMocks
    private ItemStore itemStore;

    @BeforeAll
    public void setup() {
        itemStore.init();
    }

    @Test
    public void getBasicItem() {
        Optional<Item> myItemOpt = itemStore.getItem("azalea");
        assertTrue(myItemOpt.isPresent());
    }

    @Test
    public void strongWheelHasValidRequirements() {
        Optional<Item> myItemOpt = itemStore.getItem("strong wheel");
        assertTrue(myItemOpt.isPresent());
        Item myItem = myItemOpt.get();
        Map<Item, Integer> requirements = myItem.computeRequirements();
        assertEquals(7, requirements.size());

        assertTrue(requirements.containsKey(new BaseItem("archeum log")));
        assertEquals(4, requirements.get(new BaseItem("archeum log")));

        assertTrue(requirements.containsKey(new BaseItem("copper ore")));
        assertEquals(3, requirements.get(new BaseItem("copper ore")));

        assertTrue(requirements.containsKey(new BaseItem("silver ore")));
        assertEquals(3, requirements.get(new BaseItem("silver ore")));

        assertTrue(requirements.containsKey(new BaseItem("azalea")));
        assertEquals(20, requirements.get(new BaseItem("azalea")));

        assertTrue(requirements.containsKey(new BaseItem("narcissus")));
        assertEquals(20, requirements.get(new BaseItem("narcissus")));

        assertTrue(requirements.containsKey(new BaseItem("charcoal stabilizer")));
        assertEquals(3, requirements.get(new BaseItem("charcoal stabilizer")));

        assertTrue(requirements.containsKey(new BaseItem("iron ore")));
        assertEquals(24, requirements.get(new BaseItem("iron ore")));
    }

    @Test
    public void mechanicalSpringHasValidRequirements() {
//        Optional<Item> myItemOpt = itemStore.getItem("rampage test");
//        assertTrue(myItemOpt.isPresent());
//        Item myItem = myItemOpt.get();
//        Map<Item, Integer> requirements = myItem.computeRequirements();
//        assertEquals(7, requirements.size());
    }

    @Test
    public void rampageHasValidRequirements() {
        Optional<Item> myItemOpt = itemStore.getItem("Scroll: Rampage S200");
        assertTrue(myItemOpt.isPresent());
        Item myItem = myItemOpt.get();
        Map<Item, Integer> requirements = myItem.computeRequirements();
        logger.info(requirements.toString());
        requirements.entrySet().forEach(es ->
        {
            logger.info(es.getKey() + " : " + es.getValue());
        });
    }
}