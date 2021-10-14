package org.theinteger.takteleport.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.theinteger.takteleport.TAKTeleport;

public class Teleport implements Listener {
    TAKTeleport plugin;
    public Teleport(TAKTeleport takTeleport){
        plugin = takTeleport;
    }

    @EventHandler
    public void onTeleport(PlayerTeleportEvent ev){
        plugin.setBackLocation(ev.getPlayer(), ev.getFrom());
    }
}
