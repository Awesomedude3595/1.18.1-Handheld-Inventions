package net.awesomedude3595.handheld_inventions.core.init;

import com.mojang.datafixers.types.Type;
import net.awesomedude3595.handheld_inventions.HandheldInventions;
import net.awesomedude3595.handheld_inventions.common.block.entity.ChestEntity;
import net.awesomedude3595.handheld_inventions.common.block.entity.EssenceConverterEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class BlockEntityTypes extends BlockEntityType {
    public BlockEntityTypes(BlockEntitySupplier p_155259_, Set p_155260_, Type p_155261_) {
        super(p_155259_, p_155260_, p_155261_);
    }

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, HandheldInventions.MOD_ID);

    public static final RegistryObject<BlockEntityType<ChestEntity>> chest = BLOCK_ENTITIES.register("chest", () ->
            BlockEntityType.Builder.of(ChestEntity::new, Blocks.chest.get()).build(null));

    public static final RegistryObject<BlockEntityType<EssenceConverterEntity>> essence_converter = BLOCK_ENTITIES.register("essence_converter", () ->
            BlockEntityType.Builder.of(EssenceConverterEntity::new, Blocks.essence_converter.get()).build(null));
}
