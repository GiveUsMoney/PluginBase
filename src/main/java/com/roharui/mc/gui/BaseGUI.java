package com.roharui.mc.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

import com.roharui.mc.gui.Items.BaseItem;

public class BaseGUI {
    private int INV_LINE = 1;
    private String INV_TITLE = "BaseGUI";
    private final Inventory inv;

    public static HashMap<Integer, BaseItem> items = new HashMap<>(){
        private static final long serialVersionUID = 1L;

        {
        put(8, new BaseItem(
            Material.ENDER_EYE, 
            "테스트", 
            new String[]{"이건 테스트입니다.", "잘 됬으면 좋겠다."},
            (Event e) -> {
                InventoryClickEvent ev = (InventoryClickEvent) e;
                ev.getView().close();
            }
        ));
    }};

    public BaseGUI(){
        inv = Bukkit.createInventory(null, INV_LINE * 9, INV_TITLE);
    }

    public BaseGUI(int inv_line, String inv_title){
        this.INV_LINE = inv_line;
        this.INV_TITLE = inv_title;
        inv = Bukkit.createInventory(null, INV_LINE * 9, INV_TITLE);
    }
    
    //open 메소드에 플레이어를 매개변수로 받고 정해진(상속받은) GUI를 열어줌
    public void open(final HumanEntity player) {
        addItem();
        player.openInventory(inv);
    }

    private void addItem(){
        for(Integer i : items.keySet()) {
            inv.setItem(i, items.get(i).createGuiItem());
        }
    }
}
