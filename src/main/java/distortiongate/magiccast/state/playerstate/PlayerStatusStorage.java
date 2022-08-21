package distortiongate.magiccast.state.playerstate;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerStatusStorage {

    private static final PlayerStatusStorage instance = new PlayerStatusStorage();
    private final Map<UUID, PlayerState> playersState = new HashMap<>();

    private PlayerStatusStorage() { }

    public static PlayerStatusStorage getInstance() {
        return instance;
    }

    public void setPlayerStatus(Player player, PlayerState status) {
        this.playersState.put(player.getUniqueId(), status);
    }

    public boolean playerHasStatus(Player player) {
        return this.playersState.containsKey(player.getUniqueId());
    }

    public PlayerState getPlayerStatus(Player player) {
        return this.playersState.get(player.getUniqueId());
    }
}
