package distortiongate.magiccast.listener;

import distortiongate.magiccast.state.playerstate.PlayerStateFactory;
import distortiongate.magiccast.state.playerstate.PlayerStateType;
import distortiongate.magiccast.state.playerstate.PlayerStatusStorage;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location previousLoc = event.getFrom();
        Location afterLoc = event.getTo();
        boolean isPlayerOnMagicCastingMode =
                PlayerStatusStorage.getInstance().getPlayerStatus(player) == PlayerStateFactory.create(PlayerStateType.MAGIC_CASTING);
        if (isPlayerOnMagicCastingMode) {
            previousLoc.setPitch(afterLoc.getPitch());
            previousLoc.setYaw(afterLoc.getYaw());
            event.setTo(previousLoc);
        }
    }
}
