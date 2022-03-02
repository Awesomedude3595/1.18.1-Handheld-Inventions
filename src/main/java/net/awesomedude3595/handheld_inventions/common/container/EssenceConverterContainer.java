package net.awesomedude3595.handheld_inventions.common.container;

import net.awesomedude3595.handheld_inventions.common.block.entity.ChestEntity;
import net.awesomedude3595.handheld_inventions.common.block.entity.EssenceConverterEntity;
import net.awesomedude3595.handheld_inventions.core.init.Blocks;
import net.awesomedude3595.handheld_inventions.core.init.ContainerInit;
import net.awesomedude3595.handheld_inventions.core.init.MenuTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class EssenceConverterContainer extends ItemCombinerMenu {
    public EssenceConverterContainer( int p_39774_, Inventory p_39775_) {
        super(MenuTypes.essence_conveter.get(), p_39774_, p_39775_, ContainerLevelAccess.NULL);
    }

    public EssenceConverterContainer(int p_40248_, Inventory p_40249_, ContainerLevelAccess p_40250_) {
        super(MenuTypes.essence_conveter.get(), p_40248_, p_40249_, p_40250_);
    }

    @Override
    protected boolean mayPickup(Player p_39798_, boolean p_39799_) {
        return false;
    }

    @Override
    protected void onTake(Player p_150601_, ItemStack p_150602_) {

    }

    @Override
    protected boolean isValidBlock(BlockState p_39788_) {
        return false;
    }

    @Override
    public void createResult() {

    }
}
