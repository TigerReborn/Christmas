package com.devro.christmas.creator.phases;

import com.devro.christmas.creator.ChristmasSpawner;
import com.devro.christmas.mobs.ChristmasSnowman;
import com.devro.christmas.mobs.MobManager;
import com.devro.christmas.utils.MathUtils;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;

import java.util.List;

/**
 * Programmed by DevRo_ on 22/12/14.
 */
public class TreePhase extends ChristmasSpawner {

    public TreePhase() {
        super("Tree", 1);
    }

    @Override
    public void spawn(Location location) {

        List<Location> firstLayer = MathUtils.getCylinder(location, 10, 10, 1, true);
        List<Location> secondLayer = MathUtils.getCylinder(location.add(0, 1, 0), 9, 9, 1, true);
        List<Location> thirdLayer = MathUtils.getCylinder(location.add(0, 2, 0), 8, 8, 1, true);
        List<Location> fourthLayer = MathUtils.getCylinder(location.add(0, 3, 0), 7, 7, 1, true);
        List<Location> fifthLayer = MathUtils.getCylinder(location.add(0, 4, 0), 6, 6, 1, true);
        List<Location> sixthLayer = MathUtils.getCylinder(location.add(0, 5, 0), 5, 5, 1, true);
        List<Location> seventhLayer = MathUtils.getCylinder(location.add(0, 6, 0), 4, 4, 1, true);
        List<Location> eighthLayer = MathUtils.getCylinder(location.add(0, 7, 0), 3, 3, 1, true);
        List<Location> ninthLayer = MathUtils.getCylinder(location.add(0, 8, 0), 2, 2, 1, true);
        List<Location> tenthLayer = MathUtils.getCylinder(location.add(0, 9, 0), 1, 1, 1, true);

        //TODO Make layer below each layer be the "holder" of the above layer.
        //eg the second layer's mobs are the passangers of the first layer's mobs.

        firstLayer.stream().forEach(l -> MobManager.getInstance().spawnMob(new ChristmasSnowman(((CraftWorld)l.getWorld()).getHandle()), l, true));
        secondLayer.stream().forEach(l -> MobManager.getInstance().spawnMob(new ChristmasSnowman(((CraftWorld)l.getWorld()).getHandle()), l, true));
        thirdLayer.stream().forEach(l -> MobManager.getInstance().spawnMob(new ChristmasSnowman(((CraftWorld)l.getWorld()).getHandle()), l, true));
        fourthLayer.stream().forEach(l -> MobManager.getInstance().spawnMob(new ChristmasSnowman(((CraftWorld)l.getWorld()).getHandle()), l, true));
        fifthLayer.stream().forEach(l -> MobManager.getInstance().spawnMob(new ChristmasSnowman(((CraftWorld)l.getWorld()).getHandle()), l, true));
        sixthLayer.stream().forEach(l -> MobManager.getInstance().spawnMob(new ChristmasSnowman(((CraftWorld)l.getWorld()).getHandle()), l, true));
        seventhLayer.stream().forEach(l -> MobManager.getInstance().spawnMob(new ChristmasSnowman(((CraftWorld)l.getWorld()).getHandle()), l, true));
        eighthLayer.stream().forEach(l -> MobManager.getInstance().spawnMob(new ChristmasSnowman(((CraftWorld)l.getWorld()).getHandle()), l, true));
        ninthLayer.stream().forEach(l -> MobManager.getInstance().spawnMob(new ChristmasSnowman(((CraftWorld)l.getWorld()).getHandle()), l, true));
        tenthLayer.stream().forEach(l -> MobManager.getInstance().spawnMob(new ChristmasSnowman(((CraftWorld)l.getWorld()).getHandle()), l, true));
    }
}
