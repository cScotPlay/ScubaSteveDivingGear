package com.cscot.scubasteve.objects.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public interface ISnorkelItem
{
    boolean isSnorkel(PlayerEntity player, ItemStack stack);
}
