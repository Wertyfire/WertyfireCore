/**
 * File created on 15:59 22.07.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import ru.wertyfiregames.wertyfirecore.context.IMod;
import ru.wertyfiregames.wertyfirecore.util.RGBA;
import ru.wertyfiregames.wertyfirecore.util.Version;

@Mod(modid = WertyfireCoreMod.MOD_ID, name = WertyfireCoreMod.NAME, version = WertyfireCoreMod.VERSION)
public class WertyfireCoreMod implements IMod {
    protected static final String MOD_ID = "wertyfirecore";
    protected static final String NAME = "Wertyfire Core";
    protected static final String VERSION = Version.CORE_VERSION;
    protected static final String buildNum = "03";

    @Instance
    public static WertyfireCoreMod INSTANCE;
    @Metadata
    public static ModMetadata METADATA;

    private static Logger modLogger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        modLogger = event.getModLog();
        getModLogger().debug("Wertyfire Core: logger loaded");
    }

    public static String getModId() {
        return MOD_ID;
    }
    public static String getName() {
        return NAME;
    }
    public static String getVersion() {
        return VERSION;
    }
    public static String getBuildNum() {
        return buildNum;
    }

    public static Logger getModLogger() {
        return modLogger;
    }
}