package distortiongate.magiccast.hologram.method.move;

import distortiongate.magiccast.hologram.Hologram;

public class DefaultHologramMoveMethod implements HologramMoveMethod {

    private static DefaultHologramMoveMethod instance = new DefaultHologramMoveMethod();

    private DefaultHologramMoveMethod() { }

    @Override
    public void move(Hologram hologram) {
        System.out.println("Default move method executed");
    }

    public static DefaultHologramMoveMethod getInstance() {
        return instance;
    }
}
