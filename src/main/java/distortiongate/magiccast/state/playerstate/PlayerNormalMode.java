package distortiongate.magiccast.state.playerstate;

import distortiongate.magiccast.hologram.PlayerHologramStorage;
import distortiongate.magiccast.castaction.PlayerCastActionStorage;
import distortiongate.magiccast.hologram.Hologram;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerNormalMode implements PlayerState {

    private static PlayerNormalMode instance = new PlayerNormalMode();

    private PlayerNormalMode() { }

    @Override
    public void execute(Player player) {
        PlayerHologramStorage playerHologramStorage = PlayerHologramStorage.getInstance();
        PlayerCastActionStorage playerCastActionStorage = PlayerCastActionStorage.getInstance();
        player.sendMessage(ChatColor.YELLOW + "You are currently on Normal mode");
        if (!playerHologramStorage.playerHasHolograms(player)) {
            return;
        }
        playerHologramStorage.getHolograms(player).forEach(Hologram::despawn);
        playerHologramStorage.clearHolograms(player);
        playerCastActionStorage.clearAction(player);
    }

    @Override
    public PlayerState getNextState() {
        return PlayerStateFactory.create(PlayerStateType.MAGIC_CASTING);
    }

    public static PlayerNormalMode getInstance() {
        return instance;
    }
}
