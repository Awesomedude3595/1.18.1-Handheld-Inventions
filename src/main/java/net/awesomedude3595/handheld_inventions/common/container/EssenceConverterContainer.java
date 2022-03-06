package net.awesomedude3595.handheld_inventions.common.container;

import net.awesomedude3595.handheld_inventions.common.crafting.ModUpgradeRecipe;
import net.awesomedude3595.handheld_inventions.core.init.ContainerInit;
import net.awesomedude3595.handheld_inventions.core.init.Items;
import net.awesomedude3595.handheld_inventions.core.init.RecipeTypes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.UpgradeRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class EssenceConverterContainer extends ModItemCombinerMenu {
    public static boolean result = false;
    private final Level level;
    @Nullable
    private ModUpgradeRecipe selectedRecipe;
    private final List<ModUpgradeRecipe> recipes;

    public EssenceConverterContainer(int p_40245_, Inventory p_40246_) {
        this(p_40245_, p_40246_, ContainerLevelAccess.NULL);
    }

    public EssenceConverterContainer(int p_40248_, Inventory p_40249_, ContainerLevelAccess p_40250_) {
        super(ContainerInit.essence_converter.get(), p_40248_, p_40249_, p_40250_);
        this.level = p_40249_.player.level;
        this.recipes = this.level.getRecipeManager().getAllRecipesFor(RecipeTypes.essence_converter);
    }

    protected boolean isValidBlock(BlockState p_40266_) {
        return true;
    }

    protected boolean mayPickup(Player p_40268_, boolean p_40269_) {
        return this.selectedRecipe != null && this.selectedRecipe.matches(this.inputSlots, this.level);
    }

    protected void onTake(Player p_150663_, ItemStack p_150664_) {
        p_150664_.onCraftedBy(p_150663_.level, p_150663_, p_150664_.getCount());
        this.resultSlots.awardUsedRecipes(p_150663_);
        this.shrinkStackInSlot(0);
        this.shrinkStackInSlot(1);
        this.shrinkStackInSlot(2);
        this.access.execute((p_40263_, p_40264_) -> {
            p_40263_.levelEvent(1044, p_40264_, 0);
        });
    }

    private void shrinkStackInSlot(int p_40271_) {
        ItemStack itemstack = this.inputSlots.getItem(p_40271_);
        itemstack.shrink(1);
        this.inputSlots.setItem(p_40271_, itemstack);
    }

    public void createResult() {
        List<ModUpgradeRecipe> list = this.level.getRecipeManager().getRecipesFor(RecipeTypes.essence_converter, this.inputSlots, this.level);
        if (list.isEmpty()) {
            this.resultSlots.setItem(0, ItemStack.EMPTY);
        } else {
            this.selectedRecipe = list.get(0);
            ItemStack itemstack = this.selectedRecipe.assemble(this.inputSlots);
            this.resultSlots.setRecipeUsed(this.selectedRecipe);
            this.resultSlots.setItem(0, itemstack);
        }

    }

    protected boolean shouldQuickMoveToAdditionalSlot(ItemStack p_40255_) {
        return this.recipes.stream().anyMatch((p_40261_) -> {
            return p_40261_.isAdditionIngredient(p_40255_);
        });
    }

    public boolean canTakeItemForPickAll(ItemStack p_40257_, Slot p_40258_) {
        return p_40258_.container != this.resultSlots && super.canTakeItemForPickAll(p_40257_, p_40258_);
    }

}
