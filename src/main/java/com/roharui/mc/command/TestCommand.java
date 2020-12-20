package com.roharui.mc.command;

import com.roharui.mc.data.DataManager;

import org.bukkit.entity.Player;

public class TestCommand extends BaseCommand{

    private DataManager dm = DataManager.getInstance();

    @Override
    void empty(Player p){
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
        dm.openGUI(p, "OpGUI");
    }
}
