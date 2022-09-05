package distortiongate.magiccast.listener;

import distortiongate.magiccast.castaction.PlayerCastActionStorage;
import distortiongate.magiccast.hologram.Hologram;
import distortiongate.magiccast.hologram.PlayerHologramStorage;
import distortiongate.magiccast.state.playerstate.PlayerStatusStorage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        PlayerHologramStorage playerHologramStorage = PlayerHologramStorage.getInstance();
        PlayerStatusStorage playerStatusStorage = PlayerStatusStorage.getInstance();
        PlayerCastActionStorage playerCastActionStorage = PlayerCastActionStorage.getInstance();
        playerStatusStorage.clearPlayerStatus(player);
        if (!playerHologramStorage.playerHasHolograms(player)) {
            return;
        }
        playerHologramStorage.getHolograms(player).forEach(Hologram::despawn);
        playerHologramStorage.clearHolograms(player);
        playerCastActionStorage.clearAction(player);
    }
}
