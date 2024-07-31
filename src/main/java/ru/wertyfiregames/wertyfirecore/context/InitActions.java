/**
 * File created on 16:18 24.07.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.context;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLStateEvent;
import ru.wertyfiregames.wertyfirecore.WertyfireCoreMod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class provides preInit, init and postInit methods for your mod. If you used some features
 * that require registering with modid Wertyfire Core put registering to map.
 * @since 1.0.0
 * @author Wertyfire
 * @apiNote you should call these methods in appropriate methods in your main class.
 * */
public class InitActions {
    /**
     * Maps for initialization method. initMethods - for initialization methods,
     * initMethodsFML - for methods that require FMLInitializationEvent's.
     * @since 1.0.0
     * */
    private static final Map<String, List<MethodEntry>> preInitMethods = new HashMap<>(),
                                                        preInitMethodsFML = new HashMap<>(),
                                                        initMethods = new HashMap<>(),
                                                        initMethodsFML = new HashMap<>(),
                                                        postInitMethods = new HashMap<>(),
                                                        postInitMethodsFML = new HashMap<>();

    /**
     * Call all methods from maps {@linkplain #preInitMethods} and {@linkplain #preInitMethodsFML}.
     * @param modid your mod id.
     * @param event FMLPreInitializationEvent from your preInit.
     * @since 1.0.0
     * */
    public static void doPreInit(String modid, FMLPreInitializationEvent event) {
        List<MethodEntry> methods = preInitMethods.get(modid);
        if (methods != null) {
            for (MethodEntry method : methods) {
                method.execute();
            }
        }

        methods = preInitMethodsFML.get(modid);
        if (methods != null) {
            for (MethodEntry method : methods) {
                method.execute(event);
            }
        }
    }
    /**
     * Call all methods from maps {@linkplain #initMethods} and {@linkplain #initMethodsFML}.
     * @param modid your mod id.
     * @param event FMLInitializationEvent from your init.
     * @since 1.0.0
     * */
    public static void doInit(String modid, FMLInitializationEvent event) {
        List<MethodEntry> methods = initMethods.get(modid);
        if (methods != null) {
            for (MethodEntry method : methods) {
                method.execute();
            }
        }

        methods = initMethodsFML.get(modid);
        if (methods != null) {
            for (MethodEntry method : methods) {
                method.execute(event);
            }
        }
    }
    /**
     * Call all methods from maps {@linkplain #postInitMethods} and {@linkplain #postInitMethodsFML}.
     * @param modid your mod id.
     * @param event FMLPostInitializationEvent from your postInit.
     * @since 1.0.0
     * */
    public static void doPostInit(String modid, FMLPostInitializationEvent event) {
        List<MethodEntry> methods = postInitMethods.get(modid);
        if (methods != null) {
            for (MethodEntry method : methods) {
                method.execute();
            }
        }

        methods = postInitMethodsFML.get(modid);
        if (methods != null) {
            for (MethodEntry method : methods) {
                method.execute(event);
            }
        }
    }

    /**
     * Call all methods using mod id from {@linkplain ModContext#getCurrentModContext()}.
     * @param event FMLPreInitializationEvent from your preInit.
     * @since 1.0.0
     * */
    public static void doPreInit(FMLPreInitializationEvent event) {
        doPreInit(ModContext.getCurrentModContext(), event);
    }
    /**
     * Call all methods using mod id from {@linkplain ModContext#getCurrentModContext()}.
     * @param event FMLInitializationEvent from your init.
     * @since 1.0.0
     * */
    public static void doInit(FMLInitializationEvent event) {
        doInit(ModContext.getCurrentModContext(), event);
    }
    /**
     * Call all methods using mod id from {@linkplain ModContext#getCurrentModContext()}.
     * @param event FMLPostInitializationEvent from your postInit.
     * @since 1.0.0
     * */
    public static void doPostInit(FMLPostInitializationEvent event) {
        doPostInit(ModContext.getCurrentModContext(), event);
    }

    /**
     * Add method to initMap.
     * @param modid mod id.
     * @param initType type of initialization (0 - preInit, 1 - init, 2 - postInit).
     * @param target object.
     * @param method method to call.
     * @param params parameters for method.
     * @since 1.0.0
     * */
    public static void addInitializationMethod(String modid, int initType, Object target, Method method, Object[] params) {
        switch (initType) {
            case 0: preInitMethods.computeIfAbsent(modid, k -> new ArrayList<>()).add(new MethodEntry(target, method, params));
            case 1: initMethods.computeIfAbsent(modid, k -> new ArrayList<>()).add(new MethodEntry(target, method, params));
            case 2: postInitMethods.computeIfAbsent(modid, k -> new ArrayList<>()).add(new MethodEntry(target, method, params));
        }
    }

    /**
     * Add method to initMapFML.
     * @param modid mod id.
     * @param initType type of initialization (0 - preInit, 1 - init, 2 - postInit).
     * @param target object.
     * @param method method to call.
     * @param params parameters for method.
     * @since 1.0.0
     * @see #addInitializationMethod(String, int, Object, Method, Object[])
     * */
    public static void addInitializationFMLMethod(String modid, int initType, Object target, Method method, Object[] params) {
        switch (initType) {
            case 0: preInitMethodsFML.computeIfAbsent(modid, k -> new ArrayList<>()).add(new MethodEntry(target, method, params));
            case 1: initMethodsFML.computeIfAbsent(modid, k -> new ArrayList<>()).add(new MethodEntry(target, method, params));
            case 2: postInitMethodsFML.computeIfAbsent(modid, k -> new ArrayList<>()).add(new MethodEntry(target, method, params));
        }
    }

    /**
     * Class for storing info for calling method.
     * @author Wertyfire
     * @since 1.0.0
     * */
    private static class MethodEntry {
        /**
         * On which object call method.
         * @since 1.0.0
         * */
        private final Object target;
        /**
         * Method to call.
         * @since 1.0.0
         * */
        private final Method method;
        /**
         * Parameters for method.
         * @since 1.0.0
         * */
        private final Object[] params;

        /**
         * Default constructor.
         * @param target target.
         * @param method method.
         * @param params parameters.
         * @since 1.0.0
         * */
        public MethodEntry(Object target, Method method, Object[] params) {
            this.target = target;
            this.method = method;
            this.params = params;
        }

        /**
         * Execute method.
         * @since 1.0.0
         * */
        public void execute() {
            try {
                method.invoke(target, params);
            } catch (IllegalAccessException | InvocationTargetException e) {
                WertyfireCoreMod.getModLogger().error("Could not execute method {}. Error: {}", method, e.getMessage());
            }
        }
        /**
         * Execute method with additional param.
         * @param additionalParam additional param for method.
         * @since 1.0.0
         * */
        public void execute(Object additionalParam) {
            try {
                method.invoke(target, additionalParam, params);
            } catch (IllegalAccessException | InvocationTargetException e) {
                WertyfireCoreMod.getModLogger().error("Could not execute method {}. Error: {}", method.toString(), e.getMessage());
            }
        }
        /**
         * Execute method with additional params.
         * @param additionalParams object array with additional params.
         * @since 1.0.0
         * */
        public void execute(Object[] additionalParams) {
            try {
                method.invoke(target, additionalParams, params);
            } catch (IllegalAccessException | InvocationTargetException e) {
                WertyfireCoreMod.getModLogger().error("Could not execute method {}. Error: {}", method.toString(), e.getMessage());
            }
        }
    }
}