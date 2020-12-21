package com.roharui.mc.gui;

import com.roharui.mc.data.DataManager;
import com.roharui.mc.gui.Items.BaseItem;
import com.roharui.mc.gui.Items.BoolItem;
import com.roharui.mc.gui.Items.ModeItem;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;

public class OpGUI extends BaseGUI{
    protected int INV_LINE = 3;

    class OpenItem extends BaseItem{
        DataManager dm = DataManager.getInstance();

        public OpenItem(){
            super(Material.DARK_OAK_DOOR, "새창 열기", new String[]{"BaseGUI 창을 엽니다."});
        }
    
        @Override
        public void handClick(Event e){
            InventoryClickEvent ev = (InventoryClickEvent) e;
            HumanEntity he = ev.getWhoClicked();
            dm.openGUI(he, "BaseGUI");
        }
    }

    public OpGUI(String inv_title) {
        super(inv_title);
        this.items.put(0, new BoolItem());
        this.items.put(1, new ModeItem());
        this.items.put(2, new OpenItem());

        this.setINV_LINE(3);
    }

}
