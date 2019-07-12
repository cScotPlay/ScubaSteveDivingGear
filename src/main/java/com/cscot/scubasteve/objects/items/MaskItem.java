package com.cscot.scubasteve.objects.items;

import com.cscot.scubasteve.ScubaSteve;
import com.cscot.scubasteve.client.renderer.entity.models.FinsModel;
import com.cscot.scubasteve.client.renderer.entity.models.SnorkelModel;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;

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
    public void onArmorTick(ItemStack itemMask, World world, PlayerEntity swimmingPlayer)
    {
        this.getSnorkelAir(itemMask, swimmingPlayer);
        this.maskVision(itemMask, swimmingPlayer);
    }

    @Override
    public boolean isMask (PlayerEntity player, ItemStack stack){
        return maskCheck;
    }

    @Override
    public boolean isSnorkel(PlayerEntity player, ItemStack stack) {
        return snorkelCheck;
    }

    private void getSnorkelAir(ItemStack itemMask, PlayerEntity swimmingPlayer)
    {
        if (((IMasksItem)itemMask.getItem()).isSnorkel(swimmingPlayer, itemMask) && !swimmingPlayer.areEyesInFluid(FluidTags.WATER)) {
            swimmingPlayer.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 400, 0, false, false, false));
        }
        else onUnequipped(itemMask, swimmingPlayer);
    }

    private void maskVision(ItemStack itemMask, PlayerEntity swimmingPlayer)
    {
        if(maskCheck && swimmingPlayer.areEyesInFluid(FluidTags.WATER)) {
            swimmingPlayer.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, Integer.MAX_VALUE, -42, false, false, true));
        }
        else onUnequipped(itemMask, swimmingPlayer);
    }

    private void onUnequipped(ItemStack stack, PlayerEntity swimmingPlayer) //TODO Look at how this works
    {
        EffectInstance visionEffect = swimmingPlayer.getActivePotionEffect(Effects.NIGHT_VISION);
        EffectInstance airEffect = swimmingPlayer.getActivePotionEffect(Effects.WATER_BREATHING);

        if (visionEffect != null && visionEffect.getAmplifier() == -42 || swimmingPlayer.areEyesInFluid(FluidTags.WATER)){
            swimmingPlayer.removePotionEffect(Effects.NIGHT_VISION);
        }

        if (airEffect != null && swimmingPlayer.areEyesInFluid(FluidTags.WATER)) {
            swimmingPlayer.removePotionEffect(Effects.WATER_BREATHING);
        }

    }
}
