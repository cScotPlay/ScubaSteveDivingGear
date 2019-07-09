package com.cscot.scubasteve.client.renderer.entity.models;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;
import javax.annotation.Nonnull;

public class SnorkelModel extends BipedModel
{
    public static final SnorkelModel INSTANCE = new SnorkelModel();

    private final RendererModel snorkelMouthPiece;
    private final RendererModel snorkelFront;
    private final RendererModel snorkelSide;
    private final RendererModel snorkelVert;

    public SnorkelModel(){

        super(1.0F, 0, 64, 32);

        snorkelMouthPiece = new RendererModel(this, 0, 0);
        snorkelMouthPiece.setRotationPoint(0,0,0);
        snorkelMouthPiece.addBox(-1.0F, -3.0F, -5.0F, 2, 2, 1, 0.0F);

        snorkelFront = new RendererModel(this, 32, 0);
        snorkelFront.setRotationPoint(0,0,0);
        snorkelFront.addBox(1.0F, -2.0F, -5.0F, 4, 1, 1, 0.0F);

        snorkelSide = new RendererModel(this, 32, 2);
        snorkelSide.setRotationPoint(0,0,0);
        snorkelSide.addBox(4.0F, -2.0F, -4.0F, 1, 1, 5, 0.0F);

        snorkelVert = new RendererModel(this, 44, 0);
        snorkelVert.setRotationPoint(0,0,0);
        snorkelVert.addBox(4.0F, -10.0F, 0.0F, 1, 8, 1, 0.0F);

        this.snorkelMouthPiece.addChild(snorkelFront);
        this.snorkelMouthPiece.addChild(snorkelSide);
        this.snorkelMouthPiece.addChild(snorkelVert);
    }

    @Override
    public void render(@Nonnull LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        snorkelMouthPiece.showModel = true;
        bipedHeadwear = snorkelMouthPiece;

        super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }
}
