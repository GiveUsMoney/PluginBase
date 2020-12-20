package com.roharui.mc.gui.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BoolItem extends BaseItem {
    private boolean flag = false;

    protected ItemInfo onItem;
    protected ItemInfo offItem;

    public BoolItem(){
        super();

        onItem = new ItemInfo(Material.REDSTONE_BLOCK, ChatColor.WHITE + "끄기", new String[]{ChatColor.RED + "현재는 켜져 있는 상태입니다."});
        offItem = new ItemInfo(Material.STONE, ChatColor.WHITE + "켜기", new String[]{ChatColor.RED + "현재는 꺼져 있는 상태입니다."});

        this.item = flag ? onItem : offItem;
    }

    @Override
    public void handClick(Event e){
        InventoryClickEvent ev = (InventoryClickEvent) e;
        this.flag = !this.flag;
        this.item = flag ? onItem : offItem;
        ev.setCurrentItem(this.createGuiItem());
    }
}
