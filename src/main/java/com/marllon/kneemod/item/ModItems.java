package com.marllon.kneemod.item;

import com.marllon.kneemod.KneeSurgery;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;


public class ModItems {

    public static final Item PINK_GARNET = registerItem("pink_garnet", Item::new);
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", Item::new);
    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(KneeSurgery.MOD_ID, name), function.apply(new Item.Settings().registryKey(keyOfItem(name))));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(KneeSurgery.MOD_ID, name));
    }

    public static void registerModItems() {
        KneeSurgery.LOGGER.info("Registering Mod Items for " + KneeSurgery.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
                    fabricItemGroupEntries.add(PINK_GARNET);
                    fabricItemGroupEntries.add(RAW_PINK_GARNET);
        });
    }

    /*  public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));


   private static Item registerItem(String name, Item item) {


        return Registry.register(Registries.ITEM, Identifier.of(KneeSurgery.MOD_ID, name), item);
    }



    public static void registerModItems() {
        KneeSurgery.LOGGER.info("Registering Mod Items for " + KneeSurgery.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(PINK_GARNET);
        });
    } */
}
