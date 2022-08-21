package distortiongate.magiccast.hologram.factory;

public class HologramMethodCreatorFactory {

    public static HologramMethodCreator create(HologramMethodCreatorType type) {
        return switch (type) {
            case DEFAULT -> DefaultHologramMethodCreator.getInstance();
        };
    }
}
