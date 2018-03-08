package Listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener{
	
	
	@EventHandler
	public void onPlace(BlockPlaceEvent evt){
		
		if(evt.getBlock().getType() == Material.WEB){
			
			evt.setCancelled(false);
			
		}else if(evt.getBlock().getType() == Material.FIRE){
			
			evt.setCancelled(false);
			
		}else{
			
			evt.setCancelled(true);
			
		}
		
		
		
	}
	
	
	

}
