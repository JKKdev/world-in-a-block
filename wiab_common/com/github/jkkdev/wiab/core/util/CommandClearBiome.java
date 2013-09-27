package com.github.jkkdev.wiab.core.util;

import java.util.ArrayList;

import com.github.jkkdev.wiab.gen.biome.BiomeIds;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

public class CommandClearBiome extends CommandBase{

    @Override
    public int getRequiredPermissionLevel()
    {
        return 2;
    }
    
    @Override
    public String getCommandName() {
        return "clearbiome";
    }

    @Override
    public void processCommand(ICommandSender icommandsender, String[] astring) {
        
        ArrayList<ChunkCoordinates> ccListsb = new ArrayList<ChunkCoordinates>();
        ArrayList<ChunkCoordinates> ccListdb = new ArrayList<ChunkCoordinates>();
        boolean sameBiome;
        int offset = 1;        
        ChunkCoordinates cc = icommandsender.getPlayerCoordinates();
        EntityPlayerMP player = getCommandSenderAsPlayer(icommandsender);
        
        World w = player.worldObj;
        BiomeGenBase bg = w.getBiomeGenForCoords(cc.posX, cc.posZ);
        
        sameBiome = true;
        
        int olddb, newdb;
        
        newdb = 0;
        
        while(sameBiome == true){
            
            
            olddb = newdb;
            
            for(int i=-offset;i<=offset;i++){
                for(int j=-offset;j<=offset;j++){                    
                    if(w.getBiomeGenForCoords(cc.posX+i, cc.posZ+j) == bg){
                        ccListsb.add(new ChunkCoordinates(cc.posX+i, 0, cc.posZ+j));
                    }
                    else{
                        ccListdb.add(new ChunkCoordinates(cc.posX+i, 0, cc.posZ+j));
                    }
                }
            }                       
            
            newdb = ccListdb.size();           
            
            if((newdb-olddb>= offset*8 || offset == 512)){
                System.out.println(""+ccListsb.size());
                sameBiome = false;
            }else{
                ccListdb.clear();
                ccListsb.clear();
            }
                       
            offset++;        
        }       
        
        
        
        for(int j=0;j<ccListsb.size();j++){
            for(int i=0;i<256;i++){
                if(w.blockExists(ccListsb.get(j).posX, i, ccListsb.get(j).posZ))
                w.destroyBlock(ccListsb.get(j).posX, i, ccListsb.get(j).posZ, false);
                
            }
        }     
        
        System.out.println("Done");
    }

    @Override
    public String getCommandUsage(ICommandSender icommandsender) {
        // TODO Auto-generated method stub
        return null;
    }

}
