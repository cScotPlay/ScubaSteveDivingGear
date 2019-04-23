package com.cscot.scubasteve.util.itemgroups;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ScubaItemGroup extends ItemGroup
{
    public ScubaItemGroup()
    {
        super("scubasteveitemgroup");
    }

    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(Item.BLOCK_TO_ITEM.get(Blocks.TUBE_CORAL));
    }
}
