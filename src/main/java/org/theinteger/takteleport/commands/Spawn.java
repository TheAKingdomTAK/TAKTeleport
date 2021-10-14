package org.theinteger.takteleport.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.theinteger.takteleport.TAKTeleport;

public class Spawn implements CommandExecutor {
    TAKTeleport plugin;
    public Spawn(TAKTeleport takTeleport) {
        plugin = takTeleport;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(plugin.getPlayersOnlyMessage());
            return false;
        }
        Player p = (Player) sender;
        p.teleport(p.getWorld().getSpawnLocation());
        p.sendMessage(plugin.getTeleportMessage());
        return true;
    }
}
