/**
 * File created on 23:05 22.07.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ru.wertyfiregames.wertyfirecore.context.ModContext;

/**
 * Improved item class. Now you should only enter all main params in constructor instead of writing setParamName("ParamName") many times.
 * @since 1.0.0
 * @author Wertyfire
 * */
public class DefaultItem extends Item {
    /**
     * Current resource context.
     * @since 1.0.0
     * */
    protected final String context;

    /**
     * Default constructor.
     * @param name unlocalized name of item.
     * @param textureName name of texture (using {@linkplain ModContext#getCurrentResourceContext()} so don't forget to set it).
     * @param creativeTab creative tab for item.
     * @since 1.0.0
     * @apiNote this constructor used if your id contains more than 1 word.
     * */
    public DefaultItem(String name, String textureName, CreativeTabs creativeTab) {
        context = ModContext.getCurrentModContext();

        setUnlocalizedName(name);
        setTextureName(context + ":" + textureName);
        setCreativeTab(creativeTab);
    }
    /**
     * Default constructor.
     * @param nameAll name for unlocalized name and texture.
     * @param creativeTab creative tab for item.
     * @since 1.0.0
     * @apiNote minecraft's texture name format is "this_case" but translation keys format is "camelCase" so if you have only 1 word in name id you can use this constructor.
     * */
    public DefaultItem(String nameAll, CreativeTabs creativeTab) {
        this(nameAll, nameAll, creativeTab);
    }

    /**
     * Get resource context used in this item.
     * @return resource context of this item.
     * @since 1.0.0
     * */
    public String getContext() {
        return context;
    }
}