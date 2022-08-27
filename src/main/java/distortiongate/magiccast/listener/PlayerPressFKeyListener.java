package distortiongate.magiccast.listener;

import distortiongate.magiccast.state.playerstate.PlayerState;
import distortiongate.magiccast.state.playerstate.PlayerStateFactory;
import distortiongate.magiccast.state.playerstate.PlayerStateType;
import distortiongate.magiccast.state.playerstate.PlayerStatusStorage;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class PlayerPressFKeyListener implements Listener {

    @EventHandler
    public void onPressedF(PlayerSwapHandItemsEvent event) {
        PlayerStatusStorage playerStatusStorage = PlayerStatusStorage.getInstance();
        Player player = event.getPlayer();
        Block blockBelowPlayer = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
        Block blockOnGround = this.getBlockOnGround(blockBelowPlayer);
        double distanceFromGround = blockOnGround.getLocation().distance(player.getLocation());
        if (player.getGameMode() != GameMode.ADVENTURE) {
            return;
        }
        if (distanceFromGround >= 1.5) {
            player.sendMessage("You are in the air");
            return;
        }
        if (!playerStatusStorage.playerHasStatus(player)) {
            playerStatusStorage.setPlayerStatus(player, PlayerStateFactory.create(PlayerStateType.NORMAL));
        }
        this.setNextPlayerStatus(player);
        this.executePlayerStatus(player);
    }

    private Block getBlockOnGround(Block block) {
        if (block.getType() != Material.AIR) {
            return block;
        }
        return this.getBlockOnGround(block.getRelative(BlockFace.DOWN));
    }

    private void executePlayerStatus(Player player) {
        PlayerStatusStorage storage = PlayerStatusStorage.getInstance();
        storage.getPlayerStatus(player).execute(player);
    }

    public void setNextPlayerStatus(Player player) {
        PlayerStatusStorage storage = PlayerStatusStorage.getInstance();
        PlayerState playerStatus = storage.getPlayerStatus(player);
        storage.setPlayerStatus(player, playerStatus.getNextState());
    }
}
