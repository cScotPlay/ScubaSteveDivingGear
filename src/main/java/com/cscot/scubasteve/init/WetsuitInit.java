package com.cscot.scubasteve.init;

import com.cscot.scubasteve.ScubaSteve;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class WetsuitInit
{
    @ObjectHolder(ScubaSteve.MODID + ":wetsuit_helmet")
    public static Item wetsuit_helmet;

    @ObjectHolder(ScubaSteve.MODID + ":wetsuit_chestplate")
    public static Item wetsuit_chestplate;

    @ObjectHolder(ScubaSteve.MODID + ":wetsuit_leggings")
    public static Item wetsuit_leggings;

    @ObjectHolder(ScubaSteve.MODID + ":wetsuit_boots")
    public static Item wetsuit_boots;
}
