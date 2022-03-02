package net.awesomedude3595.handheld_inventions.core.init;

import net.awesomedude3595.handheld_inventions.HandheldInventions;
import net.awesomedude3595.handheld_inventions.common.entity.Bug;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Entities {

    private Entities() {}

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, HandheldInventions.MOD_ID);

    public static final RegistryObject<EntityType<Bug>> bug = ENTITIES.register("bug", () ->
            EntityType.Builder.of(Bug::new, MobCategory.CREATURE)
                    .sized(0.8f, 0.6f)
                    .build(new ResourceLocation(HandheldInventions.MOD_ID,"bug").toString()));
}
