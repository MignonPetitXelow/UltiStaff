package net.ultistaff.Manager;

import net.ultistaff.Event.InventoryClick;
import net.ultistaff.Main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventManager { public void register() { PluginManager pm = Bukkit.getPluginManager();
    pm.registerEvents(new InventoryClick(), Main.getInstance());}
}
