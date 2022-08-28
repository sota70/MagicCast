package distortiongate.magiccast.skillnameloader;

public class SkillIdLoaderFactory {

    public static SkillIdLoader create(SkillIdLoaderType type) {
        return switch (type) {
            case CONFIG -> SkillIdLoaderWithConfig.getInstance();
        };
    }
}
