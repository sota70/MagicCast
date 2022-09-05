package distortiongate.magiccast.listener;

import distortiongate.magiccast.hologram.PlayerHologramStorage;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;


public class PlayerClickHologramListener implements Listener {

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onClick(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        Entity clickedEntity = event.getRightClicked();
        PlayerHologramStorage playerHologramStorage = PlayerHologramStorage.getInstance();
        if (!playerHologramStorage.playerHasHolograms(player)) {
            return;
        }
        playerHologramStorage.getHolograms(player).forEach((hologram) -> {
            if (clickedEntity.getUniqueId() != hologram.getHologramId()) {
                return;
            }
            hologram.onTouch();
            event.setCancelled(true);
        });
    }
}
