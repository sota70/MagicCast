package distortiongate.magiccast.state.playerstate;

import distortiongate.magiccast.hologram.Hologram;
import distortiongate.magiccast.hologram.factory.HologramFactory;
import distortiongate.magiccast.hologram.factory.HologramMethodType;
import distortiongate.magiccast.hologram.spawner.HologramSpawner;
import distortiongate.magiccast.hologram.spawner.PlayerHologramSpawnerStorage;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerMagicCastingMode implements PlayerState {

    private static PlayerMagicCastingMode instance = new PlayerMagicCastingMode();

    private PlayerMagicCastingMode() { }

    @Override
    public void execute(Player player) {
        HologramSpawner hologramSpawner = PlayerHologramSpawnerStorage.getInstance().getHologramSpawner(player);
        // put spawn process here
        hologramSpawner.spawn(HologramMethodType.DEFAULT, player);
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
