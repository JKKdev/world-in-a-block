package com.github.jkkdev.wiab.gen.biome;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.biome.BiomeGenBase;

public class ModBiomeGen {
    
    public static final BiomeGenBase TALL_FOREST = (new TallForest(BiomeIds.TALL_FOREST)).
            setBiomeName("Tall Forest").
            setColor(100000).
            setMinMaxHeight(-2.0F, 2.0F).
            setTemperatureRainfall(1.5F, 0.5F);

    public static void init(){
       
        GameRegistry.addBiome(TALL_FOREST);
    }
    
}
