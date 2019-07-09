package com.cscot.scubasteve.objects.items;

import com.cscot.scubasteve.ScubaSteve;
import com.cscot.scubasteve.client.renderer.entity.models.FinsModel;
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

public class MaskItem extends ArmorItem implements IMasksItem
{
    protected final String name;
    protected final IArmorMaterial material;
    protected final EquipmentSlotType armorSlot;
    protected final Boolean maskCheck;
    protected final Boolean snorkelCheck;

    public MaskItem(String nameIn, IArmorMaterial materialIn, EquipmentSlotType slot, Boolean isMask, Boolean isSnorkel, Item.Properties builder) {
        super(materialIn, slot, builder);
        name = nameIn;
        material = materialIn;
        armorSlot = slot;
        maskCheck = isMask;
        snorkelCheck = isSnorkel;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BipedModel getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType equipmentSlot, BipedModel modelBiped)
    {
        if(snorkelCheck){
            return SnorkelModel.INSTANCE;
        }
        else
        //return FinsModel.INSTANCE;
        return modelBiped;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType equipmentSlot, String armorTexture)
    {
        if(snorkelCheck){
            if(maskCheck){
                return ScubaSteve.MODID + ":textures/models/armor/snorkel_mask.png";
            }
            else
                return ScubaSteve.MODID + ":textures/models/armor/" + name + ".png";
        } else
            return armorTexture;
    }

    @Override
    public boolean isMask (PlayerEntity player, ItemStack stack){
        return maskCheck;
    }

    @Override
    public boolean isSnorkel(PlayerEntity player, ItemStack stack) {
        return snorkelCheck;
    }
}
