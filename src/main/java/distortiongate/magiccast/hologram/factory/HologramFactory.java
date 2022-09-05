package distortiongate.magiccast.hologram.factory;

import distortiongate.magiccast.hologram.Hologram;
import distortiongate.magiccast.hologram.method.despawn.DefaultHologramDespawnMethod;
import distortiongate.magiccast.hologram.method.despawn.HologramDespawnMethod;
import distortiongate.magiccast.hologram.method.despawn.HologramDespawnMethodType;
import distortiongate.magiccast.hologram.method.despawn.PacketHologramDespawnMethod;
import distortiongate.magiccast.hologram.method.ontouch.DefaultHologramOnTouchMethod;
import distortiongate.magiccast.hologram.method.ontouch.HologramOnTouchMethod;
import distortiongate.magiccast.hologram.method.ontouch.HologramOnTouchMethodType;
import distortiongate.magiccast.hologram.method.spawn.*;
import distortiongate.magiccast.inventorymaincontents.InventoryMainContents;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class HologramFactory {

    public static Hologram create(
            HologramSpawnMethodType spawnMethodType,
            HologramOnTouchMethodType onTouchMethodType,
            HologramDespawnMethodType despawnMethodType,
            String name,
            Player owner,
            Location spawnLoc,
            InventoryMainContents inventoryMainContents
    ) {
        HologramSpawnMethod spawnMethod = null;
        HologramOnTouchMethod onTouchMethod = null;
        HologramDespawnMethod despawnMethod = null;
        switch (spawnMethodType) {
            case DEFAULT -> spawnMethod = DefaultHologramSpawnMethod.getInstance();
            case INVULNERABLE -> spawnMethod = InvulnerableHologramSpawnMethod.getInstance();
            case PACKET -> spawnMethod = PacketHologramSpawnMethod.getInstance();
        }
        switch (onTouchMethodType) {
            case DEFAULT -> onTouchMethod = DefaultHologramOnTouchMethod.getInstance();
        }
        switch (despawnMethodType) {
            case DEFAULT -> despawnMethod = DefaultHologramDespawnMethod.getInstance();
            case PACKET -> despawnMethod = PacketHologramDespawnMethod.getInstance();
        }
        return new Hologram(
                name,
                spawnMethod,
                onTouchMethod,
                despawnMethod,
                owner,
                spawnLoc,
                inventoryMainContents
        );
    }
}
