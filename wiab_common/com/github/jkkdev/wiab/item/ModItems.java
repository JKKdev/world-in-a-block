package com.github.jkkdev.wiab.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItems {
    
    public static Item thunderWand;
    public static Item soullessCrystal;
    public static Item soulCrystal;
    public static Item poweredSoulCrystal;
    public static Item radiantSoulCrystal;
    
    public static void init(){
        thunderWand = new ThunderWand(ItemIds.THUNDER_WAND);
        soullessCrystal = new SoullessCrystal(ItemIds.SOULLESS_CRYSTAL);
        soulCrystal = new SoulCrystal(ItemIds.SOUL_CRYSTAL);
        
        GameRegistry.addRecipe(new ItemStack(soullessCrystal), new Object[]{"qqq", "qnq", "qqq", 
            Character.valueOf('q'), Item.netherQuartz, Character.valueOf('n'), Item.netherStar});
        GameRegistry.addSmelting(ItemIds.SOULLESS_CRYSTAL, new ItemStack(soulCrystal), 0.0f);
    }

}
