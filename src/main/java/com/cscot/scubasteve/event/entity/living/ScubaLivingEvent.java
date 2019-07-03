package com.cscot.scubasteve.event.entity.living;

import com.cscot.scubasteve.init.WetsuitInit;
import com.cscot.scubasteve.objects.items.FinsItem;
import com.cscot.scubasteve.objects.items.IFinsItem;
import com.cscot.scubasteve.objects.items.IMasksItem;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ScubaLivingEvent
{
    @SubscribeEvent (priority = EventPriority.NORMAL, receiveCanceled = true)
    public static void LivingUpdateEvent(LivingEvent.LivingUpdateEvent swimEvent)
    {
        if (swimEvent.getEntity() != null && swimEvent.getEntity() instanceof PlayerEntity)
        {
            PlayerEntity swimmingPlayer = (PlayerEntity) swimEvent.getEntity();
            ItemStack itemSwimBoots = swimmingPlayer.getItemStackFromSlot(EquipmentSlotType.FEET);

            if (swimmingPlayer.isSwimming()){
                if (itemSwimBoots.getItem() instanceof IFinsItem && ((IFinsItem)itemSwimBoots.getItem()).areFins(swimmingPlayer, itemSwimBoots)) {
                    Vec3d vec3d = swimmingPlayer.getMotion();
                    if (swimmingPlayer.isInWater())
                    {
                        double swimSpeedX = vec3d.x *1.04D;
                        double swimSpeedY = vec3d.y *1.04D;
                        double swimSpeedZ = vec3d.z *1.04D;

                        swimmingPlayer.setMotion(swimSpeedX, swimSpeedY, swimSpeedZ);
                    }
                    else swimmingPlayer.setMotion(vec3d.x, vec3d.y, vec3d.z);
                }
                else if (itemSwimBoots.getItem() instanceof FinsItem && swimmingPlayer.getMotion().y < -0.75d)
                {
                    swimmingPlayer.setMotion(1D, 1.25D, 1D);
                }
            }
        }
    }

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
}
