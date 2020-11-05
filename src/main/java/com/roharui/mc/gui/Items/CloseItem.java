package com.roharui.mc.gui.Items;

import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CloseItem extends BaseItem {
    
    public CloseItem(){
        super(Material.ENDER_EYE, "닫기", new String[]{"클릭하시면 화면을 닫습니다."}, (Event e) -> {
            InventoryClickEvent ev = (InventoryClickEvent) e;
            ev.getView().close();
        });
    }
}
