package net.awesomedude3595.handheld_inventions.common.block.entity;

import net.awesomedude3595.handheld_inventions.HandheldInventions;
import net.awesomedude3595.handheld_inventions.core.init.BlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;

public class ChestEntity extends InventoryBlockEntity{
    public static final Component TITLE = new TranslatableComponent("container." + HandheldInventions.MOD_ID + ".chest");

    public ChestEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityTypes.chest.get(), blockPos, blockState, 27);
    }
}
