package distortiongate.magiccast.hologram.method.spawn;

import distortiongate.magiccast.hologram.Hologram;

public class DefaultHologramSpawnMethod implements HologramSpawnMethod {

    private static DefaultHologramSpawnMethod instance = new DefaultHologramSpawnMethod();

    @Override
    public void spawn(Hologram hologram) {
        System.out.println("Default spawn method executed");
    }

    public static DefaultHologramSpawnMethod getInstance() {
        return instance;
    }
}
