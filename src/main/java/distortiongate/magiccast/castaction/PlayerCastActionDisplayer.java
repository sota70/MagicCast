package distortiongate.magiccast.castaction;

public class PlayerCastActionDisplayer implements PlayerCastActionStorageObserver {

    private static PlayerCastActionDisplayer instance = new PlayerCastActionDisplayer();

    private PlayerCastActionDisplayer() { }

    @Override
    public void handle(PlayerCastActionStorage storage) {
        storage.getPlayerAction().forEach((player, action) -> {
            player.sendMessage("Action: " + action);
        });
    }

    public static PlayerCastActionDisplayer getInstance() { return instance; }
}
