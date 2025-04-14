package Camera;

import Vector.*;

public class Camera2 {
    public Box2 box;
    public Vector2 vel;

    public Camera2 (Vector2 p, Vector2 s) {
        box = new Box2(p, s);
        vel = new Vector2(0, 0);
    }

    public void update() {
        box.pos = box.pos.add(vel);
    }

    public boolean visible (Vector2 ppos, int pr) {
        return box.contains(ppos, pr);
    }

    public Vector2 posOnCam (Vector2 a) {
        return new Vector2(a.x - box.pos.x, a.y - box.pos.y);
    }
}
