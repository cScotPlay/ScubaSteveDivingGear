package com.cscot.scubasteve.objects.items;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;

public class TankItem extends ArmorItem
{
    protected final String name;
    protected final IArmorMaterial material;
    protected final EquipmentSlotType armorSlot;
    protected final Boolean maskCheck;
    protected final Boolean snorkelCheck;

    public TankItem(String nameIn, IArmorMaterial materialIn, EquipmentSlotType slot, Boolean isMask, Boolean isSnorkel, Item.Properties builder) {
        super(materialIn, slot, builder);
        name = nameIn;
        material = materialIn;
        armorSlot = slot;
        maskCheck = isMask;
        snorkelCheck = isSnorkel;
    }
}
