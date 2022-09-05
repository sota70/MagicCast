package distortiongate.magiccast.state.playerstate;

import distortiongate.magiccast.hologram.method.despawn.HologramDespawnMethodType;
import distortiongate.magiccast.hologram.method.ontouch.HologramOnTouchMethodType;
import distortiongate.magiccast.hologram.method.spawn.HologramSpawnMethodType;
import distortiongate.magiccast.hologram.spawner.HologramSpawner;
import distortiongate.magiccast.hologram.spawner.PlayerHologramSpawnerStorage;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PlayerMagicCastingMode implements PlayerState {

    private static PlayerMagicCastingMode instance = new PlayerMagicCastingMode();

    private PlayerMagicCastingMode() { }

    @Override
    public void execute(Player player) {
        HologramSpawner hologramSpawner = PlayerHologramSpawnerStorage.getInstance().getHologramSpawner(player);
        // put spawn process here
        hologramSpawner.spawn(HologramSpawnMethodType.PACKET, HologramOnTouchMethodType.DEFAULT, HologramDespawnMethodType.PACKET, player);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
    }

    @Override
    public PlayerState getNextState() {
        return PlayerStateFactory.create(PlayerStateType.NORMAL);
    }

    public static PlayerMagicCastingMode getInstance() {
        return instance;
    }
}
