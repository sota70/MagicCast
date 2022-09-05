package distortiongate.magiccast.listener;

import distortiongate.magiccast.PlayerMagicCaster;
import distortiongate.magiccast.state.playerstate.PlayerState;
import distortiongate.magiccast.state.playerstate.PlayerStateFactory;
import distortiongate.magiccast.state.playerstate.PlayerStateType;
import distortiongate.magiccast.state.playerstate.PlayerStatusStorage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class PlayerSneakedListener implements Listener {

    @EventHandler
    public void onSneaking(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        PlayerStatusStorage statusStorage = PlayerStatusStorage.getInstance();
        if (!player.isSneaking()) {
            return;
        }
        if (!statusStorage.playerHasStatus(player)) {
            return;
        }
        if (statusStorage.getPlayerStatus(player) != PlayerStateFactory.create(PlayerStateType.MAGIC_CASTING)) {
            return;
        }
        PlayerMagicCaster.cast(player);
        this.setNextPlayerStatus(player);
        this.executePlayerStatus(player);
    }

    private void executePlayerStatus(Player player) {
        PlayerStatusStorage storage = PlayerStatusStorage.getInstance();
        storage.getPlayerStatus(player).execute(player);
    }

    public void setNextPlayerStatus(Player player) {
        PlayerStatusStorage storage = PlayerStatusStorage.getInstance();
        PlayerState playerStatus = storage.getPlayerStatus(player);
        storage.setPlayerStatus(player, playerStatus.getNextState());
    }
}
