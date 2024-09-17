/**
 * File created on 17:41 22.07.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.context;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import ru.wertyfiregames.wertyfirecore.WertyfireCoreMod;

/**
 * Class for indicating current initializing mod.
 * @since 1.0.0
 * @author Wertyfire
 * */
public class ModContext {
    /**
     * Domain for current resource pack. Default is "minecraft".
     * @since 1.0.0
     * */
    private static String resourceContext = "minecraft";
    /**
     * Domain for current mod. Default is "minecraft".
     * @since 1.0.0
     * */
    private static String modContext = "minecraft";

    /**
     * Set mod and resource context to {@code modId}.
     * @param modId your mod id.
     * @since 1.0.0
     * */
    public static void setModContext(String modId) {
        modContext = modId;
        resourceContext = modId;
    }
    /**
     * Set mod and resource context to {@linkplain ModMetadata#modId} from {@code modMetadata}.
     * @param modMetadata metadata of your mod.
     * @since 1.0.0
     * @see ModMetadata
     * */
    public static void setModContext(ModMetadata modMetadata) {
        modContext = modMetadata.modId;
        resourceContext = modMetadata.modId;
    }
    /**
     * Get {@linkplain Mod @Mod} from {@linkplain IMod} implementer
     * and then set mod and resource context to modid from this annotation.<p>
     * If class haven't annotation @Mod, mod and resource context set to "minecraft"
     * @param modInstance instance of your mod.
     * @since 1.0.0
     * */
    public static void setModContext(IMod modInstance) {
        if (modInstance.getClass().isAnnotationPresent(Mod.class)) {
            Mod mod = modInstance.getClass().getAnnotation(Mod.class);
            modContext = mod.modid();
            resourceContext = mod.modid();
        } else {
            WertyfireCoreMod.getModLogger().warn("Wertyfire Core: attempt to set context on IMod implementer without annotation @Mod! Used default context (minecraft)!");
            modContext = "minecraft";
            resourceContext = "minecraft";
        }
    }

    /**
     * Set resource context to {@code modId}.
     * @param modId your mod id.
     * @since 1.0.0
     * @see #setModContext(String)
     * */
    public static void setResourceContext(String modId) {
        resourceContext = modId;
    }
    /**
     * Set resource context to {@linkplain ModMetadata#modId} from {@code modMetadata}.
     * @param modMetadata metadata of your mod.
     * @since 1.0.0
     * @see #setModContext(ModMetadata)
     * */
    public static void setResourceContext(ModMetadata modMetadata) {
        resourceContext = modMetadata.modId;
    }
    /**
     * Get {@linkplain Mod @Mod} from {@linkplain IMod} implementer
     * and then set resource context to modid from this annotation.<p>
     * If class haven't annotation @Mod, resource context set to "minecraft"
     * @param modInstance instance of your mod.
     * @since 1.0.0
     * @see #setModContext(IMod)
     * */
    public static void setResourceContext(IMod modInstance) {
        if (modInstance.getClass().isAnnotationPresent(Mod.class)) {
            Mod mod = modInstance.getClass().getAnnotation(Mod.class);
            resourceContext = mod.modid();
        } else {
            WertyfireCoreMod.getModLogger().warn("Wertyfire Core: attempt to set resource context on IMod implementer without annotation @Mod! Used default resource context (minecraft)");
        }
    }

    /**
     * Get current mod context.
     * @return current mod context.
     * @since 1.0.0
     * */
    public static String getCurrentModContext() {
        return modContext;
    }
    /**
     * Get current resource context.
     * @return current resource context.
     * @since 1.0.0
     * */
    public static String getCurrentResourceContext() {
        return resourceContext;
    }

    /**
     * Set mod and resource context to default ("minecraft").
     * @since 1.0.0
     * */
    public static void freeContext() {
        modContext = "minecraft";
        resourceContext = "minecraft";
    }
}