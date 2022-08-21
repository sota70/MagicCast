package distortiongate.magiccast.hologram;

import distortiongate.magiccast.hologram.method.move.HologramMoveMethod;
import distortiongate.magiccast.hologram.method.ontouch.HologramOnTouchMethod;
import distortiongate.magiccast.hologram.method.spawn.HologramSpawnMethod;
import org.bukkit.Location;

public class Hologram {

    private HologramSpawnMethod spawnMethod;
    private HologramOnTouchMethod onTouchMethod;
    private HologramMoveMethod moveMethod;
    private Location spawnLoc;

    public Hologram(
            HologramSpawnMethod spawnMethod,
            HologramOnTouchMethod onTouchMethod,
            HologramMoveMethod moveMethod,
            Location spawnLoc
    ) {
        this.spawnMethod = spawnMethod;
        this.onTouchMethod = onTouchMethod;
        this.moveMethod = moveMethod;
        this.spawnLoc = spawnLoc;
    }

    public void spawn() {
        this.spawnMethod.spawn(this);
    }

    public void onTouch() {
        this.onTouchMethod.onTouch(this);
    }

    public void move() { this.moveMethod.move(this); }
}
