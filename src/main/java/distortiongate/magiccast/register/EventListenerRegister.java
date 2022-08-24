package distortiongate.magiccast.register;

import distortiongate.magiccast.Magiccast;
import distortiongate.magiccast.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class EventListenerRegister implements Register {

    private Magiccast plugin;

    public EventListenerRegister(Magiccast plugin) {
        this.plugin = plugin;
    }

    @Override
    public void register() {
        Listener[] listeners = {
                new PlayerPressFKeyListener(),
                new PlayerMoveListener(),
                new PlayerLeaveListener(),
                new PlayerClickHologramListener()
        };
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, this.plugin);
        }
    }
}
