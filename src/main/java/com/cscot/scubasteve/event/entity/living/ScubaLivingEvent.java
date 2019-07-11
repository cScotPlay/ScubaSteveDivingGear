package com.cscot.scubasteve.event.entity.living;

import com.cscot.scubasteve.ScubaSteve;
import com.cscot.scubasteve.init.WetsuitInit;
import com.cscot.scubasteve.objects.items.FinsItem;
import com.cscot.scubasteve.objects.items.IFinsItem;
import com.cscot.scubasteve.objects.items.IMasksItem;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber
public class ScubaLivingEvent
{
    /*@SubscribeEvent (priority = EventPriority.NORMAL, receiveCanceled = true)
    //public static void LivingUpdateEvent(LivingEvent.LivingUpdateEvent swimEvent)
    public static void LivingUpdateEvent(TickEvent.PlayerTickEvent swimEvent)
    {
        PlayerEntity swimmingPlayer = swimEvent.player;
        Vec3d vec3d = swimmingPlayer.getMotion();

        if (swimEvent.player.getEntity() != null && swimEvent.player instanceof PlayerEntity)
        {
            //PlayerEntity swimmingPlayer = (PlayerEntity) swimEvent.getEntity();

            ItemStack itemSwimBoots = swimmingPlayer.getItemStackFromSlot(EquipmentSlotType.FEET);

            if (swimmingPlayer.isSwimming()){
                if (itemSwimBoots.getItem() instanceof IFinsItem && ((IFinsItem)itemSwimBoots.getItem()).areFins(swimmingPlayer, itemSwimBoots)) {
                    //Vec3d vec3d = swimmingPlayer.getMotion();
                    if (swimmingPlayer.isInWater())
                    {
                        //double swimSpeedX = vec3d.x *1.04D;
                        //double swimSpeedY = vec3d.y *1.04D;
                        //double swimSpeedZ = vec3d.z *1.04D;

                        //this.setMotion(this.getMotion().mul(0.6D, 1.0D, 0.6D));  //TODO Check to see if we can get this to work

                        double d3 = swimmingPlayer.getLookVec().y;
                        double d4 = d3 < -0.2D ? 0.065D : 0.04D;
                        if (d3 <= 0.0D || !swimmingPlayer.world.getBlockState(new BlockPos(swimmingPlayer.posX, swimmingPlayer.posY + 1.0D - 0.1D, swimmingPlayer.posZ)).getFluidState().isEmpty()) {
                            Vec3d vec3d1 = swimmingPlayer.getMotion();
                            swimmingPlayer.setMotion(vec3d1.add(0.0D, (d3 - vec3d1.y) * d4, 0.0D));
                        }


                        /*double swimSpeedX = 1.04D;
                        double swimSpeedY = 1.04D;
                        double swimSpeedZ = 1.04D;

                        swimmingPlayer.setMotion(swimSpeedX, swimSpeedY, swimSpeedZ);*/
                    /*}
                    else swimmingPlayer.setMotion(vec3d.x, vec3d.y, vec3d.z);
                }
                else if (itemSwimBoots.getItem() instanceof FinsItem && swimmingPlayer.getMotion().y < -0.75d)
                {
                    swimmingPlayer.setMotion(1D, 1.25D, 1D);
                }
            }
        }
    }*/

    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public static void fogDensityEvent(EntityViewRenderEvent.FogDensity event)
    {
        PlayerEntity swimmingPlayer = Minecraft.getInstance().player;
        ItemStack snorkelMask = swimmingPlayer.getItemStackFromSlot(EquipmentSlotType.HEAD);

        //float startingDensity = event.getDensity();  //Check density values of different locations

        if (snorkelMask != null && snorkelMask.getItem() instanceof IMasksItem) { //TODO Update instanceof with new Interface
            if (swimmingPlayer.areEyesInFluid(FluidTags.WATER)) {
                event.setDensity(1.0F); //0.04999028 Vanilla Value
            } else {
                event.setCanceled(false);
                return;
            }
            event.setCanceled(true); // must cancel event for event handler to take effect
        }
    }

    /*private void updateSnorkel(TickEvent.PlayerTickEvent player) {
        //PlayerEntity swimmingPlayer = player;
        ItemStack itemSnorkel = swimmingPlayer.getItemStackFromSlot(EquipmentSlotType.HEAD);
        if (itemSnorkel.getItem() instanceof IMasksItem && ((IMasksItem)itemSnorkel.getItem()).isSnorkel(swimmingPlayer, itemSnorkel)) {
            if(swimmingPlayer.areEyesInFluid(FluidTags.WATER)) {
                swimmingPlayer.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 200, 0, false, false, true));
            }
        }

    }*/
}
