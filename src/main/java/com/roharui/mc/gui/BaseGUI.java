package com.roharui.mc.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

import com.roharui.mc.gui.Items.BaseItem;
import com.roharui.mc.gui.Items.BoolItem;
import com.roharui.mc.gui.Items.CloseItem;
import com.roharui.mc.gui.Items.ModeItem;

public class BaseGUI {
    private int INV_LINE = 1;
    private final Inventory inv;

    public HashMap<Integer, BaseItem> items = new HashMap<>(){
        private static final long serialVersionUID = 1L;
        {
            put(0, new BoolItem());
            put(1, new ModeItem());
        }
    };

    public BaseGUI(int inv_line, String inv_title){
        this.items.put((inv_line * 9) - 1, new CloseItem());
        inv = Bukkit.createInventory(null, INV_LINE * 9, inv_title);
    }
    
    //open 메소드에 플레이어를 매개변수로 받고 정해진(상속받은) GUI를 열어줌
    public void open(final HumanEntity player) {
        Player p = (Player) player;

        for(Integer i : items.keySet()) {
            inv.setItem(i, items.get(i).showItem(p));
        }

        player.openInventory(inv);
    }
}
