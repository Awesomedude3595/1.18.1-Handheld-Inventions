package net.awesomedude3595.handheld_inventions.core.init;

import net.awesomedude3595.handheld_inventions.HandheldInventions;
import net.awesomedude3595.handheld_inventions.common.container.ChestContainer;
import net.awesomedude3595.handheld_inventions.common.container.EssenceConverterContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ContainerInit {
    private ContainerInit() {}

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, HandheldInventions.MOD_ID);

    public static final RegistryObject<MenuType<ChestContainer>> chest = CONTAINERS.register("chest", () ->
        new MenuType<>(ChestContainer::new));

    public static final RegistryObject<MenuType<EssenceConverterContainer>> essence_converter = CONTAINERS.register("essence_converter", () ->
            new MenuType<>(EssenceConverterContainer::new));
}
