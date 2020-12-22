package net.ultistaff.Event;

import net.ultistaff.utils.ModAlert;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import net.ultistaff.Main;

public class PlayerInteractEntity implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e)
	{	
		Player p = e.getPlayer();
		if (e.getRightClicked() == null || !(e.getRightClicked() instanceof Player) || p.getItemInHand() == null) return;
		Player t = (Player) e.getRightClicked();
		ItemStack is = p.getItemInHand();
		
		switch (is.getItemMeta().getDisplayName())
		{
			case "§bFreeze / Unfreeze":
				if (Main.getInstance().freezed.contains(t.getUniqueId()))
				{
					Main.getInstance().freezed.remove(t.getUniqueId());
				}
				else
				{
					Main.getInstance().freezed.add(t.getUniqueId());
				   	/*Test*/
					ModAlert.sendToModsOther("§8[§c§l!§8] §c"+t.getName()+" §7has been §b freezed (By "+p.getName()+")");
					t.sendMessage("§6----------------------");
					t.sendMessage("§bVous avez été gelé");
					t.sendMessage("§5Discord: https://discord.gg/hgMkJXU");
					t.sendMessage("§6----------------------");
					/*Test*/
				}
				return;
		}
	}

}
