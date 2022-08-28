package distortiongate.magiccast.hologram.spawner;

import distortiongate.magiccast.HologramSpawnLocationCalculator;
import distortiongate.magiccast.hologram.factory.HologramFactory;
import distortiongate.magiccast.hologram.factory.HologramMethodType;
import distortiongate.magiccast.inventorymaincontents.InventoryMainContentsBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FourHologramsSpawner implements HologramSpawner {

    private static FourHologramsSpawner instance = new FourHologramsSpawner();

    private FourHologramsSpawner() { }

    @Override
    public void spawn(HologramMethodType methodType, Player player) {
        HologramSpawnerFactory.create(HologramSpawnerType.TWO_HOLOGRAMS).spawn(methodType, player);
        Location playerLoc = player.getLocation();
        Location spawnLoc = HologramSpawnLocationCalculator.calc(playerLoc, 1.5, playerLoc.getYaw() - 30.0);
        // hologram2 setup
        spawnLoc.setY(playerLoc.getY() + 1.0);
        HologramFactory.create(
                methodType,
                "C",
                player,
                spawnLoc,
                new InventoryMainContentsBuilder()
                        .setHelmet(this.makeCustomHelmet(Material.BOOK, 3))
                        .build()
        ).spawn();

        // hologram3 setup
        spawnLoc = HologramSpawnLocationCalculator.calc(playerLoc, 1.5, playerLoc.getYaw() + 30.0);
        spawnLoc.setY(playerLoc.getY() + 1.0);
        HologramFactory.create(
                methodType,
                "D",
                player,
                spawnLoc,
                new InventoryMainContentsBuilder()
                        .setHelmet(this.makeCustomHelmet(Material.BOOK, 4))
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

    public static FourHologramsSpawner getInstance() { return instance; }
}
