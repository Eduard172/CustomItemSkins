package me.eduard.customitemskins.Utils;

import me.eduard.customitemskins.CustomItemSkins;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Map;

@SuppressWarnings("all")
public class ItemUtils{
    public ItemUtils(){}
    public static ItemStack createItem(@Nonnull Material material, int amount, @Nullable String name, @Nullable ArrayList<String> lore, @Nullable Map<Enchantment, Short> enchants, boolean unbreakable, int nbtData){
        ItemStack thisItem = new ItemStack(material, amount);
        ItemMeta meta = thisItem.getItemMeta();
        if(name != null){
            assert meta != null;
            meta.setDisplayName(CustomItemSkins.format(name));
        }
        if(lore != null){
            for(String strings : lore){
                strings = CustomItemSkins.format(strings);
            }
            meta.setLore(lore);
        }
        if(enchants != null){
            for(Map.Entry<Enchantment, Short> thisMap : enchants.entrySet()){
                meta.addEnchant(thisMap.getKey(), (short) thisMap.getValue(), true);
            }
        }
        meta.setUnbreakable(unbreakable);
        if(nbtData != -1){
            meta.setCustomModelData(nbtData);
        }
        thisItem.setItemMeta(meta);
        return thisItem;
    }
    public static boolean hasNBTData(ItemStack item){
        return item.getItemMeta().hasCustomModelData();
    }
    public static ItemStack createCustomItemWithNBTData(ItemStack item, int nbtData){
        ItemMeta meta = item.getItemMeta();
        if(nbtData != -1){
            meta.setCustomModelData(nbtData);
            item.setItemMeta(meta);
        }
        return item;
    }
    public static void setNBTDataToItem(ItemStack item, int nbtData){
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(nbtData);
        item.setItemMeta(meta);
    }
}
