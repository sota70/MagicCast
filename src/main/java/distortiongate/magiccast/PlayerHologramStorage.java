package distortiongate.magiccast;

import org.bukkit.entity.Player;

import java.util.*;

public class PlayerHologramStorage {

    private static PlayerHologramStorage instance = new PlayerHologramStorage();
    // first UUID is player's id and then second one is hologram's id
    private Map<UUID, List<UUID>> playerHolograms = new HashMap<>();

    private PlayerHologramStorage() { }

    public static PlayerHologramStorage getInstance() {
        return instance;
    }

    public void registerHologram(Player player, UUID uuid) {
        UUID playerUUID = player.getUniqueId();
        if (!this.playerHolograms.containsKey(playerUUID)) {
            this.playerHolograms.put(playerUUID, new ArrayList<>(List.of(uuid)));
            return;
        }
        this.playerHolograms.get(playerUUID).add(uuid);
    }

    public List<UUID> getHolograms(Player player) {
        return this.playerHolograms.get(player.getUniqueId());
    }

    public void clearHolograms(Player player) {
        if (!this.playerHolograms.containsKey(player.getUniqueId())) {
            return;
        }
        this.playerHolograms.remove(player.getUniqueId());
    }

    public boolean playerHasHolograms(Player player) {
        if (!this.playerHolograms.containsKey(player.getUniqueId())) {
            return false;
        }
        if (this.playerHolograms.get(player.getUniqueId()).size() < 1) {
            return false;
        }
        return true;
    }
}
