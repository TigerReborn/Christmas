package com.devro.christmas.utils;

import net.minecraft.server.v1_7_R4.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Programmed by DevRo_ on 22/12/14.
 */
public enum Particles {
    HUGE_EXPLOSION("hugeexplosion"),
    LARGE_EXPLODE("largeexplode"),
    FIREWORKS_SPARK("fireworksSpark"),
    BUBBLE("bubble"),
    SUSPEND("suspend"),
    DEPTH_SUSPEND("depthSuspend"),
    TOWN_AURA("townaura"),
    CRIT("crit"),
    MAGIC_CRIT("magicCrit"),
    MOB_SPELL("mobSpell"),
    MOB_SPELL_AMBIENT("mobSpellAmbient"),
    SPELL("spell"),
    INSTANT_SPELL("instantSpell"),
    WITCH_MAGIC("witchMagic"),
    NOTE("note"),
    PORTAL("portal"),
    ENCHANTMENT_TABLE("enchantmenttable"),
    EXPLODE("explode"),
    FLAME("flame"),
    LAVA("lava"),
    FOOTSTEP("footstep"),
    SPLASH("splash"),
    LARGE_SMOKE("largesmoke"),
    CLOUD("cloud"),
    RED_DUST("reddust"),
    SNOWBALL_POOF("snowballpoof"),
    DRIP_WATER("dripWater"),
    DRIP_LAVA("dripLava"),
    SNOW_SHOVEL("snowshovel"),
    SLIME("slime"),
    HEART("heart"),
    ANGRY_VILLAGER("angryVillager"),
    HAPPY_VILLAGER("happyVillager");

    private final String name;

    Particles(String name) {
        this.name = name;
    }

    private PacketPlayOutWorldParticles getPacket(String name, Location location, float x, float y, float z, float speed, int amount) {
        if (amount <= 0) {
            return null;
        }

        return new PacketPlayOutWorldParticles(name, (float) location.getX(), (float) location.getY(), (float) location.getZ(), x, y, z, speed, amount);
    }

    public void send(Player player, Location location, float x, float y, float z, float speed, int amount) {
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(getPacket(name, location, x, y, z, speed, amount));
    }

    public void send(Location location, float offsetx, float offsety, float offsetz, float speed, int amount) {
        Bukkit.getOnlinePlayers().stream().forEach(p -> send(p, location, offsetx, offsety, offsetz, speed, amount));
    }

    public void sendToAll(Location location, float o, int amount){
        location.getWorld().getPlayers().stream().forEach(p -> send(p, location, o, o, o, 0, amount));
    }
}
