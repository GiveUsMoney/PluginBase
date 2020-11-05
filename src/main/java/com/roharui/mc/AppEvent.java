package com.roharui.mc;

import com.roharui.mc.gui.BaseGUI;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

public class AppEvent implements Listener{

    @EventHandler
    public void onBreak(BlockPlaceEvent e){

    }

    @EventHandler
    public void onInventory(InventoryClickEvent e){
        InventoryView inv = e.getView();

        if (e.getCurrentItem() == null) return;

        int x = inv.getInventory(0).getSize();

        if(inv.getItem(x - 1).getType().equals(Material.ENDER_EYE) && 
            inv.getTitle().contains("GUI"))
        {
            BaseGUI.items.get(e.getRawSlot()).getHandClick().accept(e);
            e.setCancelled(true);
        }
    }
}
