package net.ultistaff.Commands;

import net.ultistaff.Main;
import net.ultistaff.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

import static net.ultistaff.utils.ModAlert.disableCommandsModAlert;

public class Commands implements CommandExecutor {
    @Override public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(!(sender instanceof Player)){ sender.sendMessage("/mod");return false;}
        Player p = (Player) sender;
        PlayerInventory pInv = p.getInventory();
        if(label.equalsIgnoreCase("mod"))
        {
            if(!(p.hasPermission("moderator.mod"))){ p.sendMessage("Mh... u cant execute this command");
            disableCommandsModAlert("/mod", p.getName());
            return false;}
            if(Main.getInstance().moderators.contains(p.getUniqueId()))
            {
                Main.getInstance().moderators.remove(p.getUniqueId());
                p.sendMessage("§8[§c§l!§8] §c"+p.getName()+" §7Stop §busing (Moderator mod)");
                pInv.clear();
                return false;
            }
            Main.getInstance().moderators.add(p.getUniqueId());
            p.sendMessage("§8[§c§l!§8] §c"+p.getName()+" §7Start §busing (Moderator mod)");
            //Je vais sauvegarder l'inventaire juste avant
            pInv.setItem(0, new ItemBuilder(Material.WOOD_SWORD).setName("§2Knockback Test").addEnchant(Enchantment.KNOCKBACK, 10).setUnbreakable().toItemStack());
        }
        if(label.equalsIgnoreCase("report"))
        {
            if(args.length != 1) { p.sendMessage("§c/report {PlayerName}");return false; }
            String targetName = args[0];
            if(Bukkit.getPlayer(targetName) == null) {p.sendMessage("§cThe player does not exist"); return false;}
            Player target = Bukkit.getPlayer(targetName);

            Inventory inv = Bukkit.createInventory(null, 9*3, "§cReport §b" +target.getName());

            inv.setItem(10, new ItemBuilder(Material.IRON_SWORD).setName("§dReach/TpAura").toItemStack());
            inv.setItem(11, new ItemBuilder(Material.ANVIL).setName("§dAntiKnockback/Velocity").toItemStack());
            inv.setItem(12, new ItemBuilder(Material.MINECART).setName("§dSpeed").toItemStack());
            inv.setItem(13, new ItemBuilder(Material.COAL).setName("§dHigh latency").toItemStack());
            inv.setItem(14, new ItemBuilder(Material.BOW).setName("§dTriggerBot/AimBot").toItemStack());
            inv.setItem(15, new ItemBuilder(Material.MUSHROOM_SOUP).setName("§dAutoPot/AutoSoup").toItemStack());
            inv.setItem(16, new ItemBuilder(Material.DIAMOND_SWORD).setName("§dAutoClicker").toItemStack());

            p.openInventory(inv);
        }
    return false;
    }


}
