package distortiongate.magiccast.castaction;

import distortiongate.magiccast.Magiccast;
import net.Indyuce.mmocore.api.MMOCoreAPI;
import org.bukkit.entity.Player;

public class PlayerMagicCaster implements PlayerCastActionStorageObserver {

    @Override
    public void handle(PlayerCastActionStorage storage, Player player) {
        MMOCoreAPI mmoCoreAPI = new MMOCoreAPI(Magiccast.getInstance());
    }
}
