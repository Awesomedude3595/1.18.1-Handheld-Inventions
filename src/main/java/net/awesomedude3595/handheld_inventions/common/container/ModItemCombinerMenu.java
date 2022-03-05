package net.awesomedude3595.handheld_inventions.common.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public abstract class ModItemCombinerMenu extends AbstractContainerMenu{
    protected final ResultContainer resultSlots = new ResultContainer();
    protected final Container fakeSlot = new SimpleContainer(1) {
        public void setChanged() {
            super.setChanged();
            ModItemCombinerMenu.this.slotsChanged(this);
        }
    };
    protected final Container inputSlots = new SimpleContainer(3) {
        public void setChanged() {
            super.setChanged();
            ModItemCombinerMenu.this.slotsChanged(this);
        }
    };
    protected final ContainerLevelAccess access;
    protected final Player player;

    protected abstract boolean mayPickup(Player p_39798_, boolean p_39799_);

    protected abstract void onTake(Player p_150601_, ItemStack p_150602_);

    protected abstract boolean isValidBlock(BlockState p_39788_);

    public ModItemCombinerMenu(@Nullable MenuType<?> p_39773_, int p_39774_, Inventory p_39775_, ContainerLevelAccess p_39776_) {
        super(p_39773_, p_39774_);
        this.access = p_39776_;
        this.player = p_39775_.player;
        this.addSlot(new Slot(this.inputSlots, 0, 8, 17));
        this.addSlot(new Slot(this.inputSlots, 1, 8, 17 + 18));
        this.addSlot(new Slot(this.inputSlots, 2, 8 + 18*3, 17));
        this.addSlot(new Slot(this.fakeSlot, 3, 8 + 18*8, 17));
        this.addSlot(new Slot(this.resultSlots, 4, 8 + 18*8, 17 +18) {
            public boolean mayPlace(ItemStack p_39818_) {
                return false;
            }

            public boolean mayPickup(Player p_39813_) {
                return ModItemCombinerMenu.this.mayPickup(p_39813_, this.hasItem());
            }

            public void onTake(Player p_150604_, ItemStack p_150605_) {
                ModItemCombinerMenu.this.onTake(p_150604_, p_150605_);
            }
        });

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(p_39775_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(p_39775_, k, 8 + k * 18, 142));
        }

    }

    public abstract void createResult();

    public void slotsChanged(Container p_39778_) {
        super.slotsChanged(p_39778_);
        if (p_39778_ == this.inputSlots) {
            this.createResult();
        }

    }

    public void removed(Player p_39790_) {
        super.removed(p_39790_);
        this.access.execute((p_39796_, p_39797_) -> {
            this.clearContainer(p_39790_, this.inputSlots);
        });
    }

    public boolean stillValid(Player p_39780_) {
        return this.access.evaluate((p_39785_, p_39786_) -> {
            return !this.isValidBlock(p_39785_.getBlockState(p_39786_)) ? false : p_39780_.distanceToSqr((double)p_39786_.getX() + 0.5D, (double)p_39786_.getY() + 0.5D, (double)p_39786_.getZ() + 0.5D) <= 64.0D;
        }, true);
    }

    protected boolean shouldQuickMoveToAdditionalSlot(ItemStack p_39787_) {
        return true;
    }

    public ItemStack quickMoveStack(Player p_39792_, int p_39793_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_39793_);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (p_39793_ == 3) {
                if (!this.moveItemStackTo(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (p_39793_ != 0 && p_39793_ != 1) {
                if (p_39793_ >= 3 && p_39793_ < 39) {
                    int i = this.shouldQuickMoveToAdditionalSlot(itemstack) ? 1 : 0;
                    if (!this.moveItemStackTo(itemstack1, i, 3, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(itemstack1, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(p_39792_, itemstack1);
        }

        return itemstack;
    }
}
