package com.devro.christmas.mobs;

import net.minecraft.server.v1_7_R4.*;
import org.bukkit.craftbukkit.v1_7_R4.util.UnsafeList;

import java.lang.reflect.Field;

/**
 * Programmed by DevRo_ on 22/12/14.
 */
public class ChristmasSnowman extends EntitySnowman {

    public ChristmasSnowman(World world) {
        super(world);

        try {
            Field bField =PathfinderGoalSelector.class.getDeclaredField("b");
            Field cField = PathfinderGoalSelector.class.getDeclaredField("c");

            bField.setAccessible(true);
            cField.setAccessible(true);

            bField.set(goalSelector, new UnsafeList<>());
            bField.set(targetSelector, new UnsafeList<>());
            cField.set(goalSelector, new UnsafeList<>());
            cField.set(target, new UnsafeList<>());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void aD() {
        super.aD();

        this.getAttributeInstance(GenericAttributes.b).setValue(0.0D);
        this.getAttributeInstance(GenericAttributes.maxHealth).setValue(Double.MAX_VALUE);
        this.getAttributeInstance(GenericAttributes.d).setValue(Double.MAX_VALUE);
    }

    @Override
    public void move(double d0, double d1, double d2) {}

    @Override
    public void collide(Entity entity) {}
}
