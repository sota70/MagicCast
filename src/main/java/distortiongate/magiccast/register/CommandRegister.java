package distortiongate.magiccast.register;

import distortiongate.magiccast.Magiccast;
import distortiongate.magiccast.command.SetHologramPatternCommand;

public class CommandRegister implements Register {

    @Override
    public void register() {
        Magiccast plugin = Magiccast.getInstance();
        plugin.getCommand("sethologrampattern").setExecutor(new SetHologramPatternCommand());
    }
}
