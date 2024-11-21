package com.marllon.kneemod.item;

import com.marllon.kneemod.KneeSurgery;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;



public class ModItems {

    public static final Item PINK_GARNET = registerItem(name: "pink_garnet", new Item(Item.Settings()));


    private static Item registerItem(String name, Item item) {


        return Registry.register(Registries.ITEM, Identifier.of(KneeSurgery.MOD_ID, name), item);
    }



    public static void registerModItems() {
        KneeSurgery.LOGGER.info("Registering Mod Items for " + KneeSurgery.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(PINK_GARNET);
        });
    }
}
