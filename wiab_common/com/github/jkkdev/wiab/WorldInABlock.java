package com.github.jkkdev.wiab;

import net.minecraft.creativetab.CreativeTabs;

import com.github.jkkdev.wiab.core.handler.CommandHandler;
import com.github.jkkdev.wiab.core.handler.LocalizationHandler;
import com.github.jkkdev.wiab.core.proxy.CommonProxy;
import com.github.jkkdev.wiab.creativetab.CreativeTab;
import com.github.jkkdev.wiab.gen.biome.ModBiomeGen;
import com.github.jkkdev.wiab.item.ModItems;
import com.github.jkkdev.wiab.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod( modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class WorldInABlock {

    @Instance(Reference.MOD_ID)
    public static WorldInABlock wiab;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;    
    
    public static CreativeTabs wiabTab = new CreativeTab(CreativeTabs.getNextID(), Reference.MOD_ID);
    
    @ServerStarting
    public void serverStarting(FMLServerStartingEvent event) {

        CommandHandler.initCommands(event);
    }
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event){
        LocalizationHandler.loadLanguages();
        ModItems.init();
        ModBiomeGen.init();
    }
    
    @Init
    public void load(FMLInitializationEvent event){
        
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event){
        
    }
    
}
