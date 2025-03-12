package io.github.nathensample.craftsman.items;

import io.github.nathensample.craftsman.craftingreqs.model.BaseItem;
import io.github.nathensample.craftsman.craftingreqs.model.ItemLookupTable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class BaseItemTest {

    @Mock
    private ItemLookupTable mockItemStore;

    @Test
    public void positiveEqualityTest() {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer"); //Charcoal Stabilizer
        BaseItem otherCharcoalStabilizer = new BaseItem("Charcoal Stabilizer"); //Charcoal Stabilizer
        assertEquals(charcoalStabilizer, otherCharcoalStabilizer);
    }

    @Test
    public void negativeEqualityTestWithBaseItem() {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer"); //Charcoal Stabilizer
        BaseItem bobGeldof = new BaseItem("Bob Geldof"); //Bob Geldof
        assertNotEquals(charcoalStabilizer, bobGeldof);
    }

    @Test
    public void negativeEqualityTestWithRandomObj() {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer"); //Charcoal Stabilizer
        String bobGeldofStr = "Bob Geldof";
        assertNotEquals(charcoalStabilizer, bobGeldofStr);
    }

    @Test
    public void testHashCode() {
        assertEquals(new BaseItem("test"), new BaseItem("test"));
    }

    @Test
    public void testHashCodeWithVariedCasing() {
        assertEquals(new BaseItem("test"), new BaseItem("TeSt"));
    }

}
