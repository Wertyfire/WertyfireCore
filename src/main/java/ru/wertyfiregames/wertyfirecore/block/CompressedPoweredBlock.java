/**
 * File created on 13:23 23.07.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.block;

import net.minecraft.block.BlockCompressedPowered;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import ru.wertyfiregames.wertyfirecore.context.ModContext;

/**
 * Wrapper for compressed blocks that emits redstone signal (like redstone block).
 * @since 1.0.0
 * @author Wertyfire
 * */
public class CompressedPoweredBlock extends BlockCompressedPowered {
    /**
     * Current resource context.
     * @since 1.0.1
     * */
    protected final String context;

    /**
     * @see CompressedPoweredBlock#CompressedPoweredBlock(MapColor, String, String, CreativeTabs, int, float, float)
     * @since 1.0.0
     * */
    public CompressedPoweredBlock(MapColor mapColor, String name, String textureName, CreativeTabs creativeTab, int level, float hardness, float resistance) {
        super(mapColor);

        context = ModContext.getCurrentResourceContext();

        setBlockName(name);
        setBlockTextureName(context + ":" + textureName);
        setCreativeTab(creativeTab);
        setHarvestLevel("pickaxe", level);
        setHardness(hardness);
        setResistance(resistance);
    }
    /**
     * @see CompressedPoweredBlock#CompressedPoweredBlock(MapColor, String, CreativeTabs, int, float, float)
     * @since 1.0.0
     * */
    public CompressedPoweredBlock(MapColor mapColor, String nameAll, CreativeTabs creativeTab, int level, float hardness, float resistance) {
        this(mapColor, nameAll, nameAll, creativeTab, level, hardness, resistance);
    }

    /**
     * Get resource context used in this block.
     * @return resource context of this block.
     * @since 1.0.1
     * */
    public String getBlockContext() {
        return context;
    }
}