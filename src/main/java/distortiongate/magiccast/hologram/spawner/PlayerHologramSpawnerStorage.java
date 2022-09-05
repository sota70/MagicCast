package distortiongate.magiccast.hologram.spawner;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerHologramSpawnerStorage {

    private static PlayerHologramSpawnerStorage instance = new PlayerHologramSpawnerStorage();
    private Map<Player, HologramSpawner> playerHologramSpawner = new HashMap<>();

    private PlayerHologramSpawnerStorage() { }

    public void setHologramSpawner(Player player, HologramSpawner hologramSpawner) {
        this.playerHologramSpawner.put(player, hologramSpawner);
    }

    public HologramSpawner getHologramSpawner(Player player) {
        if (!this.playerHasHologramSpawner(player)) {
            return HologramSpawnerFactory.create(HologramSpawnerType.TWO_HOLOGRAMS);
        }
        return this.playerHologramSpawner.get(player);
    }

    public boolean playerHasHologramSpawner(Player player) { return this.playerHologramSpawner.containsKey(player); }

    public static PlayerHologramSpawnerStorage getInstance() { return instance; }
}
