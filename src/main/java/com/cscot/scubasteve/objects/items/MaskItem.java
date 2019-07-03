package com.cscot.scubasteve.objects.items;

import com.cscot.scubasteve.ScubaSteve;
import com.cscot.scubasteve.client.renderer.entity.models.FinsModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MaskItem extends ArmorItem implements IMasksItem
{
    protected final String name;
    protected final IArmorMaterial material;
    protected final EquipmentSlotType armorSlot;

    public MaskItem(String nameIn, IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties builder) {
        super(materialIn, slot, builder);
        name = nameIn;
        material = materialIn;
        armorSlot = slot;
    }

    /*@Override
    @OnlyIn(Dist.CLIENT)
    public BipedModel getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType equipmentSlot, BipedModel modelBiped)
    {
        return FinsModel.INSTANCE;
    }*/

    /*@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType equipmentSlot, String armorTexture)
    {
        return ScubaSteve.MODID + ":textures/models/armor/" + name + ".png";
    }*/

    @Override
    public boolean isScubaMask (PlayerEntity player, ItemStack stack){

        return true;
    }
}
