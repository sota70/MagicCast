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

public class FourHologramsSpawner implements HologramSpawner {

    private static FourHologramsSpawner instance = new FourHologramsSpawner();

    private FourHologramsSpawner() { }

    @Override
    public void spawn(
            HologramSpawnMethodType spawnMethodType,
            HologramOnTouchMethodType onTouchMethodType,
            HologramDespawnMethodType despawnMethodType,
            Player player
    ) {
        HologramSpawnerFactory.create(HologramSpawnerType.TWO_HOLOGRAMS).spawn(spawnMethodType, onTouchMethodType, despawnMethodType, player);
        Location playerLoc = player.getLocation();
        Location spawnLoc = HologramSpawnLocationCalculator.calc(playerLoc, 1.5, playerLoc.getYaw() - 30.0);
        // hologram2 setup
        spawnLoc.setY(playerLoc.getY() + 1.0);
        HologramFactory.create(
                spawnMethodType,
                onTouchMethodType,
                despawnMethodType,
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
                spawnMethodType,
                onTouchMethodType,
                despawnMethodType,
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
