package distortiongate.magiccast.state.playerstate;

public class PlayerStateFactory {

    public static PlayerState create(PlayerStateType type) {
        return switch (type) {
            case NORMAL -> PlayerNormalMode.getInstance();
            case MAGIC_CASTING -> PlayerMagicCastingMode.getInstance();
        };
    }
}
