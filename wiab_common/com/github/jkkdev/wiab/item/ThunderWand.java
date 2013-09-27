package com.github.jkkdev.wiab.item;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ThunderWand extends ItemWIAB{

    public ThunderWand(int par1) {
        super(par1);
        this.setUnlocalizedName("thunderWand");        
    }
    
    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        EntityLightningBolt bolt = new EntityLightningBolt(par3World, par4, par5, par6);
        par3World.spawnEntityInWorld(bolt);
        return true;
    }
    
    @Override
    public String getItemDisplayName(ItemStack itemStack) {

        return EnumChatFormatting.YELLOW + super.getItemDisplayName(itemStack);
    }

}
