package com.roharui.mc;

import java.util.logging.Logger;

import com.roharui.mc.data.DataManager;
import com.roharui.mc.data.ImmunData;
import com.roharui.mc.gui.BaseGUI;

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
    private DataManager dm = DataManager.getInstance();

    @EventHandler
    public void onBreak(BlockPlaceEvent e){

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        dm.ImmunMap.put(e.getPlayer().getUniqueId().toString(), new ImmunData());
    }

    @EventHandler
    public void onInventory(InventoryClickEvent e){
        InventoryView inv = e.getView();
        Player p = (Player)e.getWhoClicked();

        if (e.getCurrentItem() == null) return;

        int x = inv.getInventory(0).getSize();
        BaseGUI gui = this.dm.getGUI(p, inv.getTitle());

        if(inv.getItem(x - 1).getType().equals(Material.ENDER_EYE) && 
            gui != null)
        {
            try {
                gui.items.get(e.getRawSlot()).handClick(e);
            } catch (Exception err) {
                err.printStackTrace();
            } finally {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        // if(e.getEntityType().equals(EntityType.PLAYER)){
        //     Player p = (Player) e.getEntity();
        //     ImmunData imm = this.dm.ImmunMap.get(p.getUniqueId().toString());
        //     e.setCancelled(imm.isTest());
        // }
    }
}
