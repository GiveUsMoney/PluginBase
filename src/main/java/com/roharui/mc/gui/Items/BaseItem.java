package com.roharui.mc.gui.Items;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseItem {

    @Data
    @AllArgsConstructor
    class ItemInfo {
        private Material material;
        private String name;
        private String[] lore;
    }

    protected ItemInfo item;

    public BaseItem(Material material, String name, String[] lore){
        this.item = new ItemInfo(material, name, lore);
    }

    protected ItemStack createGuiItem() {
        final ItemStack item = new ItemStack(this.item.material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(this.item.getName());

        // Set the lore of the item
        meta.setLore(Arrays.asList(this.item.getLore()));

        item.setItemMeta(meta);

        return item;
    }

    public void handClick(Event e){}
    public ItemStack showItem(Player p){
        return createGuiItem();
    }
}
