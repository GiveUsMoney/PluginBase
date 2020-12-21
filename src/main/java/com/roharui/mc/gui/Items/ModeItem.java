package com.roharui.mc.gui.Items;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ModeItem extends BaseItem {
    private boolean flag = false;

    protected ItemInfo onItem;
    protected ItemInfo offItem;

    public ModeItem(){
        super();

        onItem = new ItemInfo(Material.REDSTONE_BLOCK, ChatColor.WHITE + "끄기", new String[]{ChatColor.RED + "현재는 켜져 있는 상태입니다."});
        offItem = new ItemInfo(Material.STONE, ChatColor.WHITE + "켜기", new String[]{ChatColor.RED + "현재는 꺼져 있는 상태입니다."});

        this.item = flag ? onItem : offItem;
    }

    @Override
    public void handClick(Event e){
        InventoryClickEvent ev = (InventoryClickEvent) e;
        HumanEntity p = ev.getWhoClicked();

        if(p.getGameMode() == GameMode.CREATIVE){
            p.setGameMode(GameMode.SURVIVAL);
        } else {
            p.setGameMode(GameMode.CREATIVE);
        }

        this.item = p.getGameMode() == GameMode.CREATIVE ? onItem : offItem;
        ev.setCurrentItem(this.createGuiItem());

    }

    @Override
    public ItemStack showItem(HumanEntity p) {
        this.item = p.getGameMode() == GameMode.CREATIVE ? onItem : offItem;
        return createGuiItem();
    }
}
