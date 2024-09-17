/**
 * File created on 13:15 23.07.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.block;

import net.minecraft.block.BlockCompressed;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import ru.wertyfiregames.wertyfirecore.context.ModContext;

/**
 * Wrapper for compressed blocks (like iron block from iron ingots).
 * @since 1.0.0
 * @author Wertyfire
 * */
public class CompressedBlock extends BlockCompressed {
    /**
     * Current resource context.
     * @since 1.0.1
     * */
    protected final String context;

    /**
     * Constructor requires MapColor instead of Material and no tooltype.
     * Material is iron, tooltype is pickaxe.
     * @param mapColor map color for this block.
     * @since 1.0.0
     * */
    public CompressedBlock(MapColor mapColor, String name, String textureName, CreativeTabs creativeTab, int level, float hardness, float resistance) {
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
     * Same as {@linkplain #CompressedBlock(MapColor, String, String, CreativeTabs, int, float, float)} but with nameAll param.
     * @since 1.0.0
     * */
    public CompressedBlock(MapColor mapColor, String nameAll, CreativeTabs creativeTab, int level, float hardness, float resistance) {
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