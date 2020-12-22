package net.ultistaff.Manager;

import net.ultistaff.Event.InventoryClick;
import net.ultistaff.Event.PlayerInteractEntity;
import net.ultistaff.Event.PlayerMove;
import net.ultistaff.Main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventManager { public void register() { PluginManager pm = Bukkit.getPluginManager();
    pm.registerEvents(new InventoryClick(), Main.getInstance());
    pm.registerEvents(new PlayerInteractEntity(), Main.getInstance());
    pm.registerEvents(new PlayerMove(), Main.getInstance());}
}
