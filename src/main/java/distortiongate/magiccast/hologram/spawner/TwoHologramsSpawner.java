package distortiongate.magiccast.hologram.spawner;

import distortiongate.magiccast.HologramSpawnLocationCalculator;
import distortiongate.magiccast.hologram.factory.HologramFactory;
import distortiongate.magiccast.hologram.method.despawn.HologramDespawnMethodType;
import distortiongate.magiccast.hologram.method.ontouch.HologramOnTouchMethodType;
import distortiongate.magiccast.hologram.method.spawn.HologramSpawnMethodType;
import distortiongate.magiccast.inventorymaincontents.InventoryMainContentsBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TwoHologramsSpawner implements HologramSpawner {

    private static TwoHologramsSpawner instance = new TwoHologramsSpawner();

    private TwoHologramsSpawner() { }

    @Override
    public void spawn(
            HologramSpawnMethodType spawnMethodType,
            HologramOnTouchMethodType onTouchMethodType,
            HologramDespawnMethodType despawnMethodType, Player player
    ) {
        Location playerLoc = player.getLocation();
        // hologram0 setup
        Location spawnLoc = HologramSpawnLocationCalculator.calc(playerLoc, 1.5, playerLoc.getYaw());
        spawnLoc.setY(playerLoc.getY() + 1.5);
        HologramFactory.create(
                spawnMethodType,
                onTouchMethodType,
                despawnMethodType,
                "A",
                player,
                spawnLoc,
                new InventoryMainContentsBuilder()
                        .setHelmet(this.makeCustomHelmet(Material.BOOK, 1))
                        .build()
        ).spawn();

        // hologram 1 setup
        spawnLoc = HologramSpawnLocationCalculator.calc(playerLoc, 1.5, playerLoc.getYaw());
        spawnLoc.setY(playerLoc.getY() + 0.5);
        HologramFactory.create(
                spawnMethodType,
                onTouchMethodType,
                despawnMethodType,
                "B",
                player,
                spawnLoc,
                new InventoryMainContentsBuilder()
                        .setHelmet(this.makeCustomHelmet(Material.BOOK, 2))
                        .build()
        ).spawn();
    }

    private ItemStack makeCustomHelmet(Material type, int data) {
        ItemStack helmet = new ItemStack(type);
        ItemMeta meta = helmet.getItemMeta();
        meta.setCustomModelData(data);
        helmet.setItemMeta(meta);
        return helmet;
    }

    public static TwoHologramsSpawner getInstance() {
        return instance;
    }
}
