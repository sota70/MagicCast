package distortiongate.magiccast.hologram.spawner;

import distortiongate.magiccast.hologram.method.despawn.HologramDespawnMethodType;
import distortiongate.magiccast.hologram.method.ontouch.HologramOnTouchMethodType;
import distortiongate.magiccast.hologram.method.spawn.HologramSpawnMethodType;
import org.bukkit.entity.Player;

public interface HologramSpawner {

    void spawn(
            HologramSpawnMethodType spawnMethodType,
            HologramOnTouchMethodType onTouchMethodType,
            HologramDespawnMethodType despawnMethodType,
            Player player
    );
}
