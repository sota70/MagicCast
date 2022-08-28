package distortiongate.magiccast.inventorymaincontents;

import org.bukkit.inventory.ItemStack;

public class InventoryMainContentsBuilder {

    private InventoryMainContents inventoryMainContents;

    public InventoryMainContentsBuilder() {
        this.inventoryMainContents = new InventoryMainContents();
    }

    public InventoryMainContents build() { return this.inventoryMainContents; }

    public InventoryMainContentsBuilder setHelmet(ItemStack helmet) {
        this.inventoryMainContents.setHelmet(helmet);
        return this;
    }

    public InventoryMainContentsBuilder setChestplate(ItemStack chestplate) {
        this.inventoryMainContents.setChestplate(chestplate);
        return this;
    }

    public InventoryMainContentsBuilder setLeggings(ItemStack leggings) {
        this.inventoryMainContents.setLeggings(leggings);
        return this;
    }

    public InventoryMainContentsBuilder setBoots(ItemStack boots) {
        this.inventoryMainContents.setBoots(boots);
        return this;
    }

    public InventoryMainContentsBuilder setMainHand(ItemStack mainHand) {
        this.inventoryMainContents.setMainHand(mainHand);
        return this;
    }

    public InventoryMainContentsBuilder setOffHand(ItemStack offHand) {
        this.inventoryMainContents.setOffHand(offHand);
        return this;
    }
}
