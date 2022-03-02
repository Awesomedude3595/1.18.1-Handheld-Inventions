package net.awesomedude3595.handheld_inventions.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.awesomedude3595.handheld_inventions.HandheldInventions;
import net.awesomedude3595.handheld_inventions.common.container.ChestContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.client.gui.widget.ExtendedButton;

public class ChestScreen extends AbstractContainerScreen<ChestContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(HandheldInventions.MOD_ID, "textures/gui/chest.png");

    public ChestScreen(ChestContainer container, Inventory playerInv, Component title) {
        super(container, playerInv, title);
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 175;
        this.imageHeight =  166;
    }

    @Override
    protected void renderBg(PoseStack stack, float mouseX, int mouseY, int partialTicks) {
        renderBackground(stack);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        blit(stack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(PoseStack stack, int mouseX, int mouseY) {
        drawString(stack, font, title, 8, 5, 0x404040);
        drawString(stack, font, playerInventoryTitle, 8, 73, 0x404040);
    }

    @Override
    protected void init() {
        super.init();
        this.addRenderableWidget(new ExtendedButton(leftPos + 124, topPos + 71, 48, 11, new TextComponent("Beans"), btn ->{
            Minecraft.getInstance().player.displayClientMessage(new TextComponent("BEANS"), false);
        }));
    }
}
