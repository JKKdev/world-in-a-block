package com.github.jkkdev.wiab.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;

public class SoulCrystal extends ItemWIAB{
    
    public SoulCrystal(int par1) {
        super(par1);
        this.setUnlocalizedName("soulCrystal");   
    }
        
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack is, EntityPlayer ep, List l, boolean b) {         
                
        NBTTagList lore = is.stackTagCompound.getTagList("Lore");
        
        System.out.println("" + lore.tagCount());  //returns 1
        
        for(int i=0; i<lore.tagCount(); i++){
           l.add(((NBTTagString)lore.tagAt(i)).data); //returns/shows only Strong
        }              
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)//Gives Item initial NBT tag
    {
        ItemStack is = new ItemStack(par1, 1, 0);
        
        NBTTagList list = new NBTTagList();
        list.appendTag(new NBTTagString("Line 99", "Strong"));
        
        is.setTagCompound(new NBTTagCompound("display"));
        is.stackTagCompound.setTag("Lore", list);
        
        par3List.add(is);// Creative inventory displays the NBT tag which is added here aka. addInformation works
    }

    @SideOnly(Side.CLIENT)
    public boolean itemInteractionForEntity(ItemStack is, EntityLiving el)//When ItemStack interacts with Entity it adds a NBT tag with the name of entity
    {
        if (el.worldObj.isRemote)
        {
            return false;
        }       
        
        NBTTagList lore = is.stackTagCompound.getTagList("Lore");
        
        lore.appendTag(new NBTTagString("Line " + lore.tagCount(), el.getEntityName()));
                
        is.stackTagCompound.removeTag("Lore");
        is.stackTagCompound.setTag("Lore", lore);
        
        NBTTagList lore1 = is.stackTagCompound.getTagList("Lore");// I know this is not needed
        
        for(int i=0; i<lore1.tagCount(); i++){
            System.out.println(((NBTTagString)lore1.tagAt(i)).data); //returns Strong and entity name
        }
                
        System.out.println("" + lore1.tagCount());       //returns 2    
        return true;
    }
    
    //Problem is that when you interact with an entity it returns 2 tags but addInformation returns only 1 even after you interact. 
    //It is as if the ItemStack from Interact isn't the same as the one in the addInfo.
    
}