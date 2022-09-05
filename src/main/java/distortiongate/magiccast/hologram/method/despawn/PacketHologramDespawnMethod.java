package distortiongate.magiccast.hologram.method.despawn;

import distortiongate.magiccast.hologram.Hologram;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PacketHologramDespawnMethod implements HologramDespawnMethod {

    private static PacketHologramDespawnMethod instance = new PacketHologramDespawnMethod();

    private PacketHologramDespawnMethod() { }

    @Override
    public void despawn(Hologram hologram) {
        Player player = hologram.getOwner();
        UUID hologramId = hologram.getHologramId();
        CraftWorld craftWorld = (CraftWorld)hologram.getSpawnLocation().getWorld();
        ServerLevel serverLevel = craftWorld.getHandle();
        CraftPlayer craftPlayer = (CraftPlayer)player;
        ServerPlayer serverPlayer = craftPlayer.getHandle();
        ServerGamePacketListenerImpl playerConnection = serverPlayer.connection;
        ClientboundRemoveEntitiesPacket packet = new ClientboundRemoveEntitiesPacket(serverLevel.getEntity(hologramId).getId());
        playerConnection.send(packet);
    }

    public static PacketHologramDespawnMethod getInstance() { return instance; }
}
