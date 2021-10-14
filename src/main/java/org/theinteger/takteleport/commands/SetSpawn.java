package org.theinteger.takteleport.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.theinteger.takteleport.TAKTeleport;

public class SetSpawn implements CommandExecutor {

    TAKTeleport plugin;
    public SetSpawn(TAKTeleport takTeleport) {
        plugin = takTeleport;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(plugin.getPlayersOnlyMessage());
            return false;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("takteleport.command.setspawn")){
            p.sendMessage(plugin.getPermissionMessage());
            return false;
        }
        Location loc = p.getLocation();
        p.getWorld().setSpawnLocation(loc);
        p.sendMessage("§aThe spawn of world §2" + p.getWorld().getName() + "§a has been set to §2" + loc.toString() + "§a.");
        return true;
    }
}
