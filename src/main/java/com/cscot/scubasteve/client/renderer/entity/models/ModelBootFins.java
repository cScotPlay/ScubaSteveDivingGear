package com.cscot.scubasteve.client.renderer.entity.models;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class ModelBootFins extends BipedModel
{
    public static final ModelBootFins INSTANCE = new ModelBootFins();

    RendererModel rightBootFin;
    RendererModel leftBootFin;

    public ModelBootFins()
    {
        super(1.0F, 0, 64, 32);

        this.field_78115_e.showModel = false;
        this.bipedRightArm.showModel = false;
        this.bipedLeftArm.showModel = false;
        this.field_78116_c.showModel = false;
        this.bipedHeadwear.showModel = false;
        this.bipedRightLeg.showModel = true;
        this.bipedLeftLeg.showModel = true;

        rightBootFin = new RendererModel(this, 40, 0);
        rightBootFin.addBox(-3.25F, 11.75F, -7F, 5, 1, 7, 0.25F);
        rightBootFin.setRotationPoint(0F, 0F, 0F);
        rightBootFin.setTextureSize(64, 32);
        rightBootFin.mirror = true;
        setRotation(rightBootFin, 0F, 0F, 0F);

        leftBootFin = new RendererModel(this, 40, 0);
        leftBootFin.addBox(-1.75F, 11.75F, -7F, 5, 1, 7, 0.25F);
        leftBootFin.setRotationPoint(0F, 0F, 0F);
        leftBootFin.setTextureSize(64, 32);
        leftBootFin.mirror = false;
        setRotation(leftBootFin, 0F, 0F, 0F);

        this.bipedRightLeg.addChild(rightBootFin);
        this.bipedLeftLeg.addChild(leftBootFin);
    }

    public void render(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    private void setRotation(RendererModel model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
