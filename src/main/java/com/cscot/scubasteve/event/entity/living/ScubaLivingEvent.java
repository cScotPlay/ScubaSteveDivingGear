package com.cscot.scubasteve.event.entity.living;

import com.cscot.scubasteve.ScubaSteve;
import com.cscot.scubasteve.init.WetsuitInit;
import com.cscot.scubasteve.objects.items.FinsItem;
import com.cscot.scubasteve.objects.items.IFinsItem;
import com.cscot.scubasteve.objects.items.IMasksItem;
import com.cscot.scubasteve.objects.items.MaskItem;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.IFluidState;
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
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.opengl.GL11;

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
