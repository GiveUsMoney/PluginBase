package com.roharui.mc.command;

import com.roharui.mc.gui.BaseGUI;

import org.bukkit.entity.Player;

public class TestCommand extends BaseCommand{

    @Override
    void empty(Player p){
        // Do not put op Command in here
        // p.sendMessage("arg is Empty");
        BaseGUI gui = new BaseGUI();
        gui.open(p);
    }

    @Override
    void notFound(Player p) {
        p.sendMessage("Command not found");
    }

    @CommandArgs(args="go")
    void ggg(Player p){
        p.sendMessage("It Work.");
    }

    @CommandArgs(args="Debug", op=true)
    void debug(Player p){

    }

}
