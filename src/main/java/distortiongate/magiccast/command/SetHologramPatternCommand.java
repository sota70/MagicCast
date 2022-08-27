package distortiongate.magiccast.command;

import distortiongate.magiccast.hologram.spawner.HologramSpawner;
import distortiongate.magiccast.hologram.spawner.HologramSpawnerFactory;
import distortiongate.magiccast.hologram.spawner.HologramSpawnerType;
import distortiongate.magiccast.hologram.spawner.PlayerHologramSpawnerStorage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetHologramPatternCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String playerName;
        String hologramSpawnerType;
        Player player;
        HologramSpawner hologramSpawner;
        PlayerHologramSpawnerStorage hologramSpawnerStorage = PlayerHologramSpawnerStorage.getInstance();
        if (args.length < 2) {
            return false;
        }
        playerName = args[0];
        hologramSpawnerType = args[1];
        player = Bukkit.getPlayer(playerName);
        hologramSpawner = HologramSpawnerFactory.create(HologramSpawnerType.valueOf(hologramSpawnerType));
        if (player == null) {
            return false;
        }
        hologramSpawnerStorage.setHologramSpawner(player, hologramSpawner);
        return true;
    }
}
