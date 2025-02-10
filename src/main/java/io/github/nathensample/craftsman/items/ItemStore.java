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
        BaseItem narcissus = new BaseItem("Narcissus", this);                                 //Narcissus
        BaseItem clover = new BaseItem("Clover", this);                                       //Clover
        BaseItem rose = new BaseItem("Rose", this);                                           //Rose
        BaseItem moonlightArcheumEssence = new BaseItem("Moonlight Archeum Essence", this);       //Moonlight Archeum Essence
        BaseItem vehicleUpgradeDevice = new BaseItem("Vehicle Upgrade Device", this);
        BaseItem rampageS200Design = new BaseItem("Rampage S200 Design", this);
        BaseItem naturalRubber = new BaseItem("Natural Rubber", this);
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
        BaseItem dawnLakeLightEssence = new BaseItem("Dawn Lake Light Essence");
        BaseItem flamingLog = new BaseItem("Flaming Log");
        BaseItem mysteriousGardenPowder = new BaseItem("Mysterious Garden Powder");
        BaseItem thunderStruckTree = new BaseItem("Thunderstruck Tree");
        BaseItem lily = new BaseItem("Lily");
        BaseItem lordsCoin = new BaseItem("Lord's Coin");
        BaseItem log = new BaseItem("Log");
        BaseItem wool = new BaseItem("Wool");
        BaseItem cornflower = new BaseItem("Cornflower");
        BaseItem greenCoral = new BaseItem("Green Coral");
        BaseItem pelt = new BaseItem("Pelt");

        //BaseItem x = new BaseItem("y");

        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3, clover, 20, rose, 20), this);
        CompositeItem fabric = new CompositeItem("Fabric", Map.of(wool, 3), this);
        CompositeItem beautifullyColoredFabric = new CompositeItem("Beautifully Colored Fabric", Map.of(fabric, 10, smallRootPigment, 1), this);
        CompositeItem magnificentOceanSash = new CompositeItem("Magnificent Ocean Sash", Map.of(clothManaWisp, 9), this);
        CompositeItem sealedEpheriumSash = new CompositeItem("Sealed Epherium Sash", Map.of(moonlightArcheumEssence, 3, beautifullyColoredFabric, 2), this);
        CompositeItem opaquePolish = new CompositeItem("Opaque Polish", Map.of(charcoalStabilizer, 3, azalea, 20, narcissus, 20), this);
        CompositeItem ironIngot = new CompositeItem("Iron Ingot", Map.of(ironOre, 3), this);
        CompositeItem copperIngot = new CompositeItem("Copper Ingot", Map.of(copperOre, 3), this);
        CompositeItem silverIngot = new CompositeItem("Silver Ingot", Map.of(silverOre, 3), this);
        CompositeItem sturdyIngot = new CompositeItem("Sturdy Ingot", Map.of(ironIngot, 8, copperIngot, 1, silverIngot, 1, opaquePolish, 1), this);
        CompositeItem strongWheel = new CompositeItem("Strong Wheel", Map.of(archeumLog, 4, sturdyIngot, 1), 2, this);
        CompositeItem tyre = new CompositeItem("Tyre", Map.of(strongWheel, 1, naturalRubber, 20), this);
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
        CompositeItem hydraulicShift = new CompositeItem("Hydraulic Shift", Map.of(goldIngot, 8, ironIngot, 10,alloyCombiner, 5, dawnLakeLightEssence, 1, smallSeedOil, 1), this);
        CompositeItem highPowerEngine = new CompositeItem("High Power Engine", Map.of(flamingLog, 5, silverIngot, 10, goldIngot, 10, archeumIngot, 1), this);
        CompositeItem sunridgeIngot = new CompositeItem("Sunridge Ingot", Map.of(sturdyIngot, 10, mysteriousGardenPowder, 5, roughPolish, 1), this);
        CompositeItem solidShaft = new CompositeItem("Solid Shaft", Map.of(thunderStruckTree, 2, sunridgeIngot, 1), this);
        CompositeItem racingChassis = new CompositeItem("Racing Chassis", Map.of(solidShaft, 4, highPowerEngine, 2, hydraulicShift, 10, brightHeadlight, 4, spiralAccelerator, 2), this);
        CompositeItem whitePigment = new CompositeItem("White Pigment", Map.of(lily, 200, dawnLakeLightEssence, 1), this);
        CompositeItem lumber = new CompositeItem("Lumber", Map.of(log, 3), this);
        CompositeItem fineLumber = new CompositeItem("Fine Lumber", Map.of(lumber, 10, smallSeedOil, 1),this);
        CompositeItem nuriForestLumber = new CompositeItem("Nuri Forest Lumber", Map.of(fineLumber, 10, mysteriousGardenPowder, 5, viscousGlossyOil, 1), this);
        CompositeItem smallLeafPigment = new CompositeItem("Small Leaf Pigment", Map.of(cornflower, 30, lily, 30, greenCoral, 20), this);
        CompositeItem cloudspunFabric = new CompositeItem("Cloudspun Fabric", Map.of(beautifullyColoredFabric, 10, mysteriousGardenPowder, 1, smallLeafPigment, 1), this);
        CompositeItem leather = new CompositeItem("Leather", Map.of(pelt,3), this);
        CompositeItem fineLeather = new CompositeItem("Fine Leather", Map.of(leather, 10, smallSeedOil, 1), this);
        CompositeItem windSpiritLeather = new CompositeItem("Wind Spirit Leather", Map.of(fineLeather, 10, mysteriousGardenPowder, 5, viscousGlossyOil, 1), this);
        CompositeItem craftedVehicleFrameRampageS200 = new CompositeItem("Crafted Vehicle Frame: Rampage S200", Map.of(whitePigment, 10, nuriForestLumber, 10, cloudspunFabric, 10, windSpiritLeather, 10, goldIngot, 10), this);
        CompositeItem scrollRampageS200Lite = new CompositeItem("Scroll: Rampage S200 Lite", Map.of(rampageS200Design, 1, craftedVehicleFrameRampageS200, 1, racingChassis, 1, tyre, 4), this);
        CompositeItem scrollRampageS200 = new CompositeItem("Scroll: Rampage S200", Map.of(scrollRampageS200Lite, 1, vehicleUpgradeDevice, 6), this);

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
