package me.eduard.customitemskins.Utils;

import me.eduard.customitemskins.CustomItemSkins;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("all")
public class InventoryUtils {

    private String inventoryTitle = CustomItemSkins.format("&cNapward inventory");
    private volatile Inventory inventory;
    private final Player player;
    public InventoryUtils(Player player){
        this.player = player;
        inventory = Bukkit.createInventory(player, 54, inventoryTitle);
    }

    public void fillNullSpots(){
        for(int i = 0; i < inventory.getSize(); i++){
            if(inventory.getItem(i) == null){
                inventory.setItem(i, new ItemStack(Material.ACACIA_BOAT));
            }
        }
    }

    public void addItem(ItemStack... items){
        inventory.addItem(items);
    }
    public void setItem(int spot, ItemStack item){
        inventory.setItem(spot, item);
    }

    public void openInventory(){
        if(inventory == null){
            throw new NullPointerException("Ai uitat sa dai cu createInventory() prin cod.");
        }
        player.openInventory(inventory);
    }
    public void fillCorners(){
        if(inventory == null){
            throw new NullPointerException("Ai uitat sa dai cu createInventory() prin cod.");
        }
        for(int i = 0; i < 10; i++){
            inventory.setItem(i, new ItemStack(Material.ACACIA_BOAT));
            inventory.setItem(i+45, new ItemStack(Material.ACACIA_BOAT));
        }
        int randomThing = 1;
        while(randomThing <= 3){
            inventory.setItem(randomThing*9, new ItemStack(Material.ACACIA_BOAT));
            inventory.setItem(randomThing*9+8, new ItemStack(Material.ACACIA_BOAT));
            randomThing++;
        }
    }
}
