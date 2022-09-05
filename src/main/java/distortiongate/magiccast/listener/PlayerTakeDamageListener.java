package distortiongate.magiccast.listener;

import distortiongate.magiccast.Magiccast;
import distortiongate.magiccast.state.playerstate.PlayerState;
import distortiongate.magiccast.state.playerstate.PlayerStateFactory;
import distortiongate.magiccast.state.playerstate.PlayerStateType;
import distortiongate.magiccast.state.playerstate.PlayerStatusStorage;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerTakeDamageListener implements Listener {

    @EventHandler
    public void onTakingDamage(EntityDamageEvent event) {
        FileConfiguration settingsConfig = Magiccast.getInstance().getConfig();
        boolean cancelWhenTakeDamage = settingsConfig.getBoolean("cancel-casting-when-take-damage");
        Player player;
        PlayerState playerState;
        PlayerStatusStorage playerStatusStorage = PlayerStatusStorage.getInstance();
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        player = (Player)event.getEntity();
        playerState = playerStatusStorage.getPlayerStatus(player);
        if (playerState != PlayerStateFactory.create(PlayerStateType.MAGIC_CASTING)) {
            return;
        }
        if (!cancelWhenTakeDamage) {
            return;
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
