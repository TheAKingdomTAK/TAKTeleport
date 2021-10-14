package org.theinteger.takteleport.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.theinteger.takteleport.TAKTeleport;

public class OnDeath implements Listener {
    TAKTeleport plugin;
    public OnDeath(TAKTeleport takTeleport){
        plugin = takTeleport;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent ev){
        plugin.setBackLocation(ev.getEntity(), ev.getEntity().getLocation());
    }
}
