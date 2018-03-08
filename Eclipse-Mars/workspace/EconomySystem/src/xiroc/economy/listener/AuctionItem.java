package xiroc.economy.listener;

import org.bukkit.inventory.ItemStack;

public class AuctionItem {
	
	private ItemStack item;
	private int bidPrice;
	
	public AuctionItem(ItemStack item, int openingBid) {
		this.item = item;
		this.bidPrice = openingBid;
	}
	
	public ItemStack getItem() {
		return item;
	}
	
	public int getBidPrice() {
		return bidPrice;
	}

}
