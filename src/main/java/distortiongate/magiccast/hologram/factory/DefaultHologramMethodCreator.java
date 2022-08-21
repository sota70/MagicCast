package distortiongate.magiccast.hologram.factory;

import distortiongate.magiccast.hologram.method.move.DefaultHologramMoveMethod;
import distortiongate.magiccast.hologram.method.move.HologramMoveMethod;
import distortiongate.magiccast.hologram.method.ontouch.DefaultHologramOnTouchMethod;
import distortiongate.magiccast.hologram.method.ontouch.HologramOnTouchMethod;
import distortiongate.magiccast.hologram.method.spawn.DefaultHologramSpawnMethod;
import distortiongate.magiccast.hologram.method.spawn.HologramSpawnMethod;

public class DefaultHologramMethodCreator implements HologramMethodCreator {

    private static DefaultHologramMethodCreator instance = new DefaultHologramMethodCreator();

    private DefaultHologramMethodCreator() { }

    @Override
    public HologramMoveMethod createMoveMethod() {
        return DefaultHologramMoveMethod.getInstance();
    }

    @Override
    public HologramOnTouchMethod createOnTouchMethod() {
        return DefaultHologramOnTouchMethod.getInstance();
    }

    @Override
    public HologramSpawnMethod createSpawnMethod() {
        return DefaultHologramSpawnMethod.getInstance();
    }

    public static DefaultHologramMethodCreator getInstance() {
        return instance;
    }
}
