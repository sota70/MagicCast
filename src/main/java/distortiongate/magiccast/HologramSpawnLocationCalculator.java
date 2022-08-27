package distortiongate.magiccast;

import org.bukkit.Location;

public class HologramSpawnLocationCalculator {

    public static Location calc(Location startLoc, double distance, double degree) {
        Location spawnLoc = startLoc.clone();
        double tempDeg1 = degree >= 0.0 ? degree : 360.0 + degree;
        double tempDeg2 = tempDeg1 + (tempDeg1 >= 90.0 ? -90.0 : 270.0);
        double rad = (tempDeg2 / 360.0) * Math.PI * 2.0;
        double x = startLoc.getX();
        double z = startLoc.getZ();
        double spawnPosX = x - distance * Math.cos(rad);
        double spawnPosZ = z - distance * Math.sin(rad);
        spawnLoc.setX(spawnPosX);
        spawnLoc.setZ(spawnPosZ);
        return spawnLoc;
    }
}
