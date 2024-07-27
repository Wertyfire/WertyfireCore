/**
 * File created on 16:19 22.07.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import ru.wertyfiregames.wertyfirecore.context.ModContext;

/**
 * Improved block class. Now you should enter all main params in constructor instead of writing setParamName("ParamName") many times.
 * @since 1.0.0
 * @author Wertyfire
 * */
public class DefaultBlock extends Block {
    /**
     * Current resource context.
     * @since 1.0.0
     * */
    protected final String context;

    /**
     * Default constructor.
     * @param material material of block.
     * @param name unlocalizaed name of block.
     * @param textureName name of texture (using {@linkplain ModContext#getCurrentResourceContext()}).
     * @param creativeTab creative tab for block.
     * @param tooltype type of tool to mine this block.
     * @param level level of tool {@code tooltype}.
     * @param hardness hardness of block (how many times player should hit block to break it).
     * @param resistance resistance of block.
     * @since 1.0.0
     * */
    public DefaultBlock(Material material, String name, String textureName, CreativeTabs creativeTab, String tooltype, int level, float hardness, float resistance) {
        super(material);

        context = ModContext.getCurrentResourceContext();

        setBlockName(name);
        setBlockTextureName(context + ":" + textureName);
        setCreativeTab(creativeTab);
        setHarvestLevel(tooltype, level);
        setHardness(hardness);
        setResistance(resistance);
    }
    /**
     * Default constructor.
     * @param material material of block.
     * @param nameAll name for unlocalized name and texture.
     * @param creativeTab creative tab for block.
     * @param tooltype type of tool to mine this block.
     * @param level level of tool {@code tooltype}.
     * @param hardness hardness of block (how many times player should hit block to break it).
     * @param resistance resistance of block.
     * @since 1.0.0
     * @apiNote minecraft's texture name format is "this_case" but translation keys format is "camelCase" so if you have only 1 word in name id you can use this constructor.
     * */
    public DefaultBlock(Material material, String nameAll, CreativeTabs creativeTab, String tooltype, int level, float hardness, float resistance) {
        this(material, nameAll, nameAll, creativeTab, tooltype, level, hardness, resistance);
    }

    /**
     * Get resource context used in this block.
     * @return resource context of this block.
     * @since 1.0.0
     * */
    public String getBlockContext() {
        return context;
    }
}