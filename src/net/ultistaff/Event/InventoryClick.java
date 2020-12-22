package net.ultistaff.Event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener
{
    @EventHandler
    public void onClick(InventoryClickEvent e)
    {
        if(e.getCurrentItem() == null)return;
        Player p = (Player) e.getWhoClicked();

        switch(e.getCurrentItem().getType())
        {
            case IRON_SWORD:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§dReach/TpAura"))
                {
                    e.setCancelled(true);
                    p.closeInventory();
                    sendToMods("Reach/TpAura", e.getInventory().getName().substring(11));
                    p.sendMessage("§aVous avez signalé ce joueur.");
                }
                break;
            case ANVIL:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§dAntiKnockback/Velocity"))
                {
                    e.setCancelled(true);
                    p.closeInventory();
                    sendToMods("Velocity", e.getInventory().getName().substring(11));
                    p.sendMessage("§aVous avez signalé ce joueur.");
                }
                break;
            case MINECART:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§dSpeed"))
                {
                    e.setCancelled(true);
                    p.closeInventory();
                    sendToMods("SpeedHack", e.getInventory().getName().substring(11));
                    p.sendMessage("§aVous avez signalé ce joueur.");
                }
                break;
            case COAL:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§dHigh latency"))
                {
                    e.setCancelled(true);
                    p.closeInventory();
                    sendToMods("High Latency", e.getInventory().getName().substring(11));
                    p.sendMessage("§aVous avez signalé ce joueur.");
                }
                break;
            case BOW:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§dTriggerBot/AimBot"))
                {
                    e.setCancelled(true);
                    p.closeInventory();
                    sendToMods("TriggerBot/AimBot", e.getInventory().getName().substring(11));
                    p.sendMessage("§aVous avez signalé ce joueur.");
                }
                break;
            case MUSHROOM_SOUP:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§dAutoPot/AutoSoup"))
                {
                    e.setCancelled(true);
                    p.closeInventory();
                    sendToMods("Auto(Pot/Soup)", e.getInventory().getName().substring(11));
                    p.sendMessage("§aVous avez signalé ce joueur.");
                }
                break;
            case DIAMOND_SWORD:
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§dAutoClicker"))
                {
                    e.setCancelled(true);
                    p.closeInventory();
                    sendToMods("AutoClick", e.getInventory().getName().substring(11));
                    p.sendMessage("§aVous avez signalé ce joueur.");
                }
                break;
            default: break;
        }
    }

    private void sendToMods(String HackName, String targetName) {
        for (Player players : Bukkit.getServer().getOnlinePlayers()){
            if(players.hasPermission("moderator.mod"))
            {
                players.sendMessage("§8[§c§l!§8]§c "+targetName+" §7reported for §bcheating ("+HackName+")");
            }
        }
    }
}
