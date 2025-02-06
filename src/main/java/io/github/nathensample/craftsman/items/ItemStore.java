package io.github.nathensample.craftsman.items;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemStore {
    Map<String, Item> getItemMap() {
        return itemMap;
    }

    private Map<String, Item> itemMap = new HashMap<>();

    @PostConstruct
    public void init() {
        BaseItem clothManaWisp = new BaseItem(("Cloth Mana Wisp"), this);
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer", this);              //Charcoal Stabilizer
        BaseItem fabric = new BaseItem("Fabric", this);                                       //Fabric
        BaseItem narcissus = new BaseItem("Narcissus", this);                                 //Narcissus
        BaseItem clover = new BaseItem("Clover", this);                                       //Clover
        BaseItem rose = new BaseItem("Rose", this);                                           //Rose
        BaseItem moonlightArcheumEssence = new BaseItem("Moonlight Archeum Essence", this);       //Moonlight Archeum Essence
        BaseItem vehicleUpgradeDevice = new BaseItem("Vehicle Upgrade Device", this);
        BaseItem rampageS200Design = new BaseItem("Rampage S200 Design", this);
        BaseItem rubber = new BaseItem("Rubber", this);
        BaseItem archeumLog = new BaseItem("Archeum Log", this);
        BaseItem ironOre = new BaseItem("Iron Ore", this);
        BaseItem silverOre = new BaseItem("Silver Ore", this);
        BaseItem copperOre = new BaseItem("Copper Ore", this);
        BaseItem azalea = new BaseItem("Azalea", this);

        //BaseItem x = new BaseItem("y");

        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3, clover, 20, rose, 20), this);
        CompositeItem beautifullyColoredFabric = new CompositeItem("Beautifully Colored Fabric", Map.of(fabric, 10, smallRootPigment, 1), this);
        CompositeItem magnificentOceanSash = new CompositeItem("Magnificent Ocean Sash", Map.of(clothManaWisp, 9), this);
        CompositeItem sealedEpheriumSash = new CompositeItem("Sealed Epherium Sash", Map.of(moonlightArcheumEssence, 3, beautifullyColoredFabric, 2), this);
        CompositeItem opaquePolish = new CompositeItem("Opaque Polish", Map.of(charcoalStabilizer, 3, azalea, 20, narcissus, 20), this);
        CompositeItem ironIngot = new CompositeItem("Iron Ingot", Map.of(ironOre, 3), this);
        CompositeItem copperIngot = new CompositeItem("Copper Ingot", Map.of(copperOre, 3), this);
        CompositeItem silverIngot = new CompositeItem("Silver Ingot", Map.of(silverOre, 3), this);
        CompositeItem sturdyIngot = new CompositeItem("Sturdy Ingot", Map.of(ironIngot, 8, copperIngot, 1, silverIngot, 1, opaquePolish, 1), this);
        CompositeItem strongWheel = new CompositeItem("Strong Wheel", Map.of(archeumLog, 4, sturdyIngot, 1), this);

        //CompositeItem x = new CompositeItem("", Map.of(), this);
    }

    public Optional<Item> getItem(String name) {
        return Optional.ofNullable(itemMap.get(name.toLowerCase()));
    }

    public void addToItemMap(String itemName, Item item)
    {
        itemMap.put(itemName.toLowerCase(), item);
    }
}
