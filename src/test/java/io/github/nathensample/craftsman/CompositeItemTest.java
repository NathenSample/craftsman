package io.github.nathensample.craftsman;

import io.github.nathensample.craftsman.items.BaseItem;
import io.github.nathensample.craftsman.items.CompositeItem;
import io.github.nathensample.craftsman.items.ItemStore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class CompositeItemTest {
    @Mock
    private ItemStore mockItemStore;

    @Test
    public void positiveEqualityTest() {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer", mockItemStore);
        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3), mockItemStore);
        CompositeItem otherSmallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3), mockItemStore);
        assertEquals(smallRootPigment, otherSmallRootPigment);
    }

    @Test
    public void negativeDueToQuantityEqualityTest() {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer", mockItemStore);
        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3), mockItemStore);
        CompositeItem otherSmallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 5), mockItemStore);
        assertNotEquals(smallRootPigment, otherSmallRootPigment);
    }

    @Test
    public void negativeDueToDifferingNameEqualityTest() {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer", mockItemStore);
        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3), mockItemStore);
        CompositeItem otherSmallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 5), mockItemStore);
        assertNotEquals(smallRootPigment, otherSmallRootPigment);
    }

    @Test
    public void negativeDueToDifferingIngredientEqualityTest() {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer", mockItemStore);
        BaseItem testBaseItem = new BaseItem("Test", mockItemStore);

        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3), mockItemStore);
        CompositeItem otherSmallRootPigment = new CompositeItem("Small Root Pigment", Map.of(testBaseItem, 3), mockItemStore);
        assertNotEquals(smallRootPigment, otherSmallRootPigment);
    }

    @Test
    public void negativeEqualityTestWithRandomObj() {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer", mockItemStore);
        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3), mockItemStore);
        String bobGeldofStr = "Bob Geldof";
        assertNotEquals(smallRootPigment, bobGeldofStr);
    }
}
