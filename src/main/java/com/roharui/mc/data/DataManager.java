package com.roharui.mc.data;

import java.util.HashMap;

import com.roharui.mc.gui.BaseGUI;

import org.bukkit.entity.Player;

public class DataManager {
    public HashMap<String, ImmunData> ImmunMap = new HashMap<String, ImmunData>();

    private static DataManager instance;

    public static DataManager getInstance(){
        if(instance == null){
            DataManager.instance = new DataManager();
        }
        return DataManager.instance;
    }

    public BaseGUI getGUI(Player p, String name){
        String uuid = p.getUniqueId().toString();
        return this.ImmunMap.get(uuid).GuiMapper.get(name);
    }

    public void openGUI(Player p, String name){
        this.getGUI(p, name).open(p);
    }
}
