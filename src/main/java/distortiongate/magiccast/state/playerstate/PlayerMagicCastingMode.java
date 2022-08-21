package distortiongate.magiccast.state.playerstate;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerMagicCastingMode implements PlayerState {

    private static PlayerMagicCastingMode instance = new PlayerMagicCastingMode();

    private PlayerMagicCastingMode() { }

    @Override
    public void execute(Player player) {
        player.sendMessage(ChatColor.YELLOW + "You are currently on Magic Casting mode");
    }

    @Override
    public PlayerState getNextState() {
        return PlayerStateFactory.create(PlayerStateType.NORMAL);
    }

    public static PlayerMagicCastingMode getInstance() {
        return instance;
    }
}
