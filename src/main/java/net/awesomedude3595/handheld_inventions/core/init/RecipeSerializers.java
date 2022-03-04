package net.awesomedude3595.handheld_inventions.core.init;

import net.awesomedude3595.handheld_inventions.HandheldInventions;
import net.awesomedude3595.handheld_inventions.common.container.crafting.ModUpgradeRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeSerializers {
    private RecipeSerializers() {}

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, HandheldInventions.MOD_ID);

    public static final RegistryObject<RecipeSerializer<ModUpgradeRecipe>> essence_converter = RECIPE_SERIALIZERS.register("essence_converter", () -> new ModUpgradeRecipe.Serializer());
}