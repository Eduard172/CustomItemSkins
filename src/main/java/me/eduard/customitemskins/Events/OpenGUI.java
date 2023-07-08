package me.eduard.customitemskins.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class OpenGUI implements Listener {

    @EventHandler
    public void shiftClick (PlayerInteractEvent event) {
        if (event.getPlayer().isSneaking()) {
            if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                System.out.println("test1");
            }
        }
    }
}
