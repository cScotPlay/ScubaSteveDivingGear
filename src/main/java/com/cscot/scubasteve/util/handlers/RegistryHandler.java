package com.cscot.scubasteve.util.handlers;

import com.cscot.scubasteve.ScubaSteve;
import com.cscot.scubasteve.init.WetsuitInit;
import com.cscot.scubasteve.objects.items.FinsItem;
import com.cscot.scubasteve.objects.items.MaskItem;
import com.cscot.scubasteve.objects.items.SnorkelItem;
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
                    WetsuitInit.snorkel_goggles = new MaskItem("snorkel_goggles", WetsuitMaterial.SNORKEL, EquipmentSlotType.HEAD, new Item.Properties().group(ScubaSteve.scubaItemGroup)).setRegistryName(location("snorkel_goggles")),
                    WetsuitInit.snorkel_shirt = new ArmorItem(WetsuitMaterial.SNORKEL, EquipmentSlotType.CHEST, new Item.Properties().group(ScubaSteve.scubaItemGroup)).setRegistryName(location("snorkel_shirt")),
                    WetsuitInit.snorkel_shorts = new ArmorItem(WetsuitMaterial.SNORKEL, EquipmentSlotType.LEGS, new Item.Properties().group(ScubaSteve.scubaItemGroup)).setRegistryName(location("snorkel_shorts")),
                    WetsuitInit.snorkel_fins = new FinsItem("snorkel_fins", WetsuitMaterial.NO_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(ScubaSteve.scubaItemGroup)).setRegistryName(location("snorkel_fins")),
                    WetsuitInit.snorkel_tube = new SnorkelItem("snorkel_tube", WetsuitMaterial.NO_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(ScubaSteve.scubaItemGroup)).setRegistryName(location("snorkel_tube"))
            );

            ScubaSteve.LOGGER.info("ItemBlocks Registered");
        }
    }

    public static ResourceLocation location (String name)
    {
        return new ResourceLocation(ScubaSteve.MODID, name);
    }
}
