package com.roharui.mc;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class App extends JavaPlugin{

    public static final Logger logger = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        super.onEnable();
        App.logger.info("[DamageImmuner] has been enabled");

        init();
    }

    private void init(){
        getCommand("dim").setExecutor(new AppCommand());
        Bukkit.getPluginManager().registerEvents(new AppEvent(), this);
    }

}


/*

 <Get All Class inside package>

 Reflections reflections = new Reflections("my.project.prefix");

 Set<Class<? extends Object>> allClasses =
     reflections.getSubTypesOf(Object.class);

     */
