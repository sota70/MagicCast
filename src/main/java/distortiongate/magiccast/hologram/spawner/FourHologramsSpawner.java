package distortiongate.magiccast.hologram.spawner;

import distortiongate.magiccast.HologramSpawnLocationCalculator;
import distortiongate.magiccast.hologram.Hologram;
import org.bukkit.Location;

public class FourHologramsSpawner implements HologramSpawner {

    private static FourHologramsSpawner instance = new FourHologramsSpawner();

    private FourHologramsSpawner() { }

    @Override
    public void spawn(Hologram hologram) {
        Location playerLoc = hologram.getOwner().getLocation();
        Location spawnLoc = HologramSpawnLocationCalculator.calc(playerLoc, 1.5, playerLoc.getYaw() - 30.0);
        HologramSpawnerFactory.create(HologramSpawnerType.TWO_HOLOGRAMS).spawn(hologram);
        // hologram2 setup
        spawnLoc.setY(playerLoc.getY() + 1.0);
        this.spawnHologram(hologram, "2", spawnLoc);

        // hologram3 setup
        spawnLoc = HologramSpawnLocationCalculator.calc(playerLoc, 1.5, playerLoc.getYaw() + 30.0);
        spawnLoc.setY(playerLoc.getY() + 1.0);
        this.spawnHologram(hologram, "3", spawnLoc);
    }

    private void spawnHologram(Hologram baseHologram, String name, Location spawnLoc) {
        Hologram copyHologram = baseHologram.clone();
        copyHologram.setName(name);
        copyHologram.setSpawnLocation(spawnLoc);
        copyHologram.spawn();
    }

    public static FourHologramsSpawner getInstance() { return instance; }
}
