package com.roharui.mc.data;

import java.util.HashMap;

import com.roharui.mc.gui.BaseGUI;
import com.roharui.mc.gui.OpGUI;

import lombok.Data;

@Data
public class ImmunData {
    public HashMap<String, BaseGUI> GuiMapper = new HashMap<String, BaseGUI>();
    
    public ImmunData(){
        this.GuiMapper.put("BaseGUI", new BaseGUI("BaseGUI"));
        this.GuiMapper.put("OpGUI", new OpGUI("OpGUI"));
    }
}
