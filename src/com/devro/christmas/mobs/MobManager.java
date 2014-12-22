package com.devro.christmas.mobs;

import com.devro.christmas.ChristmasCore;
import net.minecraft.server.v1_7_R4.EntityInsentient;
import net.minecraft.server.v1_7_R4.EntityTypes;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Programmed by DevRo_ on 22/12/14.
 */
public class MobManager {

    private HashMap<EntityInsentient, Location> locationHashMap = new HashMap<>();

    private static MobManager instance;

    public static MobManager getInstance() {
        if (instance == null) {
            instance = new MobManager();
        }

        return instance;
    }

    private void startRunnable() {
        new BukkitRunnable() {
            @Override
            public void run() {

                locationHashMap.keySet().stream().filter(insentient -> !locationHashMap.get(insentient).equals(insentient.getBukkitEntity().getLocation())).forEach(insentient -> insentient.getBukkitEntity().teleport(locationHashMap.get(insentient)));

            }
        }.runTaskTimer(ChristmasCore.getInstance(), 0L, 5L);

    }

    private MobManager() {
        registerEntity("Christmas Snowman", EntityType.SNOWMAN.getTypeId(), ChristmasSnowman.class);

        startRunnable();
    }

    public EntityInsentient spawnMob(EntityInsentient mob, Location location, boolean noMove) {
        mob.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        ((CraftWorld)location.getWorld()).getHandle().addEntity(mob);

        if (noMove) {
            locationHashMap.put(mob, location);
        }

        return mob;
    }

    @SuppressWarnings("unchecked")
    public void registerEntity(String name, int id, Class<? extends EntityInsentient> customClass) {
        try {

            List<Map<?, ?>> dataMaps = new ArrayList<>();
            for (Field f : EntityTypes.class.getDeclaredFields()) {
                if (f.getType().getSimpleName().equals(Map.class.getSimpleName())) {
                    f.setAccessible(true);
                    dataMaps.add((Map<?, ?>) f.get(null));
                }
            }

            ((Map<Class<? extends EntityInsentient>, String>) dataMaps.get(1)).put(customClass, name);
            ((Map<Class<? extends EntityInsentient>, Integer>) dataMaps.get(3)).put(customClass, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
