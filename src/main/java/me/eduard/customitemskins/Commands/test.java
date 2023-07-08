package me.eduard.customitemskins.Commands;

import me.eduard.customitemskins.Utils.ItemUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class test implements CommandExecutor {
    @SuppressWarnings("all")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        ItemStack item = ItemUtils.createCustomItemWithNBTData(player.getInventory().getItemInMainHand(), -1); //((Player) sender).getInventory().getItemInMainHand();
        if (Integer.parseInt(args[0]) == 12) ItemUtils.setNBTDataToItem(item, 12);
        if (Integer.parseInt(args[0]) == 13) ItemUtils.setNBTDataToItem(item, 13);
        if (Integer.parseInt(args[0]) == 14) ItemUtils.setNBTDataToItem(item, 14);
        if (Integer.parseInt(args[0]) == 15) ItemUtils.setNBTDataToItem(item, 15);
        player.getInventory().setItem(player.getInventory().getHeldItemSlot(), item);
        return true;
    }
}
