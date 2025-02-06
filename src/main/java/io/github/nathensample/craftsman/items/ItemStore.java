package io.github.nathensample.craftsman.items;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemStore {
    private Map<String, Item> itemMap = new HashMap<>();

    @PostConstruct
    public void init() {
        BaseItem clothManaWisp = new BaseItem(("Cloth Mana Wisp"));
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer");              //Charcoal Stabilizer
        BaseItem fabric = new BaseItem("Fabric");                                       //Fabric
        BaseItem narcissus = new BaseItem("Narcissus");                                 //Narcissus
        BaseItem clover = new BaseItem("Clover");                                       //Clover
        BaseItem rose = new BaseItem("Rose");                                           //Rose
        BaseItem moonlightArcheumEssence = new BaseItem(("Moonlight Archeum Essence"));       //Moonlight Archeum Essence
        //Latest batch
        BaseItem vehicleUpgradeDevice = new BaseItem("Vehicle Upgrade Device");
        BaseItem rampageS200Design = new BaseItem("Rampage S200 Design");
        BaseItem rubber = new BaseItem("Rubber");
        BaseItem archeumLog = new BaseItem("Archeum Log");
        BaseItem ironOre = new BaseItem("Iron Ore");
        BaseItem silverOre = new BaseItem("Silver Ore");
        BaseItem copperOre = new BaseItem("Copper Ore");
        BaseItem azalea = new BaseItem("Azalea");

        //BaseItem x = new BaseItem("y");


        itemMap.put("cloth mana wisp", clothManaWisp);
        itemMap.put("charcoal stabilizer", charcoalStabilizer);
        itemMap.put("fabric", fabric);
        itemMap.put("narcissus", narcissus);
        itemMap.put("clover", clover);
        itemMap.put("rose", rose);
        itemMap.put("moonlight archeum essence", moonlightArcheumEssence);

        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3, clover, 20, rose, 20));
        CompositeItem beautifullyColoredFabric = new CompositeItem("Beautifully Colored Fabric", Map.of(fabric, 10, smallRootPigment, 1));
        CompositeItem magnificentOceanSash = new CompositeItem("Magnificent Ocean Sash", Map.of(clothManaWisp, 9));
        CompositeItem sealedEpheriumSash = new CompositeItem("Sealed Epherium Sash", Map.of(moonlightArcheumEssence, 3, beautifullyColoredFabric, 2));
        //Latest batch
        CompositeItem opaquePolish = new CompositeItem("Opaque Polish", Map.of(charcoalStabilizer, 3, azalea, 20, narcissus, 20));
        CompositeItem ironIngot = new CompositeItem("Iron Ingot", Map.of(ironOre, 3));
        CompositeItem copperIngot = new CompositeItem("Copper Ingot", Map.of(copperOre, 3));
        CompositeItem silverIngot = new CompositeItem("Silver Ingot", Map.of(silverOre, 3));
        CompositeItem sturdyIngot = new CompositeItem("Sturdy Ingot", Map.of(ironIngot, 8, copperIngot, 1, silverIngot, 1, opaquePolish, 1));
        CompositeItem strongWheel = new CompositeItem("Strong Wheel", Map.of(archeumLog, 4, sturdyIngot, 1));

//        CompositeItem x = new CompositeItem("y", Map.of());

        itemMap.put("small root pigment", smallRootPigment);
        itemMap.put("beautifully colored fabric", beautifullyColoredFabric);
        itemMap.put("magnificent ocean sash", magnificentOceanSash);
        itemMap.put("sealed epherium sash", sealedEpheriumSash);
    }

    public Optional<Item> getItem(String name) {
        return Optional.ofNullable(itemMap.get(name));
    }
}
