package com.roharui.mc.gui.Items;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseItem {
    protected ItemStack item;

    public BaseItem(Material material, String name, String[] lore){
        this.item = createGuiItem(material, name, lore);
    }

    protected ItemStack createGuiItem(Material material, String name, String[] lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

    public void handClick(Event e){}
}
