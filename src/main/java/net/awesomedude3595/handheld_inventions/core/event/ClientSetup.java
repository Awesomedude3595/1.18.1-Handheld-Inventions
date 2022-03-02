package net.awesomedude3595.handheld_inventions.core.event;

import net.awesomedude3595.handheld_inventions.client.screen.EssenceConverterScreen;
import net.awesomedude3595.handheld_inventions.core.init.MenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {
    private void clientSetup(final FMLClientSetupEvent event) {
        MenuScreens.register(MenuTypes.essence_conveter.get(), EssenceConverterScreen::new);
    }
}
