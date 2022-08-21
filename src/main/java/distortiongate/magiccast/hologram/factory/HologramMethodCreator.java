package distortiongate.magiccast.hologram.factory;

import distortiongate.magiccast.hologram.method.move.HologramMoveMethod;
import distortiongate.magiccast.hologram.method.ontouch.HologramOnTouchMethod;
import distortiongate.magiccast.hologram.method.spawn.HologramSpawnMethod;

public interface HologramMethodCreator {

    HologramMoveMethod createMoveMethod();
    HologramOnTouchMethod createOnTouchMethod();
    HologramSpawnMethod createSpawnMethod();
}
