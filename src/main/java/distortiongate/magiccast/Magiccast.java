package distortiongate.magiccast;

import distortiongate.magiccast.castaction.PlayerCastActionDisplayer;
import distortiongate.magiccast.castaction.PlayerCastActionStorage;
import distortiongate.magiccast.register.CommandRegister;
import distortiongate.magiccast.register.EventListenerRegister;
import distortiongate.magiccast.register.Register;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class Magiccast extends JavaPlugin {

    private static Magiccast instance;

    public Magiccast() { instance = this; }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().log(Level.INFO, ChatColor.GREEN + "Magic Cast plugin has been enabled");
        this.setupPlayerActionStorage();
        this.registerComponents();
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().log(Level.INFO, ChatColor.RED + "Magic Cast plugin has been disabled");
    }

    public static Magiccast getInstance() { return instance; }

    private void registerComponents() {
        Register[] registers = {
                new EventListenerRegister(this),
                new CommandRegister()
        };
        for (Register register : registers) {
            register.register();
        }
    }

    private void setupPlayerActionStorage() {
        PlayerCastActionStorage storage = PlayerCastActionStorage.getInstance();
        storage.addObserver(PlayerCastActionDisplayer.getInstance());
    }
}
