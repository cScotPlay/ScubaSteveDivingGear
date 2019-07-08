package com.cscot.scubasteve.objects.items;

import com.cscot.scubasteve.ScubaSteve;
import com.cscot.scubasteve.client.renderer.entity.models.SnorkelModel;
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

public class SnorkelItem extends ArmorItem implements ISnorkelItem{

    protected final String name;
    protected final IArmorMaterial material;
    protected final EquipmentSlotType armorType;

    public SnorkelItem(String nameIn, IArmorMaterial materialIn, EquipmentSlotType slots, Item.Properties builder) {
        super(materialIn, slots, builder);
        name = nameIn;
        material = materialIn;
        armorType = slots;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BipedModel getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType equipmentSlot, BipedModel modelBiped)
    {
        return SnorkelModel.INSTANCE;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType equipmentSlot, String armorTexture)
    {
        return ScubaSteve.MODID + ":textures/models/armor/" + name + ".png";
    }

    @Override
    public boolean isSnorkel (PlayerEntity player, ItemStack stack)
    {
        return true;
    }


}
