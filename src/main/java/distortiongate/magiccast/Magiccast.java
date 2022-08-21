package distortiongate.magiccast;

import distortiongate.magiccast.register.EventListenerRegister;
import distortiongate.magiccast.register.Register;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class Magiccast extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().log(Level.INFO, ChatColor.GREEN + "Magic Cast plugin has been enabled");
        this.registerComponents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().log(Level.INFO, ChatColor.RED + "Magic Cast plugin has been disabled");
    }

    private void registerComponents() {
        Register[] registers = {
                new EventListenerRegister(this)
        };
        for (Register register : registers) {
            register.register();
        }
    }
}
