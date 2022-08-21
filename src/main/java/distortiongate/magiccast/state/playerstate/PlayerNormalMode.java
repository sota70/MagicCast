package distortiongate.magiccast.state.playerstate;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerNormalMode implements PlayerState {

    private static PlayerNormalMode instance = new PlayerNormalMode();

    private PlayerNormalMode() { }

    @Override
    public void execute(Player player) {
        player.sendMessage(ChatColor.YELLOW + "You are currently on Normal mode");
    }

    @Override
    public PlayerState getNextState() {
        return PlayerStateFactory.create(PlayerStateType.MAGIC_CASTING);
    }

    public static PlayerNormalMode getInstance() {
        return instance;
    }
}
