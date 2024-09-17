/**
    File created on 15:18 22.08.2024 by Wertyfire
*/

package ru.wertyfiregames.wertyfirecore.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;
import ru.wertyfiregames.wertyfirecore.WertyfireCoreMod;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for creating particles by name.
 * @since 1.0.2
 * @author Wertyfire
 * */
public class ParticleUtils {
    /**Don't let anyone instantiate this class.*/
    private ParticleUtils() {}

    /**
     * Map that contains all particle classes and it's names.
     * @since 1.0.2
     * */
    private static final Map<String, Class<? extends EntityFX>> effects = new HashMap<>();

    /**
     * Register particle.
     * @param particle class of particle.
     * @param name identifier of particle. I recommend to name as modid:particleid and create string constant anywhere.
     * @since 1.0.2
     * */
    public static void register(Class<? extends EntityFX> particle, String name) {
        effects.put(name, particle);
    }

    /**
     * Spawn particle by id.
     * @param name identifier of particle. First register it.
     * @param x x pos.
     * @param y y pos.
     * @param z z pos.
     * @param motionX motion by x.
     * @param motionY motion by y.
     * @param motionZ motion by z.
     * */
    public static void spawnParticle(String name, double x, double y, double z, double motionX, double motionY, double motionZ) {
        Class<? extends EntityFX> clazz = effects.get(name);
        EntityFX particle = null;
        try {
            Constructor<? extends EntityFX> constructor = clazz.getDeclaredConstructor(World.class, double.class, double.class, double.class, double.class, double.class, double.class);
            particle = constructor.newInstance(Minecraft.getMinecraft().theWorld, x, y, z, motionX, motionY, motionZ);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | NullPointerException e) {
            WertyfireCoreMod.getModLogger().error("Could not create particle: {}", e.getMessage());
        }

        if (particle != null) Minecraft.getMinecraft().effectRenderer.addEffect(particle);
    }
}