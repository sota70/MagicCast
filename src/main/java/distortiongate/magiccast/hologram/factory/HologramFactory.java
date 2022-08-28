package distortiongate.magiccast.hologram.factory;

import distortiongate.magiccast.hologram.Hologram;
import distortiongate.magiccast.hologram.method.despawn.DefaultHologramDespawnMethod;
import distortiongate.magiccast.hologram.method.ontouch.DefaultHologramOnTouchMethod;
import distortiongate.magiccast.hologram.method.spawn.DefaultHologramSpawnMethod;
import distortiongate.magiccast.inventorymaincontents.InventoryMainContents;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class HologramFactory {

    public static Hologram create(
            HologramMethodType methodType,
            String name,
            Player owner,
            Location spawnLoc,
            InventoryMainContents inventoryMainContents
    ) {
        return switch (methodType) {
            case DEFAULT -> new Hologram(
                    name,
                    DefaultHologramSpawnMethod.getInstance(),
                    DefaultHologramOnTouchMethod.getInstance(),
                    DefaultHologramDespawnMethod.getInstance(),
                    owner,
                    spawnLoc,
                    inventoryMainContents
            );
        };
    }
}
