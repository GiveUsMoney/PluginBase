package com.roharui.mc.data;

import java.util.HashMap;
import java.util.Stack;

import com.roharui.mc.gui.BaseGUI;
import com.roharui.mc.gui.OpGUI;

import lombok.Data;

@Data
public class PlayerData {
    private HashMap<String, BaseGUI> GuiMapper = new HashMap<String, BaseGUI>();
    private Stack<BaseGUI> GuiHistory = new Stack<BaseGUI>();
    
    public PlayerData(){
        this.GuiMapper.put("BaseGUI", new BaseGUI("BaseGUI"));
        this.GuiMapper.put("OpGUI", new OpGUI("OpGUI"));
    }

    public BaseGUI getLastGUI(){
        if(this.GuiHistory.isEmpty()){
            return null;
        }
        return this.GuiHistory.pop();
    }
}
