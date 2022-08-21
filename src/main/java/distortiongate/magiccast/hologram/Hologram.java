package distortiongate.magiccast.hologram;

import distortiongate.magiccast.hologram.method.move.HologramMoveMethod;
import distortiongate.magiccast.hologram.method.ontouch.HologramOnTouchMethod;
import distortiongate.magiccast.hologram.method.spawn.HologramSpawnMethod;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Hologram {

    private HologramSpawnMethod spawnMethod;
    private HologramOnTouchMethod onTouchMethod;
    private HologramMoveMethod moveMethod;
    private Location spawnLoc;
    private Player owner;

    public Hologram(
            HologramSpawnMethod spawnMethod,
            HologramOnTouchMethod onTouchMethod,
            HologramMoveMethod moveMethod,
            Player owner,
            Location spawnLoc
    ) {
        this.spawnMethod = spawnMethod;
        this.onTouchMethod = onTouchMethod;
        this.moveMethod = moveMethod;
        this.owner = owner;
        this.spawnLoc = spawnLoc;
    }

    public void spawn() {
        this.spawnMethod.spawn(this);
    }

    public void onTouch() {
        this.onTouchMethod.onTouch(this);
    }

    public void move() { this.moveMethod.move(this); }

    public void setSpawnLocation(Location spawnLoc) {
        this.spawnLoc = spawnLoc;
    }

    public Location getSpawnLocation() {
        return this.spawnLoc;
    }

    public HologramSpawnMethod getSpawnMethod() { return this.spawnMethod; }

    public HologramOnTouchMethod getOnTouchMethod() { return this.onTouchMethod; }

    public HologramMoveMethod getMoveMethod() { return this.moveMethod; }

    public Player getOwner() { return this.owner; }
}
