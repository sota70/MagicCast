package distortiongate.magiccast.hologram;

import distortiongate.magiccast.hologram.method.despawn.HologramDespawnMethod;
import distortiongate.magiccast.hologram.method.ontouch.HologramOnTouchMethod;
import distortiongate.magiccast.hologram.method.spawn.HologramSpawnMethod;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Hologram {

    private String name;
    private HologramSpawnMethod spawnMethod;
    private HologramOnTouchMethod onTouchMethod;
    private HologramDespawnMethod despawnMethod;
    private Location spawnLoc;
    private Player owner;
    private UUID hologramId;

    public Hologram(
            String name,
            HologramSpawnMethod spawnMethod,
            HologramOnTouchMethod onTouchMethod,
            HologramDespawnMethod despawnMethod,
            Player owner,
            Location spawnLoc
    ) {
        this.name = name;
        this.spawnMethod = spawnMethod;
        this.onTouchMethod = onTouchMethod;
        this.despawnMethod = despawnMethod;
        this.owner = owner;
        this.spawnLoc = spawnLoc;
    }

    public void spawn() {
        this.spawnMethod.spawn(this);
    }

    public void onTouch() {
        this.onTouchMethod.onTouch(this);
    }

    public void despawn() { this.despawnMethod.despawn(this); }

    public void setSpawnLocation(Location spawnLoc) {
        this.spawnLoc = spawnLoc;
    }

    public void setHologramId(UUID hologramId) {
        this.hologramId = hologramId;
    }

    public void setName(String name) { this.name = name; }

    public String getName() { return this.name; }

    public UUID getHologramId() {
        return this.hologramId;
    }

    public Location getSpawnLocation() {
        return this.spawnLoc;
    }

    public HologramSpawnMethod getSpawnMethod() { return this.spawnMethod; }

    public HologramOnTouchMethod getOnTouchMethod() { return this.onTouchMethod; }

    public HologramDespawnMethod getDespawnMethod() { return this.despawnMethod; }

    public Player getOwner() { return this.owner; }

    public Hologram clone() {
        return new Hologram(
                this.name,
                this.spawnMethod,
                this.onTouchMethod,
                this.despawnMethod,
                this.owner,
                this.spawnLoc
        );
    }
}
