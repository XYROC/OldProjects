package Listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener{
	
	
	@EventHandler
	public void onBreak(BlockBreakEvent evt){
		
		if(evt.getBlock().getType() == Material.LEAVES){
			
			evt.setCancelled(false);
			
		}else if( evt.getBlock().getType() == Material.LOG){
			
			evt.setCancelled(false);
			
		}else{
			
			evt.setCancelled(true);
			
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
