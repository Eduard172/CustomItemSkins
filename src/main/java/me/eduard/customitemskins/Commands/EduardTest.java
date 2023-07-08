package me.eduard.customitemskins.Commands;

import me.eduard.customitemskins.Utils.InventoryUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EduardTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        InventoryUtils utils = new InventoryUtils(player);
        if(args.length == 0){
            utils.openInventory();
        }else if(args.length == 1){
            utils.fillNullSpots();
            utils.openInventory();
        }else{
            utils.fillCorners();
            utils.openInventory();
        }
        return true;
    }
}
