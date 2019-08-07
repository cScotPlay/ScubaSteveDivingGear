package com.cscot.scubasteve.event.entity.living;

import com.cscot.scubasteve.objects.items.IMasksItem;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.opengl.GL11;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber
public class ScubaLivingEvent
{
    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public static void fogDensityEvent(EntityViewRenderEvent.FogDensity event) {
        PlayerEntity swimmingPlayer = Minecraft.getInstance().player;
        ItemStack snorkelMask = swimmingPlayer.getItemStackFromSlot(EquipmentSlotType.HEAD);

        if (snorkelMask.getItem() instanceof IMasksItem && ((IMasksItem) snorkelMask.getItem()).isMask(swimmingPlayer, snorkelMask)) {
            if (swimmingPlayer.areEyesInFluid(FluidTags.WATER)) {
                GlStateManager.fogMode(GlStateManager.FogMode.LINEAR);
                GL11.glFogf(GL11.GL_FOG_DENSITY, 0.015f);
            }
           //TODO Look at Fog Start and End
        }
    }
}
