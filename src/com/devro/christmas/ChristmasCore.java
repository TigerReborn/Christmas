package com.devro.christmas;

import com.devro.christmas.creator.ChristmasCreator;
import com.devro.christmas.creator.phases.TreePhase;
import com.devro.christmas.mobs.MobManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Programmed by DevRo_ on 22/12/14.
 */
public class ChristmasCore extends JavaPlugin {

    private static ChristmasCore instance;

    @Override
    public void onEnable() {
        instance = this;

        MobManager.getInstance();
        ChristmasCreator.getInstance();

        ChristmasCreator.getInstance().registerPhase(new TreePhase());
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static ChristmasCore getInstance() {
        return instance;
    }
}
