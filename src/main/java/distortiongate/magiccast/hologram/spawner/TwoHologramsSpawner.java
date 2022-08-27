package distortiongate.magiccast.hologram.spawner;

import distortiongate.magiccast.HologramSpawnLocationCalculator;
import distortiongate.magiccast.hologram.Hologram;
import org.bukkit.Location;

public class TwoHologramsSpawner implements HologramSpawner {

    private static TwoHologramsSpawner instance = new TwoHologramsSpawner();

    private TwoHologramsSpawner() { }

    @Override
    public void spawn(Hologram hologram) {
        Location playerLoc = hologram.getOwner().getLocation();
        // hologram0 setup
        Location spawnLoc = HologramSpawnLocationCalculator.calc(playerLoc, 1.5, playerLoc.getYaw());
        spawnLoc.setY(playerLoc.getY() + 1.5);
        this.spawnHologram(hologram, "0", spawnLoc);

        // hologram1 setup
        spawnLoc = HologramSpawnLocationCalculator.calc(playerLoc, 1.5, playerLoc.getYaw());
        spawnLoc.setY(playerLoc.getY() + 0.5);
        this.spawnHologram(hologram, "1", spawnLoc);
    }

    private void spawnHologram(Hologram baseHologram, String name, Location spawnLoc) {
        Hologram copyHologram = baseHologram.clone();
        copyHologram.setName(name);
        copyHologram.setSpawnLocation(spawnLoc);
        copyHologram.spawn();
    }

    public static TwoHologramsSpawner getInstance() {
        return instance;
    }
}
