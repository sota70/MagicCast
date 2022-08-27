package distortiongate.magiccast.state.playerstate;

import distortiongate.magiccast.Magiccast;
import distortiongate.magiccast.hologram.Hologram;
import distortiongate.magiccast.hologram.factory.HologramFactory;
import distortiongate.magiccast.hologram.factory.HologramMethodType;
import distortiongate.magiccast.hologram.spawner.HologramSpawner;
import distortiongate.magiccast.hologram.spawner.HologramSpawnerFactory;
import distortiongate.magiccast.hologram.spawner.HologramSpawnerType;
import distortiongate.magiccast.hologram.spawner.PlayerHologramSpawnerStorage;
import net.Indyuce.mmocore.api.MMOCoreAPI;
import net.Indyuce.mmocore.api.player.PlayerData;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerMagicCastingMode implements PlayerState {

    private static PlayerMagicCastingMode instance = new PlayerMagicCastingMode();

    private PlayerMagicCastingMode() { }

    @Override
    public void execute(Player player) {
        HologramSpawner hologramSpawner = PlayerHologramSpawnerStorage.getInstance().getHologramSpawner(player);
        Hologram hologram = HologramFactory.create(HologramMethodType.DEFAULT, "", player, player.getLocation());
        // put spawn process here
        hologramSpawner.spawn(hologram);
        player.sendMessage(ChatColor.YELLOW + "You are currently on Magic Casting mode");

        // test mmocore api
//        MMOCoreAPI api = new MMOCoreAPI(Magiccast.getInstance());
//        PlayerData playerData = api.getPlayerData(player);
        // get all skills' name
//        playerData.getProfess().getSkills().forEach((skill) -> {
//            player.sendMessage("SkillName: " + skill.getSkill().getName());
//        });
    }

    @Override
    public PlayerState getNextState() {
        return PlayerStateFactory.create(PlayerStateType.NORMAL);
    }

    public static PlayerMagicCastingMode getInstance() {
        return instance;
    }
}
