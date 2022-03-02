package net.awesomedude3595.handheld_inventions;

import net.awesomedude3595.handheld_inventions.client.screen.EssenceConverterScreen;
import net.awesomedude3595.handheld_inventions.core.event.ClientSetup;
import net.awesomedude3595.handheld_inventions.core.init.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

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
        MenuTypes.MENU_TYPES.register(bus);

        MinecraftForge.EVENT_BUS.register(ClientSetup.class);
    }
}
