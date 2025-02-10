package io.github.nathensample.craftsman.items;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemStore {

    @Autowired
    private Logger logger;
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
        BaseItem goldOre = new BaseItem("Gold Ore", this);
        BaseItem archeumOre = new BaseItem("Archeum Ore", this);
        BaseItem lotus = new BaseItem("Lotus", this);
        BaseItem oats = new BaseItem("Oats", this);
        BaseItem antlerCoral = new BaseItem("Antler Coral", this);
        BaseItem amethyst = new BaseItem("Amethyst");
        BaseItem diamond = new BaseItem("Diamond");
        BaseItem peanut = new BaseItem("Peanut");
        BaseItem wheat = new BaseItem("Wheat");
        BaseItem redCoral = new BaseItem("Red Coral");
        BaseItem starlightArcheumDust = new BaseItem("Starlight Archeum Dust");
        BaseItem starshardChip = new BaseItem("Starshard Chip");
        BaseItem rice = new BaseItem("Rice");
        BaseItem corn = new BaseItem("Corn");
        BaseItem dawnLakeEssence = new BaseItem("Dawn Lake Essence");
        BaseItem flamingLog = new BaseItem("Flaming Log");
        BaseItem mysteriousGardenPowder = new BaseItem("Mysterious Garden Powder");
        BaseItem thunderStruckTree = new BaseItem("Thunderstruck Tree");


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
        CompositeItem strongWheel = new CompositeItem("Strong Wheel", Map.of(archeumLog, 4, sturdyIngot, 1), 2, this);
        CompositeItem tyre = new CompositeItem("Tyre", Map.of(strongWheel, 1, rubber, 20), this);
        CompositeItem goldIngot = new CompositeItem("Gold Ingot", Map.of(goldOre, 3), this);
        CompositeItem alloyCombiner = new CompositeItem("Alloy Combiner", Map.of(ironIngot, 5, goldIngot, 1), this);
        CompositeItem archeumIngot = new CompositeItem("Archeum Ingot", Map.of(archeumOre, 3), this);
        CompositeItem roughPolish =  new CompositeItem("Rough Polish", Map.of(charcoalStabilizer, 5, lotus, 30, oats, 30, antlerCoral, 20), this);
        CompositeItem mechanicalSpring = new CompositeItem("Mechanical Spring", Map.of(ironIngot, 20, copperIngot, 5, archeumIngot, 3, roughPolish, 1), this);
        CompositeItem viscousGlossyOil = new CompositeItem("Viscous Glossy Oil", Map.of(charcoalStabilizer, 5, peanut, 30, wheat, 30, redCoral, 20), this);
        CompositeItem exquisiteDiaphragm = new CompositeItem("Exquisite Diaphragm", Map.of(goldIngot, 5, amethyst, 3, diamond, 2, viscousGlossyOil, 1), this);
        CompositeItem spiralAccelerator = new CompositeItem("Spiral Accelerator", Map.of(exquisiteDiaphragm, 2, mechanicalSpring, 2, alloyCombiner, 20), this);
        CompositeItem starshardIngot = new CompositeItem("Starshard Ingot", Map.of(starshardChip, 3), this);
        CompositeItem seabreezeEssence = new CompositeItem("Seabreeze Essence", Map.of(starshardIngot, 3, starlightArcheumDust, 1), this);
        CompositeItem brightHeadlight = new CompositeItem("Bright Headlight", Map.of(seabreezeEssence, 2, alloyCombiner, 10), this);
        CompositeItem smallSeedOil = new CompositeItem("Small Seed Oil", Map.of(charcoalStabilizer, 3, rice, 20, corn, 20), this);
        CompositeItem hydraulicShift = new CompositeItem("Hydraulic Shift", Map.of(goldIngot, 8, ironIngot, 10,alloyCombiner, 5, dawnLakeEssence, 1, smallSeedOil, 1), this);
        CompositeItem highPowerEngine = new CompositeItem("High Power Engine", Map.of(flamingLog, 5, silverIngot, 10, goldIngot, 10, archeumIngot, 1), this);
        CompositeItem sunridgeIngot = new CompositeItem("Sunridge Ingot", Map.of(sturdyIngot, 10, mysteriousGardenPowder, 5, roughPolish, 1), this);
        CompositeItem solidShaft = new CompositeItem("Solid Shaft", Map.of(thunderStruckTree, 2, sunridgeIngot, 1), this);
        CompositeItem racingChassis = new CompositeItem("Racing Chassis", Map.of(solidShaft, 4, highPowerEngine, 2, hydraulicShift, 10, brightHeadlight, 4, spiralAccelerator, 2), this);


        //CompositeItem x = new CompositeItem("", Map.of(), this);



        CompositeItem rampage = new CompositeItem("rampage test", Map.of(mechanicalSpring, 1, alloyCombiner, 1), this);


        //CompositeItem x = new CompositeItem("", Map.of(), this);
        logger.info("ItemStore initialized. [{}] items in map.", getItemMap().size());
    }

    public Optional<Item> getItem(String name) {
        return Optional.ofNullable(itemMap.get(name.toLowerCase()));
    }

    public void addToItemMap(String itemName, Item item)
    {
        itemMap.put(itemName.toLowerCase(), item);
    }
}
