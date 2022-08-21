package distortiongate.magiccast.hologram.method.spawn;

import distortiongate.magiccast.PlayerHologramStorage;
import distortiongate.magiccast.hologram.Hologram;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class DefaultHologramSpawnMethod implements HologramSpawnMethod {

    private static DefaultHologramSpawnMethod instance = new DefaultHologramSpawnMethod();

    @Override
    public void spawn(Hologram hologram) {
        Location spawnLoc = hologram.getSpawnLocation();
        ArmorStand armorStand = (ArmorStand)spawnLoc.getWorld().spawnEntity(spawnLoc, EntityType.ARMOR_STAND);
        armorStand.setSmall(true);
        armorStand.setInvisible(false);
        armorStand.setGravity(false);
        // put holograms uuid player is using here
        PlayerHologramStorage.getInstance().registerHologram(hologram.getOwner(), armorStand.getUniqueId());

        // uses a custom data model item
        armorStand.setItem(EquipmentSlot.CHEST, new ItemStack(Material.DIAMOND_CHESTPLATE));
    }

    public static DefaultHologramSpawnMethod getInstance() {
        return instance;
    }
}
