package com.roharui.mc.gui.Items;

import com.roharui.mc.App;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class BoolItem extends BaseItem {
    private boolean flag = true;
    private static BoolItem self = null;

    public static BoolItem getInstance(){
        if(BoolItem.self == null){
            BoolItem.self = new BoolItem();
        }
        return BoolItem.self;
    }

    private BoolItem(){
        super();

        App.logger.info("bool item created");

        this.item = getOnItem();
        this.handClick = (Event e) -> {
            InventoryClickEvent ev = (InventoryClickEvent) e;
            flag = !flag;
            ev.setCurrentItem(flag ? getOnItem() : getOffItem());
        };
    }

    private ItemStack getOnItem(){
        return createGuiItem(Material.REDSTONE_BLOCK, ChatColor.WHITE + "끄기", new String[]{ChatColor.RED + "현재는 켜져 있는 상태입니다."});
    }

    private ItemStack getOffItem(){
        return createGuiItem(Material.STONE, ChatColor.WHITE + "켜기", new String[]{ChatColor.RED + "현재는 꺼져 있는 상태입니다."});
    }
}
