package net.awesomedude3595.handheld_inventions.client.renderer;

import net.awesomedude3595.handheld_inventions.HandheldInventions;
import net.awesomedude3595.handheld_inventions.client.renderer.model.BugModel;
import net.awesomedude3595.handheld_inventions.common.entity.Bug;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BugRenderer<Type extends Bug> extends MobRenderer<Type, BugModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(HandheldInventions.MOD_ID, "textures/entities/bug.png");

    public BugRenderer(Context context) {
        super(context, new BugModel<>(context.bakeLayer(BugModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }
}
