package com.cscot.scubasteve.objects.items;

import com.cscot.scubasteve.ScubaSteve;
import com.cscot.scubasteve.client.renderer.entity.models.FinsModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FinsItem extends ArmorItem implements IFinsItem
{
    private final String name;
    //private final IArmorMaterial material;  //Variable not used
    //private final EquipmentSlotType armorType;  //Variable not used
    private final Boolean finCheck;

    private static final double SPEED_MULT = 1.04; //TODO update variables when new items are added
    private static final double MAX_SPEED = 1.8;

    public FinsItem(String nameIn, IArmorMaterial materialIn, EquipmentSlotType slots, Boolean isFin, Item.Properties builder) {
        super(materialIn, slots, builder);
        name = nameIn;
        //material = materialIn;  //Variable not used
        //armorType = slots;  //Variable not used
        finCheck = isFin;
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

    @Override
    public boolean areFins (PlayerEntity player, ItemStack stack)
    {
        return true;
    }

    @Override
    public void onArmorTick(ItemStack itemSwimBoots, World world, PlayerEntity swimmingPlayer)
    {
        if (swimmingPlayer.getEntity() != null) {
            if (swimmingPlayer.isSwimming()) {
                if (itemSwimBoots.getItem() instanceof IFinsItem && ((IFinsItem) itemSwimBoots.getItem()).areFins(swimmingPlayer, itemSwimBoots)) {
                    if (swimmingPlayer.isInWater())
                    {
                        double motionX = swimmingPlayer.getMotion().getX() * SPEED_MULT;
                        double motionY = swimmingPlayer.getMotion().getY() * SPEED_MULT;
                        double motionZ = swimmingPlayer.getMotion().getZ() * SPEED_MULT;
                        double newMX = swimmingPlayer.getMotion().getX();
                        double newMY = swimmingPlayer.getMotion().getY();
                        double newMZ = swimmingPlayer.getMotion().getZ();

                        boolean flying = swimmingPlayer.abilities.isFlying;

                        if(Math.abs(motionX) < MAX_SPEED && !flying)
                            newMX = motionX;
                        if(Math.abs(motionY) < MAX_SPEED && !flying)
                            newMY = motionY;
                        if(Math.abs(motionZ) < MAX_SPEED && !flying)
                            newMZ = motionZ;
                        swimmingPlayer.setMotion(newMX, newMY, newMZ);
                    }
                }
            }
        }
    }
}
