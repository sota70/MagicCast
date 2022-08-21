package distortiongate.magiccast.hologram.spawner;

import distortiongate.magiccast.hologram.Hologram;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class TwoHologramsSpawner implements HologramSpawner {

    private static TwoHologramsSpawner instance = new TwoHologramsSpawner();

    private TwoHologramsSpawner() { }

    @Override
    public void spawn(Hologram hologram) {
        Location baseLoc;
        Location spawnLoc;
        Player player = hologram.getOwner();
        Vector baseVector = player.getLocation().toVector();
        Vector playerDirection = player.getLocation().getDirection();
        baseVector = baseVector.add(playerDirection.multiply(1.5));
        baseVector = baseVector.setY(player.getLocation().getY());
        baseLoc = baseVector.toLocation(player.getWorld());
        // hologram1 setup
        spawnLoc = baseLoc.clone().add(0.0, 2.0, 0.0);
        hologram.setSpawnLocation(spawnLoc);
        hologram.spawn();

        // hologram2 setup
        spawnLoc = baseLoc.clone().add(0.0, 0.5, 0.0);
        hologram.setSpawnLocation(spawnLoc);
        hologram.spawn();
    }

    public static TwoHologramsSpawner getInstance() {
        return instance;
    }
}
