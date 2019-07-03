package com.cscot.scubasteve.init;

import com.cscot.scubasteve.ScubaSteve;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class WetsuitInit
{
    @ObjectHolder(ScubaSteve.MODID + ":snorkeling_mask")
    public static Item snorkeling_mask;

    @ObjectHolder(ScubaSteve.MODID + ":snorkeling_shirt")
    public static Item snorkeling_shirt;

    @ObjectHolder(ScubaSteve.MODID + ":snorkeling_shorts")
    public static Item snorkeling_shorts;

    @ObjectHolder(ScubaSteve.MODID + ":snorkeling_fins")
    public static Item snorkeling_fins;
}
