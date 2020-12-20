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

    protected ItemStack onItem;
    protected ItemStack offItem;

    public BoolItem(){
        super();

        onItem = createGuiItem(Material.REDSTONE_BLOCK, ChatColor.WHITE + "끄기", new String[]{ChatColor.RED + "현재는 켜져 있는 상태입니다."});
        offItem = createGuiItem(Material.STONE, ChatColor.WHITE + "켜기", new String[]{ChatColor.RED + "현재는 꺼져 있는 상태입니다."});

        this.item = flag ? onItem : offItem;
    }

    @Override
    public void handClick(Event e){
        InventoryClickEvent ev = (InventoryClickEvent) e;
        // Player p = (Player)ev.getWhoClicked();
        // ImmunData imm = DataManager.getInstance().ImmunMap.get(p.getUniqueId().toString());
        // imm.setTest(!imm.isTest());
        // ev.setCurrentItem(imm.isTest() ? onItem : offItem);
        // item = imm.isTest() ? onItem : offItem;

        this.flag = !this.flag;
        this.item = flag ? onItem : offItem;
        ev.setCurrentItem(this.flag ? onItem : offItem);

    }
}
