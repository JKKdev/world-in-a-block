package com.github.jkkdev.wiab.item;

import com.github.jkkdev.wiab.WorldInABlock;

import net.minecraft.item.Item;

public class ItemWIAB extends Item{

    public ItemWIAB(int par1) {
        super(par1-256);
        this.setMaxStackSize(1);
        this.setNoRepair();
        this.setCreativeTab(WorldInABlock.wiabTab);
    }

}
