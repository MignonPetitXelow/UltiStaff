package net.ultistaff.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.ultistaff.Main;

public class PlayerMove implements Listener {
	
	@EventHandler
	public void onMove(PlayerMoveEvent event)
	{
		Player p = event.getPlayer();
		if (Main.getInstance().freezed.contains(p.getUniqueId()))
		{
			event.setTo(event.getFrom());
		}
	}

}
