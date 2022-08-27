package distortiongate.magiccast.hologram.spawner;

public class HologramSpawnerFactory {

    public static HologramSpawner create(HologramSpawnerType type) {
        return switch (type) {
            case TWO_HOLOGRAMS -> TwoHologramsSpawner.getInstance();
            case FOUR_HOLOGRAMS -> FourHologramsSpawner.getInstance();
        };
    }
}
