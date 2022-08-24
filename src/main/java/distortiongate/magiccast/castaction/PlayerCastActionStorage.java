package distortiongate.magiccast.castaction;

import org.bukkit.entity.Player;

import java.util.*;

// TODO: make it observer pattern to notify to player magic caster class
public class PlayerCastActionStorage {

    private static PlayerCastActionStorage instance = new PlayerCastActionStorage();
    private Map<Player, String> playerAction = new HashMap<>();
    private List<PlayerCastActionStorageObserver> storageObservers = new ArrayList<>();

    private PlayerCastActionStorage() { }

    public static PlayerCastActionStorage getInstance() { return instance; }

    public void setAction(Player player, String newAction) {
        this.playerAction.put(player, newAction);
        this.notifyToObservers();
    }

    public void notifyToObservers() {
        this.storageObservers.forEach((observer) -> {
            observer.handle(this);
        });
    }

    public void addObserver(PlayerCastActionStorageObserver observer) {
        if (this.storageObservers.contains(observer)) {
            return;
        }
        this.storageObservers.add(observer);
    }

    public void removeObserver(PlayerCastActionStorageObserver observer) {
        if (!this.storageObservers.contains(observer)) {
            return;
        }
        this.storageObservers.remove(this.storageObservers.indexOf(observer));
    }

    public String getAction(Player player) {
        return this.playerAction.get(player);
    }

    public boolean hasAction(Player player) {
        return this.getAction(player) != null;
    }

    public Map<Player, String> getPlayerAction() { return this.playerAction; }
}
