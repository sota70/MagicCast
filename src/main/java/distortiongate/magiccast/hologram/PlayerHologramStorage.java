package distortiongate.magiccast.hologram;

import org.bukkit.entity.Player;

import java.util.*;

public class PlayerHologramStorage {

    private static PlayerHologramStorage instance = new PlayerHologramStorage();
    // first UUID is player's id and then second one is hologram's id
    private Map<UUID, List<Hologram>> playerHolograms = new HashMap<>();

    private PlayerHologramStorage() { }

    public static PlayerHologramStorage getInstance() {
        return instance;
    }

    public void registerHologram(Player player, Hologram hologram) {
        UUID playerId = player.getUniqueId();
        if (!this.playerHolograms.containsKey(playerId)) {
            this.playerHolograms.put(playerId, new ArrayList<>(List.of(hologram)));
            return;
        }
        if (this.getHolograms(player).contains(hologram)) {
            return;
        }
        this.playerHolograms.get(playerId).add(hologram);
    }

    public List<Hologram> getHolograms(Player player) { return this.playerHolograms.get(player.getUniqueId()); }

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
