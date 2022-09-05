package distortiongate.magiccast.listener;

import distortiongate.magiccast.Magiccast;
import distortiongate.magiccast.state.playerstate.PlayerStateFactory;
import distortiongate.magiccast.state.playerstate.PlayerStateType;
import distortiongate.magiccast.state.playerstate.PlayerStatusStorage;
import net.Indyuce.mmocore.api.MMOCoreAPI;
import net.Indyuce.mmocore.api.player.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import java.util.List;

public class PlayerPressFKeyListener implements Listener {

    @EventHandler
    public void onPressedF(PlayerSwapHandItemsEvent event) {
        PlayerStatusStorage playerStatusStorage = PlayerStatusStorage.getInstance();
        Player player = event.getPlayer();
        double previousY = player.getLocation().getY();
        if (player.getGameMode() != GameMode.ADVENTURE) {
            return;
        }
        if (!this.isPlayerCastable(player)) {
            return;
        }
        event.setCancelled(true);
        // 1チック後にY軸が移動していなかったらキャストモードへ入る
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Magiccast.getInstance(), () -> {
            if (player.getLocation().getY() != previousY) {
                return;
            }
            if (!playerStatusStorage.playerHasStatus(player)) {
                playerStatusStorage.setPlayerStatus(player, PlayerStateFactory.create(PlayerStateType.NORMAL));
            }
            playerStatusStorage.setPlayerStatus(player, playerStatusStorage.getPlayerStatus(player).getNextState());
            playerStatusStorage.getPlayerStatus(player).execute(player);
        }, 1L);
    }

    private boolean isPlayerCastable(Player player) {
        MMOCoreAPI api = new MMOCoreAPI(Magiccast.getInstance());
        PlayerData playerData = api.getPlayerData(player);
        Configuration settingsConfig = Magiccast.getInstance().getConfig();
        List<String> castingBlacklist = settingsConfig.getStringList("casting-blacklist");
        String className = playerData.getProfess().getName();
        return !castingBlacklist.contains(className);
    }
}
