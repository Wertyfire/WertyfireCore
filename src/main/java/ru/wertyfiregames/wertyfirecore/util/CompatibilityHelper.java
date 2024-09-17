/**
 * File created on 19:38 23.07.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.util;

import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

/**
 * Class for compatibility utils.
 * @since 1.0.0
 * @author Wertyfire
 * */
public class CompatibilityHelper {
    /**Don't let anyone instantiate this class.*/
    private CompatibilityHelper() {}

    /**
     * Get item by domain and id.
     * @return item from mod {@code domain} and with id {@code id}.
     * @param domain id of mod where item from.
     * @param id item id.
     * @since 1.0.0
     * @see #getItem(String)
     * */
    public static Item getItem(String domain, String id) {
        return getItem(domain + ":" + id);
    }
    /**
     * Get item by path.
     * @return item with id {@code path}.
     * @param path full id of item (like this: "my_super_sus_mod:super_sus_item").
     * @since 1.0.0
     * */
    public static Item getItem(String path) {
        return (Item) Item.itemRegistry.getObject(path);
    }

    /**
     * Get block by domain and id.
     * @return block from mod {@code domain} and with id {@code id}.
     * @param domain id of mod where block from.
     * @param id block id.
     * @since 1.0.0
     * @see #getBlock(String)
     * */
    public static Block getBlock(String domain, String id) {
        return getBlock(domain + ":" + id);
    }
    /**
     * Get block by path.
     * @return block with id {@code path}.
     * @param path full id of block (like this: "my_super_sus_mod:super_sus_block").
     * @since 1.0.0
     * */
    public static Block getBlock(String path) {
        return (Block) Block.blockRegistry.getObject(path);
    }

    /**
     * Check if the mod loaded.
     * @return if mod is loaded.
     * @param modid mod id.
     * @since 1.0.0
     * */
    public static boolean isModLoaded(String modid) {
        return Loader.isModLoaded(modid);
    }
}