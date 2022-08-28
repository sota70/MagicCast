package distortiongate.magiccast.inventorymaincontents;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class InventoryMainContents {

    private ItemStack helmet;
    private ItemStack chestplate;
    private ItemStack leggings;
    private ItemStack boots;
    private ItemStack mainHand;
    private ItemStack offHand;

    public InventoryMainContents() {
        this.helmet = new ItemStack(Material.AIR);
        this.chestplate = new ItemStack(Material.AIR);
        this.leggings = new ItemStack(Material.AIR);
        this.boots = new ItemStack(Material.AIR);
        this.mainHand = new ItemStack(Material.AIR);
        this.offHand = new ItemStack(Material.AIR);
    }

    public void setHelmet(ItemStack helmet) {
        this.helmet = helmet;
    }

    public void setChestplate(ItemStack chestplate) {
        this.chestplate = chestplate;
    }

    public void setLeggings(ItemStack leggings) {
        this.leggings = leggings;
    }

    public void setBoots(ItemStack boots) {
        this.boots = boots;
    }

    public void setMainHand(ItemStack mainHand) {
        this.mainHand = mainHand;
    }

    public void setOffHand(ItemStack offHand) {
        this.offHand = offHand;
    }

    public ItemStack getHelmet() { return this.helmet; }

    public ItemStack getChestplate() { return this.chestplate; }

    public ItemStack getLeggings() { return this.leggings; }

    public ItemStack getBoots() { return this.boots; }

    public ItemStack getMainHand() { return this.mainHand; }

    public ItemStack getOffHand() { return this.offHand; }
}
