package com.roharui.mc;

import com.roharui.mc.data.DataManager;
import com.roharui.mc.data.PlayerData;
import com.roharui.mc.gui.BaseGUI;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.InventoryView;

public class AppEvent implements Listener{
    private DataManager dm = DataManager.getInstance();

    @EventHandler
    public void onBreak(BlockPlaceEvent e){

    }
    
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e){
        BaseGUI gui = dm.getPlayerData(e.getPlayer()).getLastGUI();
        if(gui == null) return;
        gui.open(e.getPlayer());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        dm.ImmunMap.put(e.getPlayer().getUniqueId().toString(), new PlayerData());
    }

    @EventHandler
    public void onInventory(InventoryClickEvent e){
        InventoryView inv = e.getView();
        HumanEntity p = e.getWhoClicked();

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
        //     BaseGUI b = this.dm.getGUI(p, "BaseGUI");
        // }
    }
}
