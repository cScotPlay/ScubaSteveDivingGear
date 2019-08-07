package com.cscot.scubasteve.client.gui;

import com.cscot.scubasteve.ScubaSteve;
import com.cscot.scubasteve.init.WetsuitInit;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class GoggleIngameGui
{
    private final Minecraft mc = Minecraft.getInstance();
    protected static final ResourceLocation GOGGLE_BLUR_TEX_PATH = new ResourceLocation(ScubaSteve.MODID, "textures/misc/goggleblur.png");
    protected int scaledWidth;
    protected int scaledHeight;

    public GoggleIngameGui(){

    }

    @SuppressWarnings("unused")
    @SubscribeEvent(priority = EventPriority.LOW)
    public void renderGoggleMask(RenderGameOverlayEvent.Pre event)
    {
        Entity renderViewEntity = mc.getRenderViewEntity();
        PlayerEntity swimmingPlayer = Minecraft.getInstance().player;
        ItemStack snorkelMask = swimmingPlayer.getItemStackFromSlot(EquipmentSlotType.HEAD);

        if (event.getType() != RenderGameOverlayEvent.ElementType.HELMET
            || snorkelMask.getItem() != WetsuitInit.snorkel_goggles
            || !(this.mc.gameSettings.thirdPersonView == 0)
            || event.isCanceled()
            || !(renderViewEntity instanceof PlayerEntity)) return;
            event.setCanceled(true);
            this.scaledWidth = mc.mainWindow.getScaledWidth();
            this.scaledHeight = mc.mainWindow.getScaledHeight();

            mc.getProfiler().startSection("goggle");
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();

            this.mc.getTextureManager().bindTexture(GOGGLE_BLUR_TEX_PATH);
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
            bufferbuilder.pos(0.0D, (double) this.scaledHeight, -90.0D).tex(0.0D, 1.0D).endVertex();
            bufferbuilder.pos((double) this.scaledWidth, (double) this.scaledHeight, -90.0D).tex(1.0D, 1.0D).endVertex();
            bufferbuilder.pos((double) this.scaledWidth, 0.0D, -90.0D).tex(1.0D, 0.0D).endVertex();
            bufferbuilder.pos(0.0D, 0.0D, -90.0D).tex(0.0D, 0.0D).endVertex();
            tessellator.draw();

            GlStateManager.disableBlend();
            //Revert our state back
            GlStateManager.popMatrix();
            mc.getProfiler().endSection();
            event.setCanceled(true);
    }
}