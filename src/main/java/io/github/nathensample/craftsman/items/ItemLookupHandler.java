package io.github.nathensample.craftsman.items;

import io.github.nathensample.craftsman.enums.Proficiency;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemLookupHandler {

    @Autowired
    private Logger logger;
    Map<String, Item> getItemMap() {
        return itemMap;
    }

    private final Map<String, Item> itemMap = new HashMap<>();

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
        BaseItem amethyst = new BaseItem("Amethyst", this);
        BaseItem diamond = new BaseItem("Diamond", this);
        BaseItem peanut = new BaseItem("Peanut", this);
        BaseItem wheat = new BaseItem("Wheat", this);
        BaseItem redCoral = new BaseItem("Red Coral", this);
        BaseItem starlightArcheumDust = new BaseItem("Starlight Archeum Dust", this);
        BaseItem starshardChip = new BaseItem("Starshard Chip", this);
        BaseItem rice = new BaseItem("Rice", this);
        BaseItem corn = new BaseItem("Corn", this);
        BaseItem dawnLakeLightEssence = new BaseItem("Dawn Lake Light Essence", this);
        BaseItem flamingLog = new BaseItem("Flaming Log", this);
        BaseItem mysteriousGardenPowder = new BaseItem("Mysterious Garden Powder", this);
        BaseItem thunderStruckTree = new BaseItem("Thunderstruck Tree", this);
        BaseItem lily = new BaseItem("Lily", this);
        BaseItem lordsCoin = new BaseItem("Lord's Coin", this);
        BaseItem log = new BaseItem("Log", this);
        BaseItem wool = new BaseItem("Wool", this);
        BaseItem cornflower = new BaseItem("Cornflower", this);
        BaseItem greenCoral = new BaseItem("Green Coral", this);
        BaseItem pelt = new BaseItem("Pelt", this);
        BaseItem woodenManaWisp = new BaseItem("Wooden Mana wisp", this);
        BaseItem sunlightArcheumEssence = new BaseItem("Sunlight Archeum Essence", this);
        BaseItem gildaDust = new BaseItem("Gilda Dust", this);
        BaseItem ayanadWeaponsmithingScroll = new BaseItem("Ayanad Weaponsmithing Scroll", this);



        //BaseItem x = new BaseItem("y");

        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3, clover, 20, rose, 20), this, Proficiency.ALCHEMY, 15);
        CompositeItem fabric = new CompositeItem("Fabric", Map.of(wool, 3), this, Proficiency.TAILORING, 5);
        CompositeItem beautifullyColoredFabric = new CompositeItem("Beautifully Colored Fabric", Map.of(fabric, 10, smallRootPigment, 1), this, Proficiency.TAILORING, 10);
        CompositeItem magnificentOceanSash = new CompositeItem("Magnificent Ocean Sash", Map.of(clothManaWisp, 9), this, Proficiency.MACHINING, 500);
        CompositeItem sealedEpheriumSash = new CompositeItem("Sealed Epherium Sash", Map.of(moonlightArcheumEssence, 3, beautifullyColoredFabric, 2), this, Proficiency.MACHINING, 650);
        CompositeItem opaquePolish = new CompositeItem("Opaque Polish", Map.of(charcoalStabilizer, 3, azalea, 20, narcissus, 20), this, Proficiency.ALCHEMY, 15);
        CompositeItem ironIngot = new CompositeItem("Iron Ingot", Map.of(ironOre, 3), this, Proficiency.METALWORK, 5);
        CompositeItem copperIngot = new CompositeItem("Copper Ingot", Map.of(copperOre, 3), this, Proficiency.METALWORK, 5);
        CompositeItem silverIngot = new CompositeItem("Silver Ingot", Map.of(silverOre, 3), this, Proficiency.METALWORK, 10);
        CompositeItem sturdyIngot = new CompositeItem("Sturdy Ingot", Map.of(ironIngot, 8, copperIngot, 1, silverIngot, 1, opaquePolish, 1), this, Proficiency.METALWORK, 10);
        CompositeItem strongWheel = new CompositeItem("Strong Wheel", Map.of(archeumLog, 4, sturdyIngot, 1), 2, this, Proficiency.METALWORK, 10);
        CompositeItem rubberTire = new CompositeItem("Rubber Tire", Map.of(strongWheel, 1, naturalRubber, 20), this, Proficiency.MACHINING, 50);
        CompositeItem goldIngot = new CompositeItem("Gold Ingot", Map.of(goldOre, 3), this, Proficiency.METALWORK, 15);
        CompositeItem alloyCombiner = new CompositeItem("Alloy Combiner", Map.of(ironIngot, 5, goldIngot, 1), this, Proficiency.MACHINING, 5);
        CompositeItem archeumIngot = new CompositeItem("Archeum Ingot", Map.of(archeumOre, 3), this, Proficiency.METALWORK, 15);
        CompositeItem roughPolish =  new CompositeItem("Rough Polish", Map.of(charcoalStabilizer, 5, lotus, 30, oats, 30, antlerCoral, 20), this, Proficiency.ALCHEMY, 30);
        CompositeItem mechanicalSpring = new CompositeItem("Mechanical Spring", Map.of(ironIngot, 20, copperIngot, 5, archeumIngot, 3, roughPolish, 1), this, Proficiency.MACHINING, 50);
        CompositeItem viscousGlossyOil = new CompositeItem("Viscous Glossy Oil", Map.of(charcoalStabilizer, 5, peanut, 30, wheat, 30, redCoral, 20), this, Proficiency.ALCHEMY, 30);
        CompositeItem exquisiteDiaphragm = new CompositeItem("Exquisite Diaphragm", Map.of(goldIngot, 5, amethyst, 3, diamond, 2, viscousGlossyOil, 1), this, Proficiency.MACHINING, 50);
        CompositeItem spiralAccelerator = new CompositeItem("Spiral Accelerator", Map.of(exquisiteDiaphragm, 2, mechanicalSpring, 2, alloyCombiner, 20), this, Proficiency.MACHINING, 20);
        CompositeItem starshardIngot = new CompositeItem("Starshard Ingot", Map.of(starshardChip, 3), this, Proficiency.METALWORK, 15);
        CompositeItem seabreezeEssence = new CompositeItem("Seabreeze Essence", Map.of(starshardIngot, 3, starlightArcheumDust, 1), this, Proficiency.ALCHEMY, 15);
        CompositeItem brightHeadlight = new CompositeItem("Bright Headlight", Map.of(seabreezeEssence, 2, alloyCombiner, 10), this, Proficiency.MACHINING, 10);
        CompositeItem smallSeedOil = new CompositeItem("Small Seed Oil", Map.of(charcoalStabilizer, 3, rice, 20, corn, 20), this, Proficiency.ALCHEMY, 15);
        CompositeItem hydraulicShift = new CompositeItem("Hydraulic Shift", Map.of(goldIngot, 8, ironIngot, 10,alloyCombiner, 5, dawnLakeLightEssence, 1, smallSeedOil, 1), this, Proficiency.MACHINING, 20);
        CompositeItem highPowerEngine = new CompositeItem("High Power Engine", Map.of(flamingLog, 5, silverIngot, 10, goldIngot, 10, archeumIngot, 1), this, Proficiency.MACHINING, 10);
        CompositeItem sunridgeIngot = new CompositeItem("Sunridge Ingot", Map.of(sturdyIngot, 10, mysteriousGardenPowder, 5, roughPolish, 1), this, Proficiency.METALWORK, 20);
        CompositeItem solidShaft = new CompositeItem("Solid Shaft", Map.of(thunderStruckTree, 2, sunridgeIngot, 1), this, Proficiency.MACHINING, 10);
        CompositeItem racingChassis = new CompositeItem("Racing Chassis", Map.of(solidShaft, 4, highPowerEngine, 2, hydraulicShift, 10, brightHeadlight, 4, spiralAccelerator, 2), this, Proficiency.MACHINING, 50);
        CompositeItem whitePigment = new CompositeItem("White Pigment", Map.of(lily, 200, dawnLakeLightEssence, 1), this, Proficiency.ALCHEMY, 25);
        CompositeItem lumber = new CompositeItem("Lumber", Map.of(log, 3), this, Proficiency.CARPENTRY, 5);
        CompositeItem fineLumber = new CompositeItem("Fine Lumber", Map.of(lumber, 10, smallSeedOil, 1),this, Proficiency.CARPENTRY, 10);
        CompositeItem nuriForestLumber = new CompositeItem("Nuri Forest Lumber", Map.of(fineLumber, 10, mysteriousGardenPowder, 5, viscousGlossyOil, 1), this, Proficiency.CARPENTRY, 20);
        CompositeItem smallLeafPigment = new CompositeItem("Small Leaf Pigment", Map.of(cornflower, 30, lily, 30, greenCoral, 20), this, Proficiency.ALCHEMY, 30);
        CompositeItem cloudspunFabric = new CompositeItem("Cloudspun Fabric", Map.of(beautifullyColoredFabric, 10, mysteriousGardenPowder, 1, smallLeafPigment, 1), this, Proficiency.TAILORING, 20);
        CompositeItem leather = new CompositeItem("Leather", Map.of(pelt,3), this, Proficiency.LEATHERWORK, 5);
        CompositeItem fineLeather = new CompositeItem("Fine Leather", Map.of(leather, 10, smallSeedOil, 1), this, Proficiency.LEATHERWORK, 10);
        CompositeItem windSpiritLeather = new CompositeItem("Wind Spirit Leather", Map.of(fineLeather, 10, mysteriousGardenPowder, 5, viscousGlossyOil, 1), this, Proficiency.LEATHERWORK, 20);
        CompositeItem craftedVehicleFrameRampageS200 = new CompositeItem("Crafted Vehicle Frame: Rampage S200", Map.of(whitePigment, 10, nuriForestLumber, 10, cloudspunFabric, 10, windSpiritLeather, 10, goldIngot, 10), this, Proficiency.HANDICRAFTS, 50);
        CompositeItem scrollRampageS200Lite = new CompositeItem("Scroll: Rampage S200 Lite", Map.of(rampageS200Design, 1, craftedVehicleFrameRampageS200, 1, racingChassis, 1, rubberTire, 4), this, Proficiency.MACHINING, 25);
        CompositeItem scrollRampageS200 = new CompositeItem("Scroll: Rampage S200", Map.of(scrollRampageS200Lite, 1, vehicleUpgradeDevice, 6), this, Proficiency.MACHINING, 0);
        CompositeItem magnificentVolcanoBow = new CompositeItem("Magnificent Volcano Bow", Map.of(woodenManaWisp, 6), this, Proficiency.MACHINING, 500);
        CompositeItem sealedEpheriumBow = new CompositeItem("Sealed Epherium Bow", Map.of(magnificentVolcanoBow, 1, sunlightArcheumEssence, 5, fineLumber, 16, archeumIngot, 8), this, Proficiency.CARPENTRY, 650);

        //Highly simplified recipes not including previous weapon
        CompositeItem sealedDelphinadBow = new CompositeItem("Sealed Delphinad Bow", Map.of(sunlightArcheumEssence, 7, nuriForestLumber, 5, archeumIngot, 15), this, Proficiency.CARPENTRY, 800);
        CompositeItem sealedAyanadBow = new CompositeItem("Sealed Ayanad Bow", Map.of(sunlightArcheumEssence, 11, nuriForestLumber, 8, archeumIngot, 31, ayanadWeaponsmithingScroll, 1), this, Proficiency.CARPENTRY, 800);


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
