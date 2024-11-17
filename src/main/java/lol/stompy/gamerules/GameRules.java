package lol.stompy.gamerules;

import lol.stompy.gamerules.listener.CraftListener;
import lol.stompy.gamerules.listener.EnchantListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class GameRules extends JavaPlugin {

    /**
     * plugin loading logic
     */

    @Override
    public void onLoad() {
        this.saveDefaultConfig();
    }

    /**
     * plugin enabling logic
     */

    @Override
    public void onEnable() {
        final FileConfiguration fileConfiguration = this.getConfig();
        final PluginManager pluginManager = this.getServer().getPluginManager();

        if (fileConfiguration.getBoolean("no-enchant"))
            pluginManager.registerEvents(new EnchantListener(), this);

        if (fileConfiguration.getBoolean("no-craft"))
            pluginManager.registerEvents(new CraftListener(), this);
    }

}
