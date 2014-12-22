package com.devro.christmas.utils;

import me.pauzen.jhack.reflection.ReflectionFactory;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.NetworkManager;
import net.minecraft.util.io.netty.channel.Channel;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

public class PlayerUtils {

    public Channel getNettyChannel(Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
        NetworkManager networkManager = entityPlayer.playerConnection.networkManager;
        Field channelField = ReflectionFactory.getField(NetworkManager.class, "m");
        try {
            return (Channel) channelField.get(networkManager);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
