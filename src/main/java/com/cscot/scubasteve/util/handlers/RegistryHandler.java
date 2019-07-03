package com.cscot.scubasteve.util.handlers;

import com.cscot.scubasteve.ScubaSteve;
import com.cscot.scubasteve.init.WetsuitInit;
import com.cscot.scubasteve.objects.items.FinsItem;
import com.cscot.scubasteve.objects.items.MaskItem;
import com.cscot.scubasteve.objects.items.WetsuitMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class RegistryHandler
{
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {


        @SubscribeEvent
        public static void onWetsuitRegistry(final RegistryEvent.Register<Item> wetsuitRegisterEvent)
        {
            wetsuitRegisterEvent.getRegistry().registerAll
            (
                    //TODO Check for ItemArmorDyaable update and update all the items
                    WetsuitInit.snorkeling_mask = new MaskItem("snorkeling_mask", WetsuitMaterial.SNORKELING, EquipmentSlotType.HEAD, new Item.Properties().group(ScubaSteve.scubaItemGroup)).setRegistryName(location("snorkeling_mask")),
                    WetsuitInit.snorkeling_shirt = new ArmorItem(WetsuitMaterial.SNORKELING, EquipmentSlotType.CHEST, new Item.Properties().group(ScubaSteve.scubaItemGroup)).setRegistryName(location("snorkeling_shirt")),
                    WetsuitInit.snorkeling_shorts = new ArmorItem(WetsuitMaterial.SNORKELING, EquipmentSlotType.LEGS, new Item.Properties().group(ScubaSteve.scubaItemGroup)).setRegistryName(location("snorkeling_shorts")),
                    WetsuitInit.snorkeling_fins = new FinsItem("snorkeling_fins", WetsuitMaterial.NO_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(ScubaSteve.scubaItemGroup)).setRegistryName(location("snorkeling_fins"))
            );

            ScubaSteve.LOGGER.info("ItemBlocks Registered");
        }
    }

    public static ResourceLocation location (String name)
    {
        return new ResourceLocation(ScubaSteve.MODID, name);
    }
}
