package distortiongate.magiccast.hologram.method.spawn;

import distortiongate.magiccast.PlayerHologramStorage;
import distortiongate.magiccast.hologram.Hologram;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class DefaultHologramSpawnMethod implements HologramSpawnMethod {

    private static DefaultHologramSpawnMethod instance = new DefaultHologramSpawnMethod();

    private DefaultHologramSpawnMethod() { }

    @Override
    public void spawn(Hologram hologram) {
        UUID hologramId = this.spawnHologram(hologram);
        hologram.setHologramId(hologramId);
        PlayerHologramStorage.getInstance().registerHologram(hologram.getOwner(), hologram);
    }

    public static DefaultHologramSpawnMethod getInstance() {
        return instance;
    }

    private UUID spawnHologram(Hologram hologram) {
        Location spawnLoc = hologram.getSpawnLocation().add(0.0, 200.0, 0.0);
        Location playerLoc = hologram.getOwner().getLocation();
        ArmorStand armorStand = (ArmorStand)spawnLoc.getWorld().spawnEntity(spawnLoc, EntityType.ARMOR_STAND);
        float playerDeg = playerLoc.getYaw();
        armorStand.setSmall(true);
        armorStand.setInvisible(true);
        armorStand.setGravity(false);
        armorStand.setItem(EquipmentSlot.CHEST, new ItemStack(Material.DIAMOND_CHESTPLATE));
        // make armor stand look at the player
        playerDeg = playerDeg >= 0 ? playerDeg - 180 : playerDeg + 180;
        spawnLoc.setYaw(playerDeg);

        spawnLoc.add(0.0, -200.0, 0.0);
        armorStand.teleport(spawnLoc);
        return armorStand.getUniqueId();
    }
}
