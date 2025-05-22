package io.github.nathensample.craftsman.craftingreqs.model;

import jakarta.annotation.PostConstruct;
import org.checkerframework.checker.units.qual.C;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ItemLookupTable {

    //TODO:
    // Long term we likely need to use something like a multimap, since there's multiple crafts for the same item,
    // but for now we'll just not include alternative recipes, this would also hugely change the recursion logic
    private static final Map<String, Item> ITEM_LOOKUP_TABLE = initializeLookupTable();
    @Autowired
    private Logger logger;

    ItemLookupTable(Logger logger) {
        this.logger = logger;
    }

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
        BaseItem speedboatUpgradeTicket = new BaseItem("Speedboat Upgrade Ticket");
        BaseItem seawhipSpeedboatDesign = new BaseItem("Seawhip Speedboat Design");
        BaseItem veiledFlame = new BaseItem("Veiled Flame");
        BaseItem medicinalPowder = new BaseItem("Medicinal Powder");
        BaseItem lavender = new BaseItem("Lavender");
        BaseItem farmFreighterUpgradeTicket = new BaseItem("Farm Freighter Upgrade Ticket");
        BaseItem wagonUpgradeTicket = new BaseItem("Wagon Upgrade Ticket");
        BaseItem farmWagonDesign = new BaseItem("Farm Wagon Design");
        BaseItem royalJelly = new BaseItem("Royal Jelly");
        BaseItem honey = new BaseItem("Honey");
        BaseItem glowingPrism = new BaseItem("Glowing Prism");
        BaseItem ruby = new BaseItem("Ruby");
        BaseItem flamingPinion = new BaseItem("Flaming Pinion");
        BaseItem lunarite = new BaseItem("Lunarite");
        BaseItem dragonEssenceStabilizer = new BaseItem("Dragon Essence Stabilizer");
        BaseItem seabreezeTradePackStorageDesign = new BaseItem("Seabreeze Trade Pack Storage Design");
        BaseItem mistralTradePackStorageDesign = new BaseItem("Mistral Trade Pack Storage Design");
        BaseItem seastormTradePackStorageDesign = new BaseItem("Seastorm Trade Pack Storage Design");
        BaseItem typhoonTradePackStorageDesign = new BaseItem("Typhoon Trade Pack Storage Design");

        BaseItem caernordSeabreezeRudderDesign = new BaseItem("Caernord Seabreeze Rudder Design");
        BaseItem caernordMistralRudderDesign = new BaseItem("Caernord Mistral Rudder Design");
        BaseItem caernordSeastormRudderDesign = new BaseItem("Caernord Seastorm Rudder Design");
        BaseItem caernordTyphoonRudderDesign = new BaseItem("Caernord Typhoon Rudder Design");

        BaseItem seabreezeShroudlightDesign = new BaseItem("Seabreeze Shroudlight Design");
        BaseItem mistralShroudlightDesign = new BaseItem("Mistral Shroudlight Design");
        BaseItem seastormShroudlightDesign = new BaseItem("Seastorm Shroudlight Design");
        BaseItem typhoonShroudlightDesign = new BaseItem("Typhoon Shroudlight Design");



        BaseItem cursedArmorScrap = new BaseItem("Cursed Armor Scrap");
        BaseItem acidGobbet = new BaseItem("Acid Gobbet");
        BaseItem bookOfAuroria = new BaseItem("Book of Auroria");
        BaseItem quinoa = new BaseItem("Quinoa");
        BaseItem cultivatedGinseng = new BaseItem("Cultivated Ginseng");
        BaseItem sparklingShellDust = new BaseItem("Sparkling Shell Dust");
        BaseItem coconut = new BaseItem("Coconut");

        BaseItem oneHanderMetalManaWisp = new BaseItem("One-Hander Metal Mana Wisp");
        BaseItem shadowOrb = new BaseItem("Shadow Orb");
        BaseItem wrathsmiteArmorShard = new BaseItem("Wrathsmite Armor Shard");
        BaseItem ironArmorFragment = new BaseItem("Iron Armor Fragment");

        BaseItem anthalonsCrimsonHallow = new BaseItem("Anthalon's Crimson Hallow");
        BaseItem hanuresHorn = new BaseItem("Hanure's Horn");
        BaseItem kaylinsQuill = new BaseItem("Kaylin's Quill");
        BaseItem anyaPebble = new BaseItem("Anya Pebble");

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
        CompositeItem hydraulicShaft = new CompositeItem("Hydraulic Shaft", Map.of(goldIngot, 8, ironIngot, 10, alloyCombiner, 5, dawnLakeLightEssence, 1, smallSeedOil, 1), Proficiency.MACHINING, 20);
        CompositeItem highPowerEngine = new CompositeItem("High Power Engine", Map.of(flamingLog, 5, silverIngot, 10, goldIngot, 10, archeumIngot, 1), Proficiency.MACHINING, 10);
        CompositeItem sunridgeIngot = new CompositeItem("Sunridge Ingot", Map.of(sturdyIngot, 10, mysteriousGardenPowder, 5, roughPolish, 1), Proficiency.METALWORK, 20);
        CompositeItem solidShaft = new CompositeItem("Solid Shaft", Map.of(thunderStruckTree, 2, sunridgeIngot, 1), Proficiency.MACHINING, 10);
        CompositeItem racingChassis = new CompositeItem("Racing Chassis", Map.of(solidShaft, 4, highPowerEngine, 2, hydraulicShaft, 10, brightHeadlight, 4, spiralAccelerator, 2), Proficiency.MACHINING, 50);
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
        CompositeItem hushedStar = new CompositeItem("Hushed Star", Map.of(veiledFlame, 10, medicinalPowder, 8, lavender, 20), 10, Proficiency.ALCHEMY, 0); //TODO: Add correct labour cost

        //Highly simplified recipes not including previous weapon
        CompositeItem sealedDelphinadBow = new CompositeItem("Sealed Delphinad Bow", Map.of(sealedEpheriumBow, 7, sunlightArcheumEssence, 7, nuriForestLumber, 5, archeumIngot, 15), Proficiency.CARPENTRY, 800);
        CompositeItem sealedAyanadBow = new CompositeItem("Sealed Ayanad Bow", Map.of(sealedDelphinadBow, 7, sunlightArcheumEssence, 11, nuriForestLumber, 8, archeumIngot, 31, ayanadWeaponsmithingScroll, 1), Proficiency.CARPENTRY, 800);
        //End highly simplfied recipes

        CompositeItem scrollSeawhipSpeedboat = new CompositeItem("Scroll: Seawhip Speedboat", Map.of(seawhipSpeedboatDesign, 1, hydraulicShaft, 4, highPowerEngine, 1, spiralAccelerator, 2, sturdyIngot, 10, fineLumber, 20), Proficiency.CARPENTRY, 25);
        CompositeItem scrollSeaskimmerSpeedboat = new CompositeItem("Scroll: Seaskimmer Speedboat", Map.of(scrollSeawhipSpeedboat, 1, speedboatUpgradeTicket, 1), Proficiency.CARPENTRY, 0);
        //End CompositeItem declaration

        CompositeItem cartBucket = new CompositeItem("Cart Bucket", Map.of(copperIngot, 2, leather, 2), Proficiency.UNCATEGORIZED, 0);
        CompositeItem scrollFarmWagon = new CompositeItem("Scroll: Farm Wagon", Map.of(farmWagonDesign, 1, strongWheel, 4, solidShaft, 1, highPowerEngine, 1, cartBucket, 1), Proficiency.MACHINING, 25);
        CompositeItem scrollFarmHauler = new CompositeItem("Scroll: Farm Hauler", Map.of(scrollFarmWagon, 1, wagonUpgradeTicket, 1), Proficiency.UNCATEGORIZED, 0);
        CompositeItem scrollFarmFreighter = new CompositeItem("Scroll: Farm Freighter", Map.of(scrollFarmHauler, 1, farmFreighterUpgradeTicket, 1), Proficiency.UNCATEGORIZED, 0);
        CompositeItem waxNugget = new CompositeItem("Wax Nugget", Map.of(royalJelly, 2, honey, 5), Proficiency.ALCHEMY, 10);
        CompositeItem armoredFrame = new CompositeItem("Armored Frame", Map.of(copperIngot, 300, lumber, 200, waxNugget, 2),Proficiency.CARPENTRY, 20);
        CompositeItem fineLunarite = new CompositeItem("Fine Lunarite", Map.of(lunarite, 5), Proficiency.ALCHEMY, 1);
        CompositeItem superiorLunarite = new CompositeItem("Superior Lunarite", Map.of(fineLunarite, 3), Proficiency.ALCHEMY, 1);
        CompositeItem primeLunarite = new CompositeItem("Prime Lunarite", Map.of(superiorLunarite, 3), Proficiency.ALCHEMY, 1);
        CompositeItem infernoEngine = new CompositeItem("Inferno Engine", Map.of(glowingPrism, 100, sunridgeIngot, 1, ruby, 20, superiorLunarite, 20, flamingPinion, 100), Proficiency.MACHINING, 20);
        CompositeItem animaExtractionContraption = new CompositeItem("Anima Extraction Contraption", Map.of(armoredFrame, 1, mechanicalSpring, 4, infernoEngine, 1), Proficiency.CARPENTRY, 20);

        CompositeItem zephyrTradePackStorage = new CompositeItem("Zephyr Trade Pack Storage", Map.of(lumber, 18, ironIngot, 8, starshardIngot, 3, charcoalStabilizer, 12), Proficiency.MACHINING, 25);
        CompositeItem seabreezeTradePackStorage = new CompositeItem("Seabreeze Trade Pack Storage", Map.of(zephyrTradePackStorage, 1, lumber, 16, ironIngot, 32, starshardIngot, 1, charcoalStabilizer, 2, seabreezeTradePackStorageDesign, 1), Proficiency.MACHINING, 50);
        CompositeItem mistralTradePackStorage = new CompositeItem("Mistral Trade Pack Storage", Map.of(seabreezeTradePackStorage, 1, fineLumber, 2, starshardIngot, 2, charcoalStabilizer, 4, mistralTradePackStorageDesign, 1), Proficiency.MACHINING, 75);
        CompositeItem seastormTradePackStorage = new CompositeItem("Seastorm Trade Pack Storage", Map.of(mistralTradePackStorage, 1, fineLumber, 4, starshardIngot, 3, charcoalStabilizer, 6, seastormTradePackStorageDesign, 1), Proficiency.MACHINING, 100);
        CompositeItem typhoonTradePackStorage = new CompositeItem("Typhoon Trade Pack Storage", Map.of(seastormTradePackStorage, 1, nuriForestLumber, 1, starshardIngot, 4, charcoalStabilizer, 8, dragonEssenceStabilizer, 1, typhoonTradePackStorageDesign, 1), Proficiency.MACHINING, 125);

        CompositeItem caernordZephyrRudder = new CompositeItem("Caernord Zephyr Rudder", Map.of(lumber, 8, ironIngot, 5, starshardIngot, 3, charcoalStabilizer, 12), Proficiency.MACHINING, 25);
        CompositeItem caernordSeabreezeRudder = new CompositeItem("Caernord Seabreeze Rudder", Map.of(caernordZephyrRudder, 1, lumber, 16, ironIngot, 10, starshardIngot, 3, charcoalStabilizer, 12, caernordSeabreezeRudderDesign, 1), Proficiency.MACHINING, 50);
        CompositeItem caernordMistralRudder = new CompositeItem("Caernord Mistral Rudder", Map.of(caernordSeabreezeRudder, 1, fineLumber, 15, sturdyIngot, 10, starshardIngot, 5, charcoalStabilizer, 27, caernordMistralRudderDesign, 1), Proficiency.MACHINING, 75);
        CompositeItem caernordSeastormRudder = new CompositeItem("Caernord Seastorm Rudder", Map.of(caernordMistralRudder, 1, nuriForestLumber, 2, sunridgeIngot, 2, starshardIngot, 7, charcoalStabilizer, 45, caernordSeastormRudderDesign, 1), Proficiency.MACHINING, 100);
        CompositeItem caernordTypoonRudder = new CompositeItem("Caernord Typhoon Rudder", Map.of(caernordSeastormRudder, 1, nuriForestLumber, 6, sunridgeIngot, 5, starshardIngot, 9, charcoalStabilizer, 54, dragonEssenceStabilizer, 24, caernordTyphoonRudderDesign, 1), Proficiency.MACHINING, 125);


        CompositeItem zephyrLamp = new CompositeItem("Zephyr Lamp", Map.of(lumber, 5, ironIngot, 8, starshardIngot, 5, charcoalStabilizer, 12), Proficiency.MACHINING, 25);
        CompositeItem seabreezeShroudlight = new CompositeItem("Seabreeze Shroudlight", Map.of(nuriForestLumber, 2, sunridgeIngot, 2, starshardIngot, 12, charcoalStabilizer, 24, seabreezeShroudlightDesign, 1), Proficiency.MACHINING, 50);
        CompositeItem mistralShroudlight = new CompositeItem("Mistral Shroudlight", Map.of(seabreezeShroudlight, 1, nuriForestLumber, 8, sunridgeIngot, 8, starshardIngot, 24, charcoalStabilizer, 84, mistralShroudlightDesign, 1), Proficiency.MACHINING, 75);
        CompositeItem seastormShroudlight = new CompositeItem("Seastorm Shroudlight", Map.of(mistralShroudlight, 1, nuriForestLumber, 18, sunridgeIngot, 24, starshardIngot, 48, charcoalStabilizer, 252, seastormShroudlightDesign, 1), Proficiency.MACHINING, 100);
        CompositeItem typhoonShroudlight = new CompositeItem("Typhoon Shroudlight", Map.of(seastormShroudlight, 1, nuriForestLumber, 36, sunridgeIngot, 48, starshardIngot, 92, charcoalStabilizer, 324, dragonEssenceStabilizer, 72, typhoonShroudlightDesign, 1), Proficiency.MACHINING, 125);

        CompositeItem ipnyshLunastoneBlessing = new CompositeItem("Ipnysh Lunastone Blessing", Map.of(cursedArmorScrap, 100, acidGobbet, 100, dragonEssenceStabilizer, 20),Proficiency.UNCATEGORIZED, 500);
        CompositeItem deeplyColoredOil = new CompositeItem("Deeply Colored Oil", Map.of(dragonEssenceStabilizer, 3, quinoa, 50, cultivatedGinseng, 50, sparklingShellDust, 10, coconut, 10), Proficiency.ALCHEMY, 60);
        CompositeItem erenorGaleLunafrost = new CompositeItem("Erenor Gale Lunafrost", Map.of(ipnyshLunastoneBlessing, 1, bookOfAuroria, 15, primeLunarite, 12, deeplyColoredOil, 5, diamond, 9), Proficiency.ALCHEMY, 300);

        CompositeItem brimstoneSunlightSeal = new CompositeItem("Brimstone Sunlight Seal", Map.of(sunridgeIngot, 2, nuriForestLumber, 2, sunlightArcheumEssence, 25), Proficiency.ALCHEMY, 100);
        //TODO: This is wrong it uses a seal which is transmute

        CompositeItem anyaIngot = new CompositeItem("Anya Ingot", Map.of(anyaPebble, 3), Proficiency.METALWORK, 50);
        CompositeItem blazingSunridgeIngot = new CompositeItem("Blazing Sunridge Ingot", Map.of(sunridgeIngot, 10, anyaIngot, 9, lordsCoin, 18, flamingLog, 6), Proficiency.METALWORK, 100);

        CompositeItem cloakedBrimstoneShortspearCraft = new CompositeItem("Cloaked Brimstone Shortspear(craft)", Map.of(brimstoneSunlightSeal, 1, oneHanderMetalManaWisp, 315, shadowOrb, 121, wrathsmiteArmorShard, 30, ironArmorFragment, 12, sunridgeIngot, 12), Proficiency.UNCATEGORIZED, 1250);
        CompositeItem cloakedBrimstoneShortspearTransmute = new CompositeItem("Cloaked Brimstone Shortspear(transmute)", Map.of(brimstoneSunlightSeal, 1, oneHanderMetalManaWisp, 100, anthalonsCrimsonHallow, 1, hanuresHorn, 1, kaylinsQuill, 1, blazingSunridgeIngot, 6), Proficiency.UNCATEGORIZED, 10);

        return Map.ofEntries(
                // BaseItems
                Map.entry("quinoa", quinoa),
                Map.entry("cultivated ginseng", cultivatedGinseng),
                Map.entry("sparkling shell dust", sparklingShellDust),
                Map.entry("coconut", coconut),
                Map.entry("book of auroria", bookOfAuroria),
                Map.entry("cursed armor scrap", cursedArmorScrap),
                Map.entry("acid gobbet", acidGobbet),
                Map.entry("cloth mana wisp", clothManaWisp),
                Map.entry("charcoal stabilizer", charcoalStabilizer),
                Map.entry("narcissus", narcissus),
                Map.entry("clover", clover),
                Map.entry("rose", rose),
                Map.entry("moonlight archeum essence", moonlightArcheumEssence),
                Map.entry("vehicle upgrade device", vehicleUpgradeDevice),
                Map.entry("rampage s200 design", rampageS200Design),
                Map.entry("natural rubber", naturalRubber),
                Map.entry("archeum log", archeumLog),
                Map.entry("iron ore", ironOre),
                Map.entry("silver ore", silverOre),
                Map.entry("copper ore", copperOre),
                Map.entry("azalea", azalea),
                Map.entry("gold ore", goldOre),
                Map.entry("archeum ore", archeumOre),
                Map.entry("lotus", lotus),
                Map.entry("oats", oats),
                Map.entry("antler coral", antlerCoral),
                Map.entry("amethyst", amethyst),
                Map.entry("diamond", diamond),
                Map.entry("peanut", peanut),
                Map.entry("wheat", wheat),
                Map.entry("red coral", redCoral),
                Map.entry("starlight archeum dust", starlightArcheumDust),
                Map.entry("starshard chip", starshardChip),
                Map.entry("rice", rice),
                Map.entry("corn", corn),
                Map.entry("dawn lake light essence", dawnLakeLightEssence),
                Map.entry("flaming log", flamingLog),
                Map.entry("mysterious garden powder", mysteriousGardenPowder),
                Map.entry("thunderstruck tree", thunderStruckTree),
                Map.entry("lily", lily),
                Map.entry("lord's coin", lordsCoin),
                Map.entry("log", log),
                Map.entry("wool", wool),
                Map.entry("cornflower", cornflower),
                Map.entry("green coral", greenCoral),
                Map.entry("pelt", pelt),
                Map.entry("wooden mana wisp", woodenManaWisp),
                Map.entry("sunlight archeum essence", sunlightArcheumEssence),
                Map.entry("gilda dust", gildaDust),
                Map.entry("ayanad weaponsmithing scroll", ayanadWeaponsmithingScroll),
                Map.entry("speedboat upgrade ticket", speedboatUpgradeTicket),
                Map.entry("seawhip speedboat design", seawhipSpeedboatDesign),
                Map.entry("veiled flame", veiledFlame),
                Map.entry("medicinal powder", medicinalPowder),
                Map.entry("lavender", lavender),
                Map.entry("farm freighter upgrade ticket", farmFreighterUpgradeTicket),
                Map.entry("wagon upgrade ticket", wagonUpgradeTicket),
                Map.entry("farm wagon design", farmWagonDesign),
                Map.entry("honey", honey),
                Map.entry("royal jelly", royalJelly),
                Map.entry("hushed star", hushedStar),
                Map.entry("lunarite", lunarite),
                Map.entry("dragon essence stabilizer", dragonEssenceStabilizer),
                Map.entry("seabreeze trade pack storage design", seabreezeTradePackStorageDesign),
                Map.entry("mistral trade pack storage design", mistralTradePackStorageDesign),
                Map.entry("seastorm trade pack storage design", seastormTradePackStorageDesign),
                Map.entry("typhoon trade pack storage design", typhoonTradePackStorageDesign),
                Map.entry("caernord seabreeze rudder design", caernordSeabreezeRudderDesign),
                Map.entry("caernord mistral rudder design", caernordMistralRudderDesign),
                Map.entry("caernord seastorm rudder design", caernordSeastormRudderDesign),
                Map.entry("caernord typoon rudder design", caernordTyphoonRudderDesign),
                Map.entry("seabreeze shroudlight design", seabreezeShroudlightDesign),
                Map.entry("mistral shroudlight design", mistralShroudlightDesign),
                Map.entry("seastorm shroudlight design", seastormShroudlightDesign),
                Map.entry("typhoon shroudlight design", typhoonShroudlightDesign),
                Map.entry("one-hander metal mana wisp", oneHanderMetalManaWisp),
                Map.entry("shadow orb", shadowOrb),
                Map.entry("wrathsmite armor shard", wrathsmiteArmorShard),
                Map.entry("iron armor fragment", ironArmorFragment),
                Map.entry("anthalons crimson hallow", anthalonsCrimsonHallow),
                Map.entry("hanure's horn", hanuresHorn),
                Map.entry("kaylin's quill", kaylinsQuill),
                Map.entry("anya pebble", anyaPebble),

                // CompositeItems
                Map.entry("deeply colored oil", deeplyColoredOil),
                Map.entry("erenor gale lunafrost", erenorGaleLunafrost),
                Map.entry("ipnysh lunastone blessing", ipnyshLunastoneBlessing),
                Map.entry("small root pigment", smallRootPigment),
                Map.entry("fabric", fabric),
                Map.entry("beautifully colored fabric", beautifullyColoredFabric),
                Map.entry("magnificent ocean sash", magnificentOceanSash),
                Map.entry("sealed epherium sash", sealedEpheriumSash),
                Map.entry("opaque polish", opaquePolish),
                Map.entry("iron ingot", ironIngot),
                Map.entry("copper ingot", copperIngot),
                Map.entry("silver ingot", silverIngot),
                Map.entry("sturdy ingot", sturdyIngot),
                Map.entry("strong wheel", strongWheel),
                Map.entry("rubber tire", rubberTire),
                Map.entry("gold ingot", goldIngot),
                Map.entry("alloy combiner", alloyCombiner),
                Map.entry("archeum ingot", archeumIngot),
                Map.entry("rough polish", roughPolish),
                Map.entry("mechanical spring", mechanicalSpring),
                Map.entry("viscous glossy oil", viscousGlossyOil),
                Map.entry("exquisite diaphragm", exquisiteDiaphragm),
                Map.entry("spiral accelerator", spiralAccelerator),
                Map.entry("starshard ingot", starshardIngot),
                Map.entry("seabreeze essence", seabreezeEssence),
                Map.entry("bright headlight", brightHeadlight),
                Map.entry("small seed oil", smallSeedOil),
                Map.entry("hydraulic shift", hydraulicShaft),
                Map.entry("high power engine", highPowerEngine),
                Map.entry("sunridge ingot", sunridgeIngot),
                Map.entry("solid shaft", solidShaft),
                Map.entry("racing chassis", racingChassis),
                Map.entry("white pigment", whitePigment),
                Map.entry("lumber", lumber),
                Map.entry("fine lumber", fineLumber),
                Map.entry("nuri forest lumber", nuriForestLumber),
                Map.entry("small leaf pigment", smallLeafPigment),
                Map.entry("cloudspun fabric", cloudspunFabric),
                Map.entry("leather", leather),
                Map.entry("fine leather", fineLeather),
                Map.entry("wind spirit leather", windSpiritLeather),
                Map.entry("crafted vehicle frame: rampage s200", craftedVehicleFrameRampageS200),
                Map.entry("scroll: rampage s200 lite", scrollRampageS200Lite),
                Map.entry("scroll: rampage s200", scrollRampageS200),
                Map.entry("magnificent volcano bow", magnificentVolcanoBow),
                Map.entry("sealed epherium bow", sealedEpheriumBow),
                Map.entry("sealed delphinad bow", sealedDelphinadBow),
                Map.entry("sealed ayanad bow", sealedAyanadBow),
                Map.entry("scroll: seawhip speedboat", scrollSeawhipSpeedboat),
                Map.entry("scroll: seaskimmer speedboat", scrollSeaskimmerSpeedboat),
                Map.entry("cart bucket", cartBucket),
                Map.entry("scroll: farm wagon", scrollFarmWagon),
                Map.entry("scroll: farm hauler", scrollFarmHauler),
                Map.entry("scroll: farm freighter", scrollFarmFreighter),
                Map.entry("wax nugget", waxNugget),
                Map.entry("armored frame", armoredFrame),
                Map.entry("fine lunarite", fineLunarite),
                Map.entry("superior lunarite", superiorLunarite),
                Map.entry("prime lunarite", primeLunarite),
                Map.entry("inferno engine", infernoEngine),
                Map.entry("anima extraction contraption", animaExtractionContraption),
                Map.entry("zephyr trade pack storage", zephyrTradePackStorage),
                Map.entry("seabreeze trade pack storage", seabreezeTradePackStorage),
                Map.entry("mistral trade pack storage", mistralTradePackStorage),
                Map.entry("seastorm trade pack storage", seastormTradePackStorage),
                Map.entry("typhoon trade pack storage", typhoonTradePackStorage),
                Map.entry("caernord zephyr rudder", caernordZephyrRudder),
                Map.entry("caernord seabreeze rudder", caernordSeabreezeRudder),
                Map.entry("caernord mistral rudder", caernordMistralRudder),
                Map.entry("caernord seastorm rudder", caernordSeastormRudder),
                Map.entry("caernord typhoon rudder", caernordTypoonRudder),
                Map.entry("zephyr lamp", zephyrLamp),
                Map.entry("seabreeze shroudlight", seabreezeShroudlight),
                Map.entry("mistral shroudlight", mistralShroudlight),
                Map.entry("seastorm shroudlight", seastormShroudlight),
                Map.entry("typhoon shroudlight", typhoonShroudlight),
                Map.entry("brimstone sunlight seal", brimstoneSunlightSeal),
                Map.entry("cloaked brimstone shortspear(craft)", cloakedBrimstoneShortspearCraft),
                Map.entry("blazing sunridge ingot", blazingSunridgeIngot),
                Map.entry("cloaked brimstone shortspear(transmute)", cloakedBrimstoneShortspearTransmute)
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
