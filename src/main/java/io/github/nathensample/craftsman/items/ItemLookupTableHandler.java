package io.github.nathensample.craftsman.items;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ItemLookupTableHandler {

    @Autowired
    private Logger logger;

    private static final Map<String, Item> ITEM_LOOKUP_TABLE = initializeLookupTable();

    private static Map<String, Item> initializeLookupTable() {
        //Begin BaseItem declaration
        BaseItem clothManaWisp = new BaseItem(("Cloth Mana Wisp"));
        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer");
        BaseItem narcissus = new BaseItem("Narcissus");
        BaseItem clover = new BaseItem("Clover");
        BaseItem rose = new BaseItem("Rose");
        BaseItem moonlightArcheumEssence = new BaseItem("Moonlight Archeum Essence");
        BaseItem vehicleUpgradeDevice = new BaseItem("Vehicle Upgrade Device");
        BaseItem rampageS200Design = new BaseItem("Rampage S200 Design");
        BaseItem naturalRubber = new BaseItem("Natural Rubber");
        BaseItem archeumLog = new BaseItem("Archeum Log");
        BaseItem ironOre = new BaseItem("Iron Ore");
        BaseItem silverOre = new BaseItem("Silver Ore");
        BaseItem copperOre = new BaseItem("Copper Ore");
        BaseItem azalea = new BaseItem("Azalea");
        BaseItem goldOre = new BaseItem("Gold Ore");
        BaseItem archeumOre = new BaseItem("Archeum Ore");
        BaseItem lotus = new BaseItem("Lotus");
        BaseItem oats = new BaseItem("Oats");
        BaseItem antlerCoral = new BaseItem("Antler Coral");
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
        BaseItem woodenManaWisp = new BaseItem("Wooden Mana wisp");
        BaseItem sunlightArcheumEssence = new BaseItem("Sunlight Archeum Essence");
        BaseItem gildaDust = new BaseItem("Gilda Dust");
        BaseItem ayanadWeaponsmithingScroll = new BaseItem("Ayanad Weaponsmithing Scroll");
        //End BaseItem declaration

        //Begin CompositeItem declaration
        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3, clover, 20, rose, 20), Proficiency.ALCHEMY, 15);
        CompositeItem fabric = new CompositeItem("Fabric", Map.of(wool, 3), Proficiency.TAILORING, 5);
        CompositeItem beautifullyColoredFabric = new CompositeItem("Beautifully Colored Fabric", Map.of(fabric, 10, smallRootPigment, 1), Proficiency.TAILORING, 10);
        CompositeItem magnificentOceanSash = new CompositeItem("Magnificent Ocean Sash", Map.of(clothManaWisp, 9), Proficiency.MACHINING, 500);
        CompositeItem sealedEpheriumSash = new CompositeItem("Sealed Epherium Sash", Map.of(moonlightArcheumEssence, 3, beautifullyColoredFabric, 2), Proficiency.MACHINING, 650);
        CompositeItem opaquePolish = new CompositeItem("Opaque Polish", Map.of(charcoalStabilizer, 3, azalea, 20, narcissus, 20), Proficiency.ALCHEMY, 15);
        CompositeItem ironIngot = new CompositeItem("Iron Ingot", Map.of(ironOre, 3), Proficiency.METALWORK, 5);
        CompositeItem copperIngot = new CompositeItem("Copper Ingot", Map.of(copperOre, 3), Proficiency.METALWORK, 5);
        CompositeItem silverIngot = new CompositeItem("Silver Ingot", Map.of(silverOre, 3), Proficiency.METALWORK, 10);
        CompositeItem sturdyIngot = new CompositeItem("Sturdy Ingot", Map.of(ironIngot, 8, copperIngot, 1, silverIngot, 1, opaquePolish, 1), Proficiency.METALWORK, 10);
        CompositeItem strongWheel = new CompositeItem("Strong Wheel", Map.of(archeumLog, 4, sturdyIngot, 1), 2, Proficiency.METALWORK, 10);
        CompositeItem rubberTire = new CompositeItem("Rubber Tire", Map.of(strongWheel, 1, naturalRubber, 20), Proficiency.MACHINING, 50);
        CompositeItem goldIngot = new CompositeItem("Gold Ingot", Map.of(goldOre, 3), Proficiency.METALWORK, 15);
        CompositeItem alloyCombiner = new CompositeItem("Alloy Combiner", Map.of(ironIngot, 5, goldIngot, 1), Proficiency.MACHINING, 5);
        CompositeItem archeumIngot = new CompositeItem("Archeum Ingot", Map.of(archeumOre, 3), Proficiency.METALWORK, 15);
        CompositeItem roughPolish = new CompositeItem("Rough Polish", Map.of(charcoalStabilizer, 5, lotus, 30, oats, 30, antlerCoral, 20), Proficiency.ALCHEMY, 30);
        CompositeItem mechanicalSpring = new CompositeItem("Mechanical Spring", Map.of(ironIngot, 20, copperIngot, 5, archeumIngot, 3, roughPolish, 1), Proficiency.MACHINING, 50);
        CompositeItem viscousGlossyOil = new CompositeItem("Viscous Glossy Oil", Map.of(charcoalStabilizer, 5, peanut, 30, wheat, 30, redCoral, 20), Proficiency.ALCHEMY, 30);
        CompositeItem exquisiteDiaphragm = new CompositeItem("Exquisite Diaphragm", Map.of(goldIngot, 5, amethyst, 3, diamond, 2, viscousGlossyOil, 1), Proficiency.MACHINING, 50);
        CompositeItem spiralAccelerator = new CompositeItem("Spiral Accelerator", Map.of(exquisiteDiaphragm, 2, mechanicalSpring, 2, alloyCombiner, 20), Proficiency.MACHINING, 20);
        CompositeItem starshardIngot = new CompositeItem("Starshard Ingot", Map.of(starshardChip, 3), Proficiency.METALWORK, 15);
        CompositeItem seabreezeEssence = new CompositeItem("Seabreeze Essence", Map.of(starshardIngot, 3, starlightArcheumDust, 1), Proficiency.ALCHEMY, 15);
        CompositeItem brightHeadlight = new CompositeItem("Bright Headlight", Map.of(seabreezeEssence, 2, alloyCombiner, 10), Proficiency.MACHINING, 10);
        CompositeItem smallSeedOil = new CompositeItem("Small Seed Oil", Map.of(charcoalStabilizer, 3, rice, 20, corn, 20), Proficiency.ALCHEMY, 15);
        CompositeItem hydraulicShift = new CompositeItem("Hydraulic Shift", Map.of(goldIngot, 8, ironIngot, 10, alloyCombiner, 5, dawnLakeLightEssence, 1, smallSeedOil, 1), Proficiency.MACHINING, 20);
        CompositeItem highPowerEngine = new CompositeItem("High Power Engine", Map.of(flamingLog, 5, silverIngot, 10, goldIngot, 10, archeumIngot, 1), Proficiency.MACHINING, 10);
        CompositeItem sunridgeIngot = new CompositeItem("Sunridge Ingot", Map.of(sturdyIngot, 10, mysteriousGardenPowder, 5, roughPolish, 1), Proficiency.METALWORK, 20);
        CompositeItem solidShaft = new CompositeItem("Solid Shaft", Map.of(thunderStruckTree, 2, sunridgeIngot, 1), Proficiency.MACHINING, 10);
        CompositeItem racingChassis = new CompositeItem("Racing Chassis", Map.of(solidShaft, 4, highPowerEngine, 2, hydraulicShift, 10, brightHeadlight, 4, spiralAccelerator, 2), Proficiency.MACHINING, 50);
        CompositeItem whitePigment = new CompositeItem("White Pigment", Map.of(lily, 200, dawnLakeLightEssence, 1), Proficiency.ALCHEMY, 25);
        CompositeItem lumber = new CompositeItem("Lumber", Map.of(log, 3), Proficiency.CARPENTRY, 5);
        CompositeItem fineLumber = new CompositeItem("Fine Lumber", Map.of(lumber, 10, smallSeedOil, 1), Proficiency.CARPENTRY, 10);
        CompositeItem nuriForestLumber = new CompositeItem("Nuri Forest Lumber", Map.of(fineLumber, 10, mysteriousGardenPowder, 5, viscousGlossyOil, 1), Proficiency.CARPENTRY, 20);
        CompositeItem smallLeafPigment = new CompositeItem("Small Leaf Pigment", Map.of(cornflower, 30, lily, 30, greenCoral, 20), Proficiency.ALCHEMY, 30);
        CompositeItem cloudspunFabric = new CompositeItem("Cloudspun Fabric", Map.of(beautifullyColoredFabric, 10, mysteriousGardenPowder, 1, smallLeafPigment, 1), Proficiency.TAILORING, 20);
        CompositeItem leather = new CompositeItem("Leather", Map.of(pelt, 3), Proficiency.LEATHERWORK, 5);
        CompositeItem fineLeather = new CompositeItem("Fine Leather", Map.of(leather, 10, smallSeedOil, 1), Proficiency.LEATHERWORK, 10);
        CompositeItem windSpiritLeather = new CompositeItem("Wind Spirit Leather", Map.of(fineLeather, 10, mysteriousGardenPowder, 5, viscousGlossyOil, 1), Proficiency.LEATHERWORK, 20);
        CompositeItem craftedVehicleFrameRampageS200 = new CompositeItem("Crafted Vehicle Frame: Rampage S200", Map.of(whitePigment, 10, nuriForestLumber, 10, cloudspunFabric, 10, windSpiritLeather, 10, goldIngot, 10), Proficiency.HANDICRAFTS, 50);
        CompositeItem scrollRampageS200Lite = new CompositeItem("Scroll: Rampage S200 Lite", Map.of(rampageS200Design, 1, craftedVehicleFrameRampageS200, 1, racingChassis, 1, rubberTire, 4), Proficiency.MACHINING, 25);
        CompositeItem scrollRampageS200 = new CompositeItem("Scroll: Rampage S200", Map.of(scrollRampageS200Lite, 1, vehicleUpgradeDevice, 6), Proficiency.MACHINING, 0);
        CompositeItem magnificentVolcanoBow = new CompositeItem("Magnificent Volcano Bow", Map.of(woodenManaWisp, 6), Proficiency.MACHINING, 500);
        CompositeItem sealedEpheriumBow = new CompositeItem("Sealed Epherium Bow", Map.of(magnificentVolcanoBow, 1, sunlightArcheumEssence, 5, fineLumber, 16, archeumIngot, 8), Proficiency.CARPENTRY, 650);


        //Highly simplified recipes not including previous weapon
        CompositeItem sealedDelphinadBow = new CompositeItem("Sealed Delphinad Bow", Map.of(sunlightArcheumEssence, 7, nuriForestLumber, 5, archeumIngot, 15), Proficiency.CARPENTRY, 800);
        CompositeItem sealedAyanadBow = new CompositeItem("Sealed Ayanad Bow", Map.of(sunlightArcheumEssence, 11, nuriForestLumber, 8, archeumIngot, 31, ayanadWeaponsmithingScroll, 1), Proficiency.CARPENTRY, 800);
        //End CompositeItem declaration

        return Map.ofEntries(
                // BaseItems
                Map.entry("Cloth Mana Wisp", clothManaWisp),
                Map.entry("Charcoal Stabilizer", charcoalStabilizer),
                Map.entry("Narcissus", narcissus),
                Map.entry("Clover", clover),
                Map.entry("Rose", rose),
                Map.entry("Moonlight Archeum Essence", moonlightArcheumEssence),
                Map.entry("Vehicle Upgrade Device", vehicleUpgradeDevice),
                Map.entry("Rampage S200 Design", rampageS200Design),
                Map.entry("Natural Rubber", naturalRubber),
                Map.entry("Archeum Log", archeumLog),
                Map.entry("Iron Ore", ironOre),
                Map.entry("Silver Ore", silverOre),
                Map.entry("Copper Ore", copperOre),
                Map.entry("Azalea", azalea),
                Map.entry("Gold Ore", goldOre),
                Map.entry("Archeum Ore", archeumOre),
                Map.entry("Lotus", lotus),
                Map.entry("Oats", oats),
                Map.entry("Antler Coral", antlerCoral),
                Map.entry("Amethyst", amethyst),
                Map.entry("Diamond", diamond),
                Map.entry("Peanut", peanut),
                Map.entry("Wheat", wheat),
                Map.entry("Red Coral", redCoral),
                Map.entry("Starlight Archeum Dust", starlightArcheumDust),
                Map.entry("Starshard Chip", starshardChip),
                Map.entry("Rice", rice),
                Map.entry("Corn", corn),
                Map.entry("Dawn Lake Light Essence", dawnLakeLightEssence),
                Map.entry("Flaming Log", flamingLog),
                Map.entry("Mysterious Garden Powder", mysteriousGardenPowder),
                Map.entry("Thunderstruck Tree", thunderStruckTree),
                Map.entry("Lily", lily),
                Map.entry("Lord's Coin", lordsCoin),
                Map.entry("Log", log),
                Map.entry("Wool", wool),
                Map.entry("Cornflower", cornflower),
                Map.entry("Green Coral", greenCoral),
                Map.entry("Pelt", pelt),
                Map.entry("Wooden Mana Wisp", woodenManaWisp),
                Map.entry("Sunlight Archeum Essence", sunlightArcheumEssence),
                Map.entry("Gilda Dust", gildaDust),
                Map.entry("Ayanad Weaponsmithing Scroll", ayanadWeaponsmithingScroll),

                // CompositeItems
                Map.entry("Small Root Pigment", smallRootPigment),
                Map.entry("Fabric", fabric),
                Map.entry("Beautifully Colored Fabric", beautifullyColoredFabric),
                Map.entry("Magnificent Ocean Sash", magnificentOceanSash),
                Map.entry("Sealed Epherium Sash", sealedEpheriumSash),
                Map.entry("Opaque Polish", opaquePolish),
                Map.entry("Iron Ingot", ironIngot),
                Map.entry("Copper Ingot", copperIngot),
                Map.entry("Silver Ingot", silverIngot),
                Map.entry("Sturdy Ingot", sturdyIngot),
                Map.entry("Strong Wheel", strongWheel),
                Map.entry("Rubber Tire", rubberTire),
                Map.entry("Gold Ingot", goldIngot),
                Map.entry("Alloy Combiner", alloyCombiner),
                Map.entry("Archeum Ingot", archeumIngot),
                Map.entry("Rough Polish", roughPolish),
                Map.entry("Mechanical Spring", mechanicalSpring),
                Map.entry("Viscous Glossy Oil", viscousGlossyOil),
                Map.entry("Exquisite Diaphragm", exquisiteDiaphragm),
                Map.entry("Spiral Accelerator", spiralAccelerator),
                Map.entry("Starshard Ingot", starshardIngot),
                Map.entry("Seabreeze Essence", seabreezeEssence),
                Map.entry("Bright Headlight", brightHeadlight),
                Map.entry("Small Seed Oil", smallSeedOil),
                Map.entry("Hydraulic Shift", hydraulicShift),
                Map.entry("High Power Engine", highPowerEngine),
                Map.entry("Sunridge Ingot", sunridgeIngot),
                Map.entry("Solid Shaft", solidShaft),
                Map.entry("Racing Chassis", racingChassis),
                Map.entry("White Pigment", whitePigment),
                Map.entry("Lumber", lumber),
                Map.entry("Fine Lumber", fineLumber),
                Map.entry("Nuri Forest Lumber", nuriForestLumber),
                Map.entry("Small Leaf Pigment", smallLeafPigment),
                Map.entry("Cloudspun Fabric", cloudspunFabric),
                Map.entry("Leather", leather),
                Map.entry("Fine Leather", fineLeather),
                Map.entry("Wind Spirit Leather", windSpiritLeather),
                Map.entry("Crafted Vehicle Frame: Rampage S200", craftedVehicleFrameRampageS200),
                Map.entry("Scroll: Rampage S200 Lite", scrollRampageS200Lite),
                Map.entry("Scroll: Rampage S200", scrollRampageS200),
                Map.entry("Magnificent Volcano Bow", magnificentVolcanoBow),
                Map.entry("Sealed Epherium Bow", sealedEpheriumBow),
                Map.entry("Sealed Delphinad Bow", sealedDelphinadBow),
                Map.entry("Sealed Ayanad Bow", sealedAyanadBow)
        );
    }

    @PostConstruct
    public void init() {
        logger.info("ItemStore initialized. [{}] items in map.", ITEM_LOOKUP_TABLE.size());
    }

    public Optional<Item> getItem(String name) {
        return Optional.ofNullable(ITEM_LOOKUP_TABLE.get(name.toLowerCase()));
    }
}
