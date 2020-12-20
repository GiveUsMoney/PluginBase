package com.roharui.mc.command;

import java.util.logging.Logger;

import com.roharui.mc.data.DataManager;
// import com.roharui.mc.gui.BaseGUI;

import org.bukkit.entity.Player;

public class TestCommand extends BaseCommand{

    private DataManager dm = DataManager.getInstance();

    @Override
    void empty(Player p){
        // Do not put op Command in here
        // p.sendMessage("arg is Empty");
        // BaseGUI gui = dm.getGUI(p, "BaseGUI");
        // Logger.getLogger("Minecraft").info(gui.items.)
        dm.openGUI(p, "BaseGUI");
    }

    @Override
    void notFound(Player p) {
        p.sendMessage("Command not found");
    }

    @CommandArgs(args="go")
    void ggg(Player p, String[] args){
        p.sendMessage("It Work.");
    }

    @CommandArgs(args="Debug", op=true)
    void debug(Player p, String[] args){

    }

}
