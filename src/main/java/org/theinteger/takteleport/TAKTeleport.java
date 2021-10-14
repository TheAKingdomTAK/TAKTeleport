package org.theinteger.takteleport;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.theinteger.takteleport.commands.SetSpawn;
import org.theinteger.takteleport.commands.Spawn;
import org.theinteger.takteleport.events.OnDeath;
import org.theinteger.takteleport.events.Teleport;

import java.util.HashMap;

public final class TAKTeleport extends JavaPlugin {
    String playersOnlyMessage = "§cOnly players can use this command.";
    String permissionMessage = "§cYou don't seem to have permissions to use this TAKTeleport command.";
    HashMap<Player, Location> backLocations = new HashMap<>();

    public String getPlayersOnlyMessage(){
        return playersOnlyMessage;
    }

    public String getPermissionMessage(){
        return permissionMessage;
    }

    public void setBackLocation(Player player, Location deathLocation){
        backLocations.put(player, deathLocation);
    }

    public Location getBackLocation(Player player){
        return backLocations.get(player);
    }


    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Mabe TAKTeleport started");
        getCommand("spawn").setExecutor(new Spawn(this));
        getCommand("setspawn").setExecutor(new SetSpawn(this));
        getServer().getPluginManager().registerEvents(new OnDeath(this), this);
        getServer().getPluginManager().registerEvents(new Teleport(this), this);
    }
}
