package net.awesomedude3595.handheld_inventions.common.container;

import net.awesomedude3595.handheld_inventions.common.block.entity.ChestEntity;
import net.awesomedude3595.handheld_inventions.core.init.Blocks;
import net.awesomedude3595.handheld_inventions.core.init.ContainerInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ChestContainer extends AbstractContainerMenu {
    private final ContainerLevelAccess containerAccess;

    //server constructor
    public ChestContainer(int id, Inventory playerInv, IItemHandler slots, BlockPos blockPos) {
        super(ContainerInit.chest.get(), id);
        this.containerAccess = ContainerLevelAccess.create(playerInv.player.level, blockPos);
        final int slotSizePlus2 = 18, startX = 8, startY = 84, hotbarY = 142, inventoryY = 17;

        for(int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new SlotItemHandler(slots, row * 9 + column, startX + column * slotSizePlus2, inventoryY + row * slotSizePlus2));
            }
        }

        for(int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(playerInv, 9 + row * 9 + column, startX + column * slotSizePlus2, startY + row * slotSizePlus2));
            }
        }

        for (int column = 0; column < 9; column++) {
            addSlot(new Slot(playerInv,column, startX + column * slotSizePlus2, hotbarY));
        }
    }

    //client constructor
    public ChestContainer(int id, Inventory playerInv) {
        this(id, playerInv, new ItemStackHandler(27), BlockPos.ZERO);
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(containerAccess, player, Blocks.chest.get());
    }

    public static MenuConstructor getServerContainer(ChestEntity chest, BlockPos blockPos) {
        return (id, playerInv, player) -> new ChestContainer(id, playerInv, chest.inventory, blockPos);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        var retStack = ItemStack.EMPTY;
        final Slot slot = getSlot(index);
        if (slot.hasItem()) {
            final ItemStack item = slot.getItem();
            retStack = item.copy();
            if (index < 27) {
                if (!moveItemStackTo(item, 27, this.slots.size(), true))
                    return ItemStack.EMPTY;
            } else if (!moveItemStackTo( item, 0, 27, false))
                return ItemStack.EMPTY;

            if (item.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            }
            else {
                slot.setChanged();
            }
        }
        return retStack;
    }
}
