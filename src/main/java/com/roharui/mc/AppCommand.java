package com.roharui.mc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.roharui.mc.command.*;

public class AppCommand implements CommandExecutor {

    private BaseCommand bc = new TestCommand();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        boolean result = false;

        // Player only
        if (sender instanceof Player) {

            try {
                result =  bc.invoke(args, (Player) sender);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        // Console only
        else
        {
            sender.sendMessage("Console only!");
        }

        return result;
    }
}
