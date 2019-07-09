package com.cscot.scubasteve.client.renderer.entity.models;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;

import javax.annotation.Nonnull;

public class FinsModel extends BipedModel
{
    public static final FinsModel INSTANCE = new FinsModel();

    private final RendererModel rightFin;
    private final RendererModel leftFin;

    public FinsModel()
    {
        super(1.0F, 0, 64, 32);

        rightFin = new RendererModel(this, 40, 0);
        rightFin.setRotationPoint(0F, 0F, 0F);
        rightFin.addBox(-3.25F, 11.75F, -7F, 5, 1, 7, 0.25F);

        leftFin = new RendererModel(this, 40, 0);
        leftFin.setRotationPoint(0F, 0F, 0F);
        leftFin.addBox(-1.75F, 11.75F, -7F, 5, 1, 7, 0.25F);

        this.bipedRightLeg.addChild(rightFin);
        this.bipedLeftLeg.addChild(leftFin);
    }

    public void render(@Nonnull LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); //render
        setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); //setRotationAngle
    }
}
