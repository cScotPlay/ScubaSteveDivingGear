package com.cscot.scubasteve.objects.items;

import com.cscot.scubasteve.ScubaSteve;
import com.cscot.scubasteve.client.renderer.entity.models.ModelBootFins;
import javafx.geometry.Side;
import net.minecraft.client.renderer.entity.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemFins extends ItemArmor
{

    protected final String name;
    protected final IArmorMaterial material;
    protected final EntityEquipmentSlot armorType;

    public ItemFins(String nameIn, IArmorMaterial materialIn, EntityEquipmentSlot slots, Item.Properties builder) {
        super(materialIn, slots, builder);
        name = nameIn;
        material = materialIn;
        armorType = slots;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot equipmentSlot, ModelBiped modelBiped)
    {
        return ModelBootFins.INSTANCE;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot equipmentSlot, String armorTexture)
    {
        return ScubaSteve.MODID + ":textures/models/armor/" + name + ".png";
    }


}
