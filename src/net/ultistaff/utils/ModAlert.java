package net.ultistaff.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ModAlert {

    public static void disableCommandsModAlert(String cmd, String name) {
        for (Player players : Bukkit.getServer().getOnlinePlayers()){
            if(players.hasPermission("moderator.mod")) {
                players.sendMessage("§8[§c§l!§8]§c "+name+" §7execute §bcommand ("+cmd+")");
            }
        }
    }

    public static void sendToMods(String HackName, String targetName) {
        for (Player players : Bukkit.getServer().getOnlinePlayers()){
            if(players.hasPermission("moderator.mod"))
            {
                players.sendMessage("§8[§c§l!§8]§c "+targetName+" §7reported for §bcheating ("+HackName+")");
            }
        }
    }

}
