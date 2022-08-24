package distortiongate.magiccast.listener;

import distortiongate.magiccast.PlayerHologramStorage;
import distortiongate.magiccast.hologram.Hologram;
import distortiongate.magiccast.state.playerstate.PlayerStatusStorage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        PlayerHologramStorage playerHologramStorage = PlayerHologramStorage.getInstance();
        PlayerStatusStorage playerStatusStorage = PlayerStatusStorage.getInstance();
        playerStatusStorage.clearPlayerStatus(player);
        if (!playerHologramStorage.playerHasHolograms(player)) {
            return;
        }
        playerHologramStorage.getHolograms(player).forEach(Hologram::despawn);
        playerHologramStorage.clearHolograms(player);
    }
}
