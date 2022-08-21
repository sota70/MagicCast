package distortiongate.magiccast.state.playerstate;

import org.bukkit.entity.Player;

public interface PlayerState {

    void execute(Player player);
    PlayerState getNextState();
}
