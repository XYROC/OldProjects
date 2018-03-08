package me.xiroc.warofheroes.utils;

import java.util.ArrayList;

public class ServerManager {

	private ArrayList<ServerElement> servers;

	public ServerManager() {
		this.servers = new ArrayList<ServerElement>();
	}

	public void addServerElement(ServerElement element) {
		this.servers.add(element);
	}

	public void removeServerElement(ServerElement element) {
		this.servers.remove(element);
	}
	public ArrayList<ServerElement> getServers() {
		return servers;
	}

}
