package net.awesomedude3595.handheld_inventions.core.init;

import net.awesomedude3595.handheld_inventions.HandheldInventions;
import net.awesomedude3595.handheld_inventions.common.container.EssenceConverterContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypes<T>{
    private MenuTypes() {}

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, HandheldInventions.MOD_ID);

    public static final RegistryObject<MenuType<EssenceConverterContainer>> essence_conveter = MENU_TYPES.register("essence_conveter", () -> new MenuType<>(EssenceConverterContainer::new));
}
