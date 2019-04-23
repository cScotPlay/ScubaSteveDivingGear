package com.cscot.scubasteve.client.renderer.entity.models;

import net.minecraft.client.renderer.entity.model.ModelBiped;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBootFins extends ModelBiped
{
    public static final ModelBootFins INSTANCE = new ModelBootFins();

    ModelRenderer rightBootFin;
    ModelRenderer leftBootFin;

    public ModelBootFins()
    {
        super(1.0F, 0, 64, 32);

        this.bipedBody.showModel = false;
        this.bipedRightArm.showModel = false;
        this.bipedLeftArm.showModel = false;
        this.bipedHead.showModel = false;
        this.bipedHeadwear.showModel = false;
        this.bipedRightLeg.showModel = true;
        this.bipedLeftLeg.showModel = true;

        rightBootFin = new ModelRenderer(this, 40, 0);
        rightBootFin.addBox(-3.25F, 11.75F, -7F, 5, 1, 7, 0.25F);
        rightBootFin.setRotationPoint(0F, 0F, 0F);
        rightBootFin.setTextureSize(64, 32);
        rightBootFin.mirror = true;
        setRotation(rightBootFin, 0F, 0F, 0F);

        leftBootFin = new ModelRenderer(this, 40, 0);
        leftBootFin.addBox(-1.75F, 11.75F, -7F, 5, 1, 7, 0.25F);
        leftBootFin.setRotationPoint(0F, 0F, 0F);
        leftBootFin.setTextureSize(64, 32);
        leftBootFin.mirror = false;
        setRotation(leftBootFin, 0F, 0F, 0F);

        this.bipedRightLeg.addChild(rightBootFin);
        this.bipedLeftLeg.addChild(leftBootFin);
    }

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
