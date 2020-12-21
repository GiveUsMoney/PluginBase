package com.roharui.mc.data;

import java.util.HashMap;
import java.util.logging.Logger;

import com.roharui.mc.gui.BaseGUI;

import org.bukkit.entity.HumanEntity;

public class DataManager {
    public HashMap<String, PlayerData> ImmunMap = new HashMap<String, PlayerData>();

    private static DataManager instance;

    public static DataManager getInstance(){
        if(instance == null){
            DataManager.instance = new DataManager();
        }
        return DataManager.instance;
    }

    public PlayerData getPlayerData(HumanEntity p){
        String uuid = p.getUniqueId().toString();
        return this.ImmunMap.get(uuid);
    }

    public BaseGUI getGUI(HumanEntity p, String name){
        String uuid = p.getUniqueId().toString();
        return this.ImmunMap.get(uuid).getGuiMapper().get(name);
    }

    public void openGUI(HumanEntity p, String name){
        BaseGUI gui = this.getGUI(p, name);
        this.getPlayerData(p).getGuiHistory().push(gui);
        this.getPlayerData(p).getGuiHistory().push(gui);
        int size = this.getPlayerData(p).getGuiHistory().size();
        Logger.getLogger("Minecraft").info(Integer.toString(size));
        gui.open(p);
    }
}
