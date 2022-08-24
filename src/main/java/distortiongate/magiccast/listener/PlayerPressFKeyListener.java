package distortiongate.magiccast.listener;

import distortiongate.magiccast.state.playerstate.PlayerState;
import distortiongate.magiccast.state.playerstate.PlayerStateFactory;
import distortiongate.magiccast.state.playerstate.PlayerStateType;
import distortiongate.magiccast.state.playerstate.PlayerStatusStorage;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class PlayerPressFKeyListener implements Listener {

    @EventHandler
    public void onPressedF(PlayerSwapHandItemsEvent event) {
        PlayerStatusStorage playerStatusStorage = PlayerStatusStorage.getInstance();
        Player player = event.getPlayer();
        if (player.getGameMode() != GameMode.ADVENTURE) {
            return;
        }
        if (!playerStatusStorage.playerHasStatus(player)) {
            playerStatusStorage.setPlayerStatus(player, PlayerStateFactory.create(PlayerStateType.NORMAL));
        }
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
