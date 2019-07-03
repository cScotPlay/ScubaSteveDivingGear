package com.cscot.scubasteve.objects.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public interface IFinsItem
{
    boolean areFinsEnabled(PlayerEntity player, ItemStack stack);
}
