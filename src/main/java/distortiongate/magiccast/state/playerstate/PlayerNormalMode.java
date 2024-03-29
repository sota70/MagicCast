package distortiongate.magiccast.state.playerstate;

import distortiongate.magiccast.castaction.PlayerCastActionStorage;
import distortiongate.magiccast.hologram.Hologram;
import distortiongate.magiccast.hologram.PlayerHologramStorage;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PlayerNormalMode implements PlayerState {

    private static PlayerNormalMode instance = new PlayerNormalMode();

    private PlayerNormalMode() { }

    @Override
    public void execute(Player player) {
        PlayerHologramStorage playerHologramStorage = PlayerHologramStorage.getInstance();
        PlayerCastActionStorage playerCastActionStorage = PlayerCastActionStorage.getInstance();
        if (!playerHologramStorage.playerHasHolograms(player)) {
            return;
        }
        playerHologramStorage.getHolograms(player).forEach(Hologram::despawn);
        playerHologramStorage.clearHolograms(player);
        playerCastActionStorage.clearAction(player);
        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 1);
    }

    @Override
    public PlayerState getNextState() {
        return PlayerStateFactory.create(PlayerStateType.MAGIC_CASTING);
    }

    public static PlayerNormalMode getInstance() {
        return instance;
    }
}
