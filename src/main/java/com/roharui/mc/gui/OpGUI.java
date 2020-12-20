package com.roharui.mc.gui;

import com.roharui.mc.gui.Items.BoolItem;
import com.roharui.mc.gui.Items.ModeItem;

public class OpGUI extends BaseGUI{
    protected int INV_LINE = 3;

    public OpGUI(String inv_title) {
        super(inv_title);
        this.items.put(0, new BoolItem());
        this.items.put(1, new ModeItem());
        this.setINV_LINE(3);
    }

}
