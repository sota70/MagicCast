package distortiongate.magiccast;

import distortiongate.magiccast.castaction.PlayerCastActionStorage;
import distortiongate.magiccast.skillnameloader.SkillIdLoaderFactory;
import distortiongate.magiccast.skillnameloader.SkillIdLoaderType;
import net.Indyuce.mmocore.api.MMOCoreAPI;
import net.Indyuce.mmocore.api.player.PlayerData;
import net.Indyuce.mmocore.skill.RegisteredSkill;
import org.bukkit.entity.Player;

import java.util.Objects;

public class PlayerMagicCaster {

    public static void cast(Player player) {
        PlayerCastActionStorage castActionStorage = PlayerCastActionStorage.getInstance();
        MMOCoreAPI mmoCoreAPI = new MMOCoreAPI(Magiccast.getInstance());
        PlayerData playerData = mmoCoreAPI.getPlayerData(player);
        String className = playerData.getProfess().getName();
        String skillId;
        if (castActionStorage.getAction(player) == null) {
            return;
        }
        skillId = SkillIdLoaderFactory.create(SkillIdLoaderType.CONFIG).getSkillId(className, castActionStorage.getAction(player));
        playerData.getProfess().getSkills().forEach((skill) -> {
            RegisteredSkill registeredSkill = skill.getSkill();
            if (Objects.equals(registeredSkill.getHandler().getId(), skillId)) {
                mmoCoreAPI.cast(playerData, skill);
            }
        });
    }
}
