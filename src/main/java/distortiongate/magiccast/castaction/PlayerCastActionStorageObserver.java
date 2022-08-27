package distortiongate.magiccast.castaction;

import org.bukkit.entity.Player;

public interface PlayerCastActionStorageObserver {

    void handle(PlayerCastActionStorage storage, Player player);
}
