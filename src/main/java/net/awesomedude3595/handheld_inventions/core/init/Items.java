package net.awesomedude3595.handheld_inventions.core.init;

import net.awesomedude3595.handheld_inventions.HandheldInventions;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    private Items() {}

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HandheldInventions.MOD_ID);

    public static final RegistryObject<Item> tnt_launcher = ITEMS.register("tnt_launcher", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> invention_shrinker = ITEMS.register("invention_shrinker", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> size_bug_essence = ITEMS.register("size_bug_essence", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> shrinking_matter = ITEMS.register("shrinking_matter", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> expanding_matter = ITEMS.register("expanding_matter", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<BlockItem> chest = ITEMS.register("chest", () ->
            new BlockItem(Blocks.chest.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<BlockItem> essence_converter = ITEMS.register("essence_converter", () ->
            new BlockItem(Blocks.essence_converter.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
