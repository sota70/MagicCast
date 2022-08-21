package distortiongate.magiccast.hologram.factory;

import distortiongate.magiccast.hologram.Hologram;
import distortiongate.magiccast.hologram.method.move.DefaultHologramMoveMethod;
import distortiongate.magiccast.hologram.method.ontouch.DefaultHologramOnTouchMethod;
import distortiongate.magiccast.hologram.method.spawn.DefaultHologramSpawnMethod;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class HologramFactory {

    public static Hologram create(HologramMethodType methodType, Player owner, Location spawnLoc) {
        return switch (methodType) {
            case DEFAULT -> new Hologram(
                    DefaultHologramSpawnMethod.getInstance(),
                    DefaultHologramOnTouchMethod.getInstance(),
                    DefaultHologramMoveMethod.getInstance(),
                    owner,
                    spawnLoc
            );
        };
    }
}