package distortiongate.magiccast.musicplayer;

import org.bukkit.entity.Player;

import java.util.*;

public class MusicPlayerStorage {

    private static MusicPlayerStorage instance = new MusicPlayerStorage();
    private Map<UUID, List<Integer>> musicPlayers = new HashMap<>();

    private MusicPlayerStorage() { }

    public void addMusicPlayer(Player player, int musicPlayerId) {
        if (!this.isPlayerRegistered(player)) {
            this.musicPlayers.put(player.getUniqueId(), new ArrayList<>(List.of(musicPlayerId)));
            return;
        }
        if (this.getMusicPlayers(player).contains(musicPlayerId)) {
            return;
        }
        this.getMusicPlayers(player).add(musicPlayerId);
    }

    public void removeMusicPlayer(Player player, int musicPlayerId) {
        if (!this.isPlayerRegistered(player)) {
            return;
        }
        if (!this.getMusicPlayers(player).contains(musicPlayerId)) {
            return;
        }
        this.getMusicPlayers(player).remove(this.getMusicPlayers(player).indexOf(musicPlayerId));
    }

    public void clearMusicPlayers(Player player) {
        if (!this.isPlayerRegistered(player)) {
            return;
        }
        this.musicPlayers.remove(player.getUniqueId());
    }

    public boolean isPlayerRegistered(Player player) {
        return this.musicPlayers.containsKey(player);
    }

    public List<Integer> getMusicPlayers(Player player) {
        return this.musicPlayers.get(player.getUniqueId());
    }

    public static MusicPlayerStorage getInstance() { return instance; }
}
