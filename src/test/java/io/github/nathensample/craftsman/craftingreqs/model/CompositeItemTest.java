package io.github.nathensample.craftsman.craftingreqs.model;

import io.github.nathensample.craftsman.craftingreqs.model.BaseItem;
import io.github.nathensample.craftsman.craftingreqs.model.CompositeItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class CompositeItemTest {

    @Test
    public void positiveEqualityTest() {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer");
        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3));
        CompositeItem otherSmallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3));
        assertEquals(smallRootPigment, otherSmallRootPigment);
    }

    @Test
    public void negativeDueToQuantityEqualityTest() {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer");
        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3));
        CompositeItem otherSmallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 5));
        assertNotEquals(smallRootPigment, otherSmallRootPigment);
    }

    @Test
    public void negativeDueToDifferingNameEqualityTest() {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer");
        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3));
        CompositeItem otherSmallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 5));
        assertNotEquals(smallRootPigment, otherSmallRootPigment);
    }

    @Test
    public void negativeDueToDifferingIngredientEqualityTest() {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer");
        BaseItem testBaseItem = new BaseItem("Test");

        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3));
        CompositeItem otherSmallRootPigment = new CompositeItem("Small Root Pigment", Map.of(testBaseItem, 3));
        assertNotEquals(smallRootPigment, otherSmallRootPigment);
    }

    @Test
    public void negativeEqualityTestWithRandomObj() {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer");
        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3));
        String bobGeldofStr = "Bob Geldof";
        assertNotEquals(smallRootPigment, bobGeldofStr);
    }
}
