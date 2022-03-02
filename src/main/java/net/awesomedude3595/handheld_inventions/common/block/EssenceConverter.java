package net.awesomedude3595.handheld_inventions.common.block;

import net.awesomedude3595.handheld_inventions.common.block.entity.EssenceConverterEntity;
import net.awesomedude3595.handheld_inventions.common.container.ChestContainer;
import net.awesomedude3595.handheld_inventions.common.container.EssenceConverterContainer;
import net.awesomedude3595.handheld_inventions.core.init.BlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class EssenceConverter extends Block implements EntityBlock {
    public EssenceConverter(Properties prop) {
        super(prop);
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return BlockEntityTypes.essence_converter.get().create(blockPos, blockState);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if (!level.isClientSide && level.getBlockEntity(blockPos) instanceof final EssenceConverterEntity chest) {
            MenuProvider container = new SimpleMenuProvider((A, B, C) -> {
                return new EssenceConverterContainer(A, B, ContainerLevelAccess.create(level, blockPos));
            }, EssenceConverterEntity.TITLE);
            NetworkHooks.openGui((ServerPlayer) player, container, blockPos);
        }
        return InteractionResult.SUCCESS;
    }
}