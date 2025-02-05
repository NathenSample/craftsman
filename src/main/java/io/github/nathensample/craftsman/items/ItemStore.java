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
        itemMap.put("cloth mana wisp", clothManaWisp);

        BaseItem charcoalStabilizer = new BaseItem("Charcoal Stabilizer"); //Charcoal Stabilizer
        itemMap.put("charcoal stabilizer", charcoalStabilizer); //Charcoal Stabilizer
        BaseItem fabric = new BaseItem("Fabric"); //Fabric
        itemMap.put("fabric", fabric); //Fabric
        BaseItem narcicuss = new BaseItem("Narcicuss"); //Narcicuss
        itemMap.put("narcicuss", narcicuss); //Narcicuss
        BaseItem clover = new BaseItem("Clover"); //Narcicuss
        itemMap.put("clover", clover); //Clover
        BaseItem rose = new BaseItem("Rose"); //Rose
        itemMap.put("rose", rose); //Rose
        BaseItem moonlightArcheumEssence = new BaseItem(("Moonlight Archeum Essence"));
        itemMap.put("moonlight archeum essence", moonlightArcheumEssence);


        CompositeItem smallRootPigment = new CompositeItem("Small Root Pigment", Map.of(charcoalStabilizer, 3, clover, 20, rose, 20));
        itemMap.put("small root pigment", smallRootPigment);
        CompositeItem beautifullyColoredFabric = new CompositeItem("Beautifully Colored Fabric", Map.of(fabric, 10, smallRootPigment, 1));
        itemMap.put("beautifully colored fabric", beautifullyColoredFabric);
        CompositeItem magnificentOceanSash = new CompositeItem("Magnificent Ocean Sash", Map.of(clothManaWisp, 9));
        itemMap.put("magnificent ocean sash", magnificentOceanSash);

        CompositeItem sealedEpheriumSash = new CompositeItem("Sealed Epherium Sash", Map.of(moonlightArcheumEssence, 3, beautifullyColoredFabric, 2));
        itemMap.put("sealed epherium sash", sealedEpheriumSash);


    }

    public Optional<Item> getItem(String name) {
        return Optional.ofNullable(itemMap.get(name));
    }
}
