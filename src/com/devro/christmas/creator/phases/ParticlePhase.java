package com.devro.christmas.creator.phases;

import com.devro.christmas.ChristmasCore;
import com.devro.christmas.creator.ChristmasSpawner;
import com.devro.christmas.utils.MathUtils;
import com.devro.christmas.utils.Particles;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Programmed by DevRo_ on 22/12/14.
 */
public class ParticlePhase extends ChristmasSpawner {

    public ParticlePhase() {
        super("Particles", 3);
    }

    @Override
    public void spawn(Location location) {

        Particles[] particleses = new Particles[]{Particles.FIREWORKS_SPARK, Particles.CRIT, Particles.MAGIC_CRIT, Particles.NOTE, Particles.RED_DUST, Particles.SNOWBALL_POOF, Particles.HEART};

        new BukkitRunnable() {
            @Override
            public void run() {

                Particles particles = particleses[MathUtils.r(particleses.length) + 1];

                int offsetX = MathUtils.r(50);
                int offsetY = MathUtils.r(25);
                int offsetZ = MathUtils.r(50);
                int speed = MathUtils.r(2);
                int amount = MathUtils.r(1000);

                particles.send(location, offsetX, offsetY, offsetZ, speed, amount);
            }
        }.runTaskTimer(ChristmasCore.getInstance(), 0L, 5L);

    }
}
