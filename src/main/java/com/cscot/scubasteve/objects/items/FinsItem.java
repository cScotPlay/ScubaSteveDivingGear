package com.cscot.scubasteve.objects.items;

import com.cscot.scubasteve.ScubaSteve;
import com.cscot.scubasteve.client.renderer.entity.models.FinsModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FinsItem extends ArmorItem
{
    protected final String name;
    protected final IArmorMaterial material;
    protected final EquipmentSlotType armorType;

    public FinsItem(String nameIn, IArmorMaterial materialIn, EquipmentSlotType slots, Item.Properties builder) {
        super(materialIn, slots, builder);
        name = nameIn;
        material = materialIn;
        armorType = slots;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BipedModel getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType equipmentSlot, BipedModel modelBiped)
    {
        return FinsModel.INSTANCE;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType equipmentSlot, String armorTexture)
    {
        return ScubaSteve.MODID + ":textures/models/armor/" + name + ".png";
    }


}
