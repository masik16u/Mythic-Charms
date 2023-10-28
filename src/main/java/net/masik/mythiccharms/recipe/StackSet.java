package net.masik.mythiccharms.recipe;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StackSet implements Inventory {
    private final Set<ItemStack> stacks;

    public StackSet(Collection<ItemStack> stacks) {
        this.stacks = Set.copyOf(stacks);
    }

    public boolean matches(Collection<ItemStack> stacks) {
        Set<ItemStack> stacksCopy = new HashSet<>(stacks);
        stacksCopy.removeAll(this.stacks);
        return stacksCopy.isEmpty();
    }

    @Override
    public int size() {
        return this.stacks.size();
    }

    @Override
    public boolean isEmpty() {
        return this.stacks.isEmpty();
    }

    @Override
    public ItemStack getStack(int slot) {
        throw new UnsupportedOperationException("StackSet does not support getStack");
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        throw new UnsupportedOperationException("StackSet does not support removeStack");
    }

    @Override
    public ItemStack removeStack(int slot) {
        throw new UnsupportedOperationException("StackSet does not support removeStack");
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        throw new UnsupportedOperationException("StackSet does not support setStack");
    }

    @Override
    public void markDirty() {

    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return false;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("StackSet does not support clear");
    }
}
