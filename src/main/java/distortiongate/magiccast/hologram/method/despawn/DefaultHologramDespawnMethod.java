package distortiongate.magiccast.hologram.method.despawn;

import distortiongate.magiccast.hologram.Hologram;
import org.bukkit.entity.Entity;

import java.util.UUID;

public class DefaultHologramDespawnMethod implements HologramDespawnMethod {

    private static DefaultHologramDespawnMethod instance = new DefaultHologramDespawnMethod();

    private DefaultHologramDespawnMethod() { }

    @Override
    public void despawn(Hologram hologram) {
        UUID hologramId = hologram.getHologramId();
        Entity holoEntity = hologram.getOwner().getWorld().getEntity(hologramId);
        if (holoEntity != null) {
            holoEntity.remove();
        }
    }

    public static DefaultHologramDespawnMethod getInstance() { return instance; }
}
