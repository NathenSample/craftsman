package io.github.nathensample.craftsman;

import io.github.nathensample.craftsman.items.BaseItem;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class BaseItemTest {

    @Test
    public void positiveEqualityTest()
    {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer"); //Charcoal Stabilizer
        BaseItem otherCharcoalStabilizer = new BaseItem("Charcoal Stabilizer"); //Charcoal Stabilizer
        assertEquals(charcoalStabilizer, otherCharcoalStabilizer);
    }

    @Test
    public void negativeEqualityTestWithBaseItem()
    {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer"); //Charcoal Stabilizer
        BaseItem bobGeldof = new BaseItem("Bob Geldof"); //Bob Geldof
        assertEquals(charcoalStabilizer, bobGeldof);
    }

    @Test
    public void negativeEqualityTestWithRandomObj()
    {
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer"); //Charcoal Stabilizer
        String bobGeldofStr = "Bob Geldof";
        assertNotEquals(charcoalStabilizer, bobGeldofStr);
    }

}
