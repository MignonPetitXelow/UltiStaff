package net.ultistaff.Event;

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
				}
				return;
		}
	}

}
