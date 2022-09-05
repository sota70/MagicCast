package distortiongate.magiccast.skillnameloader;

import distortiongate.magiccast.Magiccast;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class SkillIdLoaderWithConfig implements SkillIdLoader {

    private static SkillIdLoaderWithConfig instance = new SkillIdLoaderWithConfig();

    private SkillIdLoaderWithConfig() { }

    @Override
    public String getSkillId(String className, String castAction) {
        FileConfiguration config = new YamlConfiguration();
        Magiccast plugin = Magiccast.getInstance();
        String skillId = "";
        try {
            config.load(new File(plugin.getDataFolder(), className + ".yml"));
            skillId = config.getString(castAction);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return skillId;
    }

    public static SkillIdLoaderWithConfig getInstance() { return instance; }
}
