package com.cscot.scubasteve.client.renderer.entity.models;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;

public class FinsModel<T extends LivingEntity> extends BipedModel
{
    public static final FinsModel INSTANCE = new FinsModel();

    RendererModel rightFin;
    RendererModel leftFin;

    public FinsModel()
    {
        super(1.0F, 0, 64, 32);

        this.bipedHead.showModel = false;
        this.bipedRightArm.showModel = false;
        this.bipedLeftArm.showModel = false;
        this.bipedBody.showModel = false;
        this.bipedHeadwear.showModel = false;
        this.bipedRightLeg.showModel = true;
        this.bipedLeftLeg.showModel = true;

        rightFin = new RendererModel(this, 40, 0);
        rightFin.addBox(-3.25F, 11.75F, -7F, 5, 1, 7, 0.25F);
        rightFin.setRotationPoint(0F, 0F, 0F);
        rightFin.setTextureSize(64, 32);
        rightFin.mirror = true;
        setRotation(rightFin, 0F, 0F, 0F);

        leftFin = new RendererModel(this, 40, 0);
        leftFin.addBox(-1.75F, 11.75F, -7F, 5, 1, 7, 0.25F);
        leftFin.setRotationPoint(0F, 0F, 0F);
        leftFin.setTextureSize(64, 32);
        leftFin.mirror = false;
        setRotation(leftFin, 0F, 0F, 0F);

        this.bipedRightLeg.addChild(rightFin);
        this.bipedLeftLeg.addChild(leftFin);
    }

    public void render(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); //render
        setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); //setRotationAngle
    }

    private void setRotation(RendererModel model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
