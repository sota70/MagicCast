package distortiongate.magiccast.hologram.method.spawn;

import distortiongate.magiccast.hologram.Hologram;
import distortiongate.magiccast.hologram.PlayerHologramStorage;
import distortiongate.magiccast.inventorymaincontents.InventoryMainContents;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;

import java.util.UUID;

public class InvulnerableHologramSpawnMethod implements HologramSpawnMethod {

    private static InvulnerableHologramSpawnMethod instance = new InvulnerableHologramSpawnMethod();

    private InvulnerableHologramSpawnMethod() { }

    @Override
    public void spawn(Hologram hologram) {
        UUID hologramId = this.spawnHologram(hologram);
        hologram.setHologramId(hologramId);
        PlayerHologramStorage.getInstance().registerHologram(hologram.getOwner(), hologram);
    }

    public static InvulnerableHologramSpawnMethod getInstance() { return instance; }

    private UUID spawnHologram(Hologram hologram) {
        Location spawnLoc = hologram.getSpawnLocation().add(0.0, 200.0, 0.0);
        Location playerLoc = hologram.getOwner().getLocation();
        ArmorStand armorStand = (ArmorStand)spawnLoc.getWorld().spawnEntity(spawnLoc, EntityType.ARMOR_STAND);
        float playerDeg = playerLoc.getYaw();
        armorStand.setSmall(true);
        armorStand.setInvisible(true);
        armorStand.setGravity(false);
        armorStand.setInvulnerable(false);
        this.setInventoryMainContents(armorStand, hologram.getInventoryMainContents());
        // make armor stand look at the player
        playerDeg = playerDeg >= 0 ? playerDeg - 180 : playerDeg + 180;
        spawnLoc.setYaw(playerDeg);

        spawnLoc.add(0.0, -200.0, 0.0);
        armorStand.teleport(spawnLoc);
        return armorStand.getUniqueId();
    }

    private void setInventoryMainContents(ArmorStand armorStand, InventoryMainContents inventoryMainContents) {
        armorStand.setItem(EquipmentSlot.HEAD, inventoryMainContents.getHelmet());
        armorStand.setItem(EquipmentSlot.CHEST, inventoryMainContents.getChestplate());
        armorStand.setItem(EquipmentSlot.LEGS, inventoryMainContents.getLeggings());
        armorStand.setItem(EquipmentSlot.FEET, inventoryMainContents.getBoots());
        armorStand.setItem(EquipmentSlot.HAND, inventoryMainContents.getMainHand());
        armorStand.setItem(EquipmentSlot.OFF_HAND, inventoryMainContents.getOffHand());
    }
}
