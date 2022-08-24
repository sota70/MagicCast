package distortiongate.magiccast.hologram.spawner;

import distortiongate.magiccast.hologram.Hologram;
import org.bukkit.Location;

public class TwoHologramsSpawner implements HologramSpawner {

    private static TwoHologramsSpawner instance = new TwoHologramsSpawner();

    private TwoHologramsSpawner() { }

    @Override
    public void spawn(Hologram hologram) {
        Hologram hologram1 = hologram.clone();
        Hologram hologram2 = hologram.clone();
        Location playerLoc = hologram.getOwner().getLocation();
        Location tempLoc;
        double distanceFromPlayer = 1.5;
        double playerDeg = playerLoc.getYaw();
        double tempPlayerDeg1 = playerDeg >= 0.0 ? playerDeg : 360.0 + playerDeg;
        double tempPlayerDeg2 = tempPlayerDeg1 + (tempPlayerDeg1 >= 90.0 ? -90.0 : 270.0);
        double playerRad = (tempPlayerDeg2 / 360.0) * Math.PI * 2.0;
        double playerPosX = playerLoc.getX();
        double playerPosZ = playerLoc.getZ();
        double spawnPosX = playerPosX - distanceFromPlayer * Math.cos(playerRad);
        double spawnPosZ = playerPosZ - distanceFromPlayer * Math.sin(playerRad);
        playerLoc.setX(spawnPosX);
        playerLoc.setY(playerLoc.getY() + 1.5);
        playerLoc.setZ(spawnPosZ);
        // hologram1 setup
        tempLoc = playerLoc.clone();
        hologram1.setName("0");
        hologram1.setSpawnLocation(tempLoc);
        hologram1.spawn();

        // hologram2 setup
        tempLoc = playerLoc.clone().add(0.0, -1.0, 0.0);
        hologram2.setName("1");
        hologram2.setSpawnLocation(tempLoc);
        hologram2.spawn();
    }

    public static TwoHologramsSpawner getInstance() {
        return instance;
    }
}
