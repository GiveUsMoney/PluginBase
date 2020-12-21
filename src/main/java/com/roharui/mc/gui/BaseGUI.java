package com.roharui.mc.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;

import lombok.Data;

import java.util.HashMap;

import com.roharui.mc.gui.Items.BaseItem;
import com.roharui.mc.gui.Items.CloseItem;

@Data
public class BaseGUI {
    protected int INV_LINE = 1;
    protected String INV_TITLE = "GUI";
    private Inventory inv = null;

    public HashMap<Integer, BaseItem> items = new HashMap<>();

    public BaseGUI(String inv_title){
        this.setINV_TITLE(inv_title);
    }

    private void createInv(){
        if(this.inv == null){
            this.items.put((INV_LINE * 9) - 1, new CloseItem());
            this.inv = Bukkit.createInventory(null, INV_LINE * 9, this.INV_TITLE);
        }
    }
    
    //open 메소드에 플레이어를 매개변수로 받고 정해진(상속받은) GUI를 열어줌
    public void open(final HumanEntity player) {
        this.createInv();

        for(Integer i : items.keySet()) {
            inv.setItem(i, items.get(i).showItem(player));
        }

        player.openInventory(inv);
    }
}
