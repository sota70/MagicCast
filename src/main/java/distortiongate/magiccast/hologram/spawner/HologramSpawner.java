package distortiongate.magiccast.hologram.spawner;

import distortiongate.magiccast.hologram.factory.HologramMethodType;
import org.bukkit.entity.Player;

public interface HologramSpawner {

    void spawn(HologramMethodType methodType, Player player);
}
