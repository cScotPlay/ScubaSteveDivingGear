package com.cscot.scubasteve.objects.items;

import com.cscot.scubasteve.ScubaSteve;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.SoundEvent;

import java.util.function.Supplier;

public enum ItemWetsuitMaterial implements IArmorMaterial
{
    wetsuit("wetsuit", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, () -> {
        return Ingredient.fromItems(Items.LEATHER);
    }),
    noarmor("noArmor", 0, new int[] {0, 0, 0, 0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, () -> {
        return Ingredient.fromItems(Items.LEATHER);
    });

    private static int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private String name;
    private SoundEvent soundEvent;
    private int maxDamageFactor, enchantability;
    private int[] damageReductionAmount;
    private float toughness;
    private LazyLoadBase<Ingredient> repairMaterial;

    ItemWetsuitMaterial(String nameIn, int durability, int[] damageReductionAmount, int enchantability, SoundEvent equipSound, float toughness, Supplier<Ingredient> repairItem)
    {
        this.name = nameIn;
        this.maxDamageFactor = durability;
        this.damageReductionAmount = damageReductionAmount;
        this.enchantability = enchantability;
        this.soundEvent = equipSound;
        this.toughness = toughness;
        this.repairMaterial = new LazyLoadBase<>(repairItem);
    }

    @Override
    public int getDurability(EntityEquipmentSlot slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EntityEquipmentSlot slotIn) {
        return this.damageReductionAmount[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    @Override
    public String getName() {
        return ScubaSteve.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}
