package net.awesomedude3595.handheld_inventions.core.init;

import net.awesomedude3595.handheld_inventions.HandheldInventions;
import net.awesomedude3595.handheld_inventions.common.block.Chest;
import net.awesomedude3595.handheld_inventions.common.block.EssenceConverter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Blocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HandheldInventions.MOD_ID);

    public static final RegistryObject<Chest> chest = BLOCKS.register("chest", () ->
            new Chest(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));

    public static final RegistryObject<EssenceConverter> essence_converter = BLOCKS.register("essence_converter", () ->
            new EssenceConverter(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
}
