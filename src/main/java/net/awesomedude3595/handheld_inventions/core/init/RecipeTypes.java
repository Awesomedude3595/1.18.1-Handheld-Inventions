package net.awesomedude3595.handheld_inventions.core.init;

import net.awesomedude3595.handheld_inventions.common.crafting.ModUpgradeRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.UpgradeRecipe;

public interface RecipeTypes extends RecipeType {
    RecipeType<ModUpgradeRecipe> essence_converter = RecipeType.register("essence_converter");
}
