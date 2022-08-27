package distortiongate.magiccast.castaction;

import org.bukkit.entity.Player;

public class PlayerCastActionDisplayer implements PlayerCastActionStorageObserver {

    private static PlayerCastActionDisplayer instance = new PlayerCastActionDisplayer();

    private PlayerCastActionDisplayer() { }

    @Override
    public void handle(PlayerCastActionStorage storage, Player player) {
        player.sendMessage("Action: " + storage.getAction(player));
        player.sendTitle(" ", storage.getAction(player));
    }

    public static PlayerCastActionDisplayer getInstance() { return instance; }
}
