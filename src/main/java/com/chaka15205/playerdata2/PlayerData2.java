package com.chaka15205.playerdata2;

import com.chaka15205.playerdata2.util.Info;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;

public class PlayerData2 extends JavaPlugin {
    public Permission pd2Help = new Permission("playerdata.cmd.help");
    public Permission pd2GetInfo = new Permission("playerdata.cmd.getinfo");
    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.addPermission(pd2Help);
        pm.addPermission(pd2GetInfo);
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            getLogger().severe("Failed To Submit Metrics");
        }
        getLogger().info("Enabled");
    }
    @Override
    public void onDisable() {

        getLogger().info("Disabled");
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String [] args) {
        if (cmd.getName().equalsIgnoreCase("pd") && sender instanceof Player) {
            Player player = (Player) sender;
        }
        return false;
    }
}
