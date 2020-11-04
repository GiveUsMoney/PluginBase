package com.roharui.mc.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.roharui.mc.gui.Items.BaseItem;

public class BaseGUI {
    private int INV_LINE = 1;
    private String INV_TITLE = "BaseGUI";
    private final Inventory inv;

    private List<BaseItem> items = new ArrayList<BaseItem>(
        Arrays.asList(new BaseItem(Material.STONE, "테스트", new String[]{"이건 테스트입니다.", "잘 됬으면 좋겠다."}))
    );

    public BaseGUI(){
        inv = Bukkit.createInventory(null, INV_LINE * 9, INV_TITLE);
    }
    
    //open 메소드에 플레이어를 매개변수로 받고 정해진(상속받은) GUI를 열어줌
    public void open(final HumanEntity player) {
        addItem(items);
        player.openInventory(inv);
    }

    private void addItem(List<BaseItem> items){
        for(BaseItem i : items) {
            inv.addItem(i.createGuiItem());
        }
    }
}
