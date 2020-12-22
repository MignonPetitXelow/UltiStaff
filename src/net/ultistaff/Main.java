package net.ultistaff;

import net.ultistaff.Commands.Commands;
import net.ultistaff.Manager.EventManager;
import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public class Main extends JavaPlugin
{
    private static Main instance;
    public ArrayList<UUID> moderators = new ArrayList<>();

    @Override
    public void onEnable() { instance = this; new EventManager().register();
    getCommand("mod").setExecutor(new Commands());
    getCommand("report").setExecutor(new Commands());}
    public static Main getInstance(){return instance;}
}
