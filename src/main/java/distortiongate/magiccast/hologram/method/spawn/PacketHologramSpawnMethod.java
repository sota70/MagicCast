package distortiongate.magiccast.hologram.method.spawn;

import distortiongate.magiccast.hologram.Hologram;
import distortiongate.magiccast.hologram.PlayerHologramStorage;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.decoration.ArmorStand;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PacketHologramSpawnMethod implements HologramSpawnMethod {

    private static PacketHologramSpawnMethod instance = new PacketHologramSpawnMethod();

    private PacketHologramSpawnMethod() { }

    @Override
    public void spawn(Hologram hologram) {
        UUID hologramId = this.spawnHologram(hologram);
        hologram.setHologramId(hologramId);
        PlayerHologramStorage.getInstance().registerHologram(hologram.getOwner(), hologram);
    }

    private UUID spawnHologram(Hologram hologram) {
        Player player = hologram.getOwner();
        Location spawnLoc = hologram.getSpawnLocation();
        ServerGamePacketListenerImpl playerConnection = ((CraftPlayer)player).getHandle().connection;
        CraftWorld craftWorld = (CraftWorld)spawnLoc.getWorld();
        ServerLevel serverLevel = craftWorld.getHandle();
        ArmorStand armorStand = new ArmorStand(serverLevel, spawnLoc.getX(), spawnLoc.getY(), spawnLoc.getZ());
        ClientboundAddEntityPacket packet;
        ClientboundSetEntityDataPacket entityDataPacket;
        armorStand.setInvisible(true);
        packet = new ClientboundAddEntityPacket(armorStand);
        entityDataPacket = new ClientboundSetEntityDataPacket(armorStand.getId(), armorStand.getEntityData(), true);
        playerConnection.send(packet);
        playerConnection.send(entityDataPacket);
        serverLevel.addFreshEntity(armorStand);
        return armorStand.getUUID();
    }

    public static PacketHologramSpawnMethod getInstance() { return instance; }
}
