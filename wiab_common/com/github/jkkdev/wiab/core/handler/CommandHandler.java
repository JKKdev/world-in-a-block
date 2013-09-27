package com.github.jkkdev.wiab.core.handler;

import com.github.jkkdev.wiab.core.util.CommandClearBiome;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommandHandler {

    
    public static void initCommands(FMLServerStartingEvent event) {

        event.registerServerCommand(new CommandClearBiome());
    }
    
}
