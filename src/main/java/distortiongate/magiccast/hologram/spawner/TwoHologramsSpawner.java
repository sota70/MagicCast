package distortiongate.magiccast.hologram.spawner;

import distortiongate.magiccast.HologramSpawnLocationCalculator;
import distortiongate.magiccast.hologram.Hologram;
import distortiongate.magiccast.hologram.factory.HologramFactory;
import distortiongate.magiccast.hologram.factory.HologramMethodType;
import distortiongate.magiccast.inventorymaincontents.InventoryMainContents;
import distortiongate.magiccast.inventorymaincontents.InventoryMainContentsBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TwoHologramsSpawner implements HologramSpawner {

    private static TwoHologramsSpawner instance = new TwoHologramsSpawner();

    private TwoHologramsSpawner() { }

    @Override
    public void spawn(HologramMethodType methodType, Player player) {
        Location playerLoc = player.getLocation();
        // hologram0 setup
        Location spawnLoc = HologramSpawnLocationCalculator.calc(playerLoc, 1.5, playerLoc.getYaw());
        spawnLoc.setY(playerLoc.getY() + 1.5);
        HologramFactory.create(
                methodType,
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
                methodType,
                "B",
                player,
                spawnLoc,
                new InventoryMainContentsBuilder()
                        .setHelmet(this.makeCustomHelmet(Material.BOOK, 2))
                        .build()
        ).spawn();
    }

    private ItemStack makeCustomHelmet(Material type, int data) {
        ItemStack chestplate = new ItemStack(type);
        ItemMeta meta = chestplate.getItemMeta();
        meta.setCustomModelData(data);
        chestplate.setItemMeta(meta);
        return chestplate;
    }

    public static TwoHologramsSpawner getInstance() {
        return instance;
    }
}
