package com.roharui.mc.data;

import java.util.HashMap;

import com.roharui.mc.gui.BaseGUI;

import lombok.Data;

@Data
public class ImmunData {
    public HashMap<String, BaseGUI> GuiMapper = new HashMap<String, BaseGUI>();
    
    public ImmunData(){
        this.GuiMapper.put("BaseGUI", new BaseGUI(1, "BaseGUI"));
    }
}
