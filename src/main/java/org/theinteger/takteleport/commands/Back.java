package org.theinteger.takteleport.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.theinteger.takteleport.TAKTeleport;

public class Back implements CommandExecutor {
    TAKTeleport plugin;
    public Back(TAKTeleport takTeleport) {
        plugin = takTeleport;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(plugin.getPlayersOnlyMessage());
            return false;
        }
        Player p = (Player) sender;
        if(plugin.getBackLocation(p) == null){
            p.sendMessage("§cYou haven't teleported anywhere or died");
            return false;
        }
        p.teleport(plugin.getBackLocation(p));
        return true;
    }
}
