/**
 * File created on 13:23 23.07.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.block;

import net.minecraft.block.BlockCompressedPowered;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Wrapper for compressed blocks that emits redstone signal (like redstone block).
 * @since 1.0.0
 * @author Wertyfire
 * */
public class CompressedPoweredBlock extends BlockCompressedPowered {
    /**
     * @see CompressedBlock#CompressedBlock(MapColor, String, String, CreativeTabs, int, float, float)
     * @since 1.0.0
     * */
    public CompressedPoweredBlock(MapColor mapColor, String name, String textureName, CreativeTabs creativeTab, int level, float hardness, float resistance) {
        super(mapColor);
        setBlockName(name);
        setBlockTextureName(textureName);
        setCreativeTab(creativeTab);
        setHarvestLevel("pickaxe", level);
        setHardness(hardness);
        setResistance(resistance);
    }
    /**
     * @see CompressedBlock#CompressedBlock(MapColor, String, CreativeTabs, int, float, float)
     * @since 1.0.0
     * */
    public CompressedPoweredBlock(MapColor mapColor, String nameAll, CreativeTabs creativeTab, int level, float hardness, float resistance) {
        this(mapColor, nameAll, nameAll, creativeTab, level, hardness, resistance);
    }
}