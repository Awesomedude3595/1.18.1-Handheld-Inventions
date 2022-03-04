package net.awesomedude3595.handheld_inventions;

import net.awesomedude3595.handheld_inventions.client.event.ClientModEvents;
import net.awesomedude3595.handheld_inventions.client.screen.EssenceConverterScreen;
import net.awesomedude3595.handheld_inventions.core.init.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

@Mod("handheld_inventions")
public class HandheldInventions {

    public static final String MOD_ID = "handheld_inventions";
    public HandheldInventions() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();

        Items.ITEMS.register(bus);
        Entities.ENTITIES.register(bus);
        Blocks.BLOCKS.register(bus);
        BlockEntityTypes.BLOCK_ENTITIES.register(bus);
        ContainerInit.CONTAINERS.register(bus);
        RecipeSerializers.RECIPE_SERIALIZERS.register(bus);
    }
}
