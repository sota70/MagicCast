package distortiongate.magiccast.hologram.method.ontouch;

import distortiongate.magiccast.castaction.PlayerCastActionStorage;
import distortiongate.magiccast.hologram.Hologram;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class DefaultHologramOnTouchMethod implements HologramOnTouchMethod {

    private static DefaultHologramOnTouchMethod instance = new DefaultHologramOnTouchMethod();

    private DefaultHologramOnTouchMethod() { }

    @Override
    public void onTouch(Hologram hologram) {
        Player player = hologram.getOwner();
        PlayerCastActionStorage playerActionStorage = PlayerCastActionStorage.getInstance();
        player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
        if (!playerActionStorage.hasAction(player)) {
            playerActionStorage.setAction(player, hologram.getName());
            return;
        }
        playerActionStorage.setAction(player, playerActionStorage.getAction(player) + hologram.getName());
    }

    public static DefaultHologramOnTouchMethod getInstance() {
        return instance;
    }
}
