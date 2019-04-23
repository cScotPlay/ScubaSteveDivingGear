package com.cscot.scubasteve.util.handlers;

import com.cscot.scubasteve.ScubaSteve;
import com.cscot.scubasteve.init.WetsuitInit;
import com.cscot.scubasteve.objects.items.ItemFins;
import com.cscot.scubasteve.objects.items.ItemWetsuitMaterial;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmorDyeable;
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
                            WetsuitInit.wetsuit_helmet = new ItemArmor(ItemWetsuitMaterial.wetsuit, EntityEquipmentSlot.HEAD, new Item.Properties().group(ScubaSteve.scubaItemGroup)).setRegistryName(location("wetsuit_helmet")),
                            WetsuitInit.wetsuit_chestplate = new ItemArmor(ItemWetsuitMaterial.wetsuit, EntityEquipmentSlot.CHEST, new Item.Properties().group(ScubaSteve.scubaItemGroup)).setRegistryName(location("wetsuit_chestplate")),
                            WetsuitInit.wetsuit_leggings = new ItemArmor(ItemWetsuitMaterial.wetsuit, EntityEquipmentSlot.LEGS, new Item.Properties().group(ScubaSteve.scubaItemGroup)).setRegistryName(location("wetsuit_leggings")),
                            WetsuitInit.wetsuit_boots = new ItemFins("wetsuit_boots", ItemWetsuitMaterial.noarmor, EntityEquipmentSlot.FEET, new Item.Properties().group(ScubaSteve.scubaItemGroup)).setRegistryName(location("wetsuit_boots"))


                    );

            ScubaSteve.LOGGER.info("ItemBlocks Registered");
        }



    }

    public static ResourceLocation location (String name)
    {
        return new ResourceLocation(ScubaSteve.MODID, name);
    }
}
