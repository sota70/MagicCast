package distortiongate.magiccast.hologram.method.ontouch;

import distortiongate.magiccast.hologram.Hologram;

public class DefaultHologramOnTouchMethod implements HologramOnTouchMethod {

    private static DefaultHologramOnTouchMethod instance = new DefaultHologramOnTouchMethod();

    private DefaultHologramOnTouchMethod() { }

    @Override
    public void onTouch(Hologram hologram) {
        System.out.println("Default on touch method executed");
    }

    public static DefaultHologramOnTouchMethod getInstance() {
        return instance;
    }
}
