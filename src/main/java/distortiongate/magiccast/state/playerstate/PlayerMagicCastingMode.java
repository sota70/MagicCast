package distortiongate.magiccast.state.playerstate;

import distortiongate.magiccast.hologram.Hologram;
import distortiongate.magiccast.hologram.factory.HologramFactory;
import distortiongate.magiccast.hologram.factory.HologramMethodType;
import distortiongate.magiccast.hologram.method.move.HologramMoveMethod;
import distortiongate.magiccast.hologram.method.ontouch.HologramOnTouchMethod;
import distortiongate.magiccast.hologram.method.spawn.HologramSpawnMethod;
import distortiongate.magiccast.hologram.spawner.HologramSpawner;
import distortiongate.magiccast.hologram.spawner.HologramSpawnerFactory;
import distortiongate.magiccast.hologram.spawner.HologramSpawnerType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerMagicCastingMode implements PlayerState {

    private static PlayerMagicCastingMode instance = new PlayerMagicCastingMode();

    private PlayerMagicCastingMode() { }

    @Override
    public void execute(Player player) {
        HologramSpawner hologramSpawner = HologramSpawnerFactory.create(HologramSpawnerType.TWO_HOLOGRAMS);
        Hologram hologram = HologramFactory.create(HologramMethodType.DEFAULT, player, player.getLocation());
        // put spawn process here
        hologramSpawner.spawn(hologram);
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
