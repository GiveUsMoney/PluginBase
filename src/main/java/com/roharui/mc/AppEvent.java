package com.roharui.mc;

import java.util.HashMap;

import com.roharui.mc.data.DataManager;
import com.roharui.mc.data.ImmunData;
import com.roharui.mc.gui.BaseGUI;
import com.roharui.mc.gui.Items.BaseItem;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.InventoryView;

public class AppEvent implements Listener{

    @EventHandler
    public void onBreak(BlockPlaceEvent e){

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        DataManager.ImmunMap.put(e.getPlayer(), new ImmunData());
    }

    @EventHandler
    public void onInventory(InventoryClickEvent e){
        InventoryView inv = e.getView();

        if (e.getCurrentItem() == null) return;

        int x = inv.getInventory(0).getSize();

        if(inv.getItem(x - 1).getType().equals(Material.ENDER_EYE) && 
            inv.getTitle().contains("GUI"))
        {
            try {
                HashMap<Integer, ? extends BaseItem> hashmap = (HashMap<Integer, ? extends BaseItem>) Class
                        .forName("com.roharui.mc.gui." + inv.getTitle()).getField("items").get(null);
                hashmap.get(e.getRawSlot()).getHandClick().accept(e);
                e.setCancelled(true);
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if(e.getEntityType().equals(EntityType.PLAYER)){
            ImmunData imm = DataManager.ImmunMap.get((Player) e.getEntity());
            e.setCancelled(imm.isTest());
        }
        
    }
}
