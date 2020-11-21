package com.roharui.mc.gui.Items;

import com.roharui.mc.data.DataManager;
import com.roharui.mc.data.ImmunData;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class BoolItem extends BaseItem {
    private boolean flag = false;
    private static BoolItem self = null;

    public static BoolItem getInstance(){
        if(BoolItem.self == null){
            BoolItem.self = new BoolItem();
        }
        return BoolItem.self;
    }

    private BoolItem(){
        super();

        this.item = flag ? getOnItem() : getOffItem();
        this.handClick = (Event e) -> {
            InventoryClickEvent ev = (InventoryClickEvent) e;
            ImmunData imm = DataManager.ImmunMap.get((Player)ev.getWhoClicked());
            imm.setTest(!imm.isTest());
            ev.setCurrentItem(imm.isTest() ? getOnItem() : getOffItem());
            item = imm.isTest() ? getOnItem() : getOffItem();
        };
    }

    private ItemStack getOnItem(){
        return createGuiItem(Material.REDSTONE_BLOCK, ChatColor.WHITE + "끄기", new String[]{ChatColor.RED + "현재는 켜져 있는 상태입니다."});
    }

    private ItemStack getOffItem(){
        return createGuiItem(Material.STONE, ChatColor.WHITE + "켜기", new String[]{ChatColor.RED + "현재는 꺼져 있는 상태입니다."});
    }
}
