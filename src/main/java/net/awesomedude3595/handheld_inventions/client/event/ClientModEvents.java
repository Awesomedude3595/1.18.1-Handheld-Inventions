package net.awesomedude3595.handheld_inventions.client.event;

import net.awesomedude3595.handheld_inventions.HandheldInventions;
import net.awesomedude3595.handheld_inventions.client.renderer.BugRenderer;
import net.awesomedude3595.handheld_inventions.client.renderer.model.BugModel;
import net.awesomedude3595.handheld_inventions.client.screen.ChestScreen;
import net.awesomedude3595.handheld_inventions.client.screen.EssenceConverterScreen;
import net.awesomedude3595.handheld_inventions.core.init.ContainerInit;
import net.awesomedude3595.handheld_inventions.core.init.Entities;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber( modid = HandheldInventions.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    private ClientModEvents() {}

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BugModel.LAYER_LOCATION, BugModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Entities.bug.get(), BugRenderer::new);
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> MenuScreens.register(ContainerInit.essence_converter.get(), EssenceConverterScreen::new));
        event.enqueueWork(() -> MenuScreens.register(ContainerInit.chest.get(), ChestScreen::new));
    }
}
