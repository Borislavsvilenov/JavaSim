package Sim;

import Vector.*;

import java.awt.*;

public class Particle {
    public Vector2 pos;
    Vector2 posL;
    Vector2 vel;
    Vector2 acc;

    int mass;
    public int rad;

    double bounciness = 0.8;

    boolean movable;

    public Color color;

    public Particle (Vector2 p, Vector2 v, Vector2 a, int mass, int r, boolean mv, Color c) {
        pos = p;
        posL = pos.sub(v);
        vel = v;
        acc = a;
        this.mass = mass;
        this.rad = r;
        movable = mv;
        color = c;
    }

    public void applyGravity () {
        acc.y += 0.1;
    }

    public void update (Box2 bounds) {
        vel = pos.sub(posL);

        applyBounds(bounds);
        applyGravity();
        vel = vel.add(acc);

        acc.x = 0;
        acc.y = 0;
        posL = pos;

        pos = pos.add(vel);
    }
    
    public void applyBounds (Box2 bounds) {
        if (!bounds.contains(pos, rad)) {
            if (pos.x - rad < bounds.pos.x) {
                // left
                pos.x = bounds.pos.x + rad;
                vel.x = -vel.x * bounciness;
            } else if (pos.x + rad > bounds.pos.x + bounds.size.x) {
                // right
                pos.x = bounds.pos.x + bounds.size.x - rad;
                vel.x = -vel.x * bounciness;
            } else if (pos.y - rad < bounds.pos.y) {
                // up
                pos.y = bounds.pos.y + rad;
                vel.y = -vel.y * bounciness;
            } else if (pos.y + rad > bounds.pos.y + bounds.size.y) {
                // bottom
                pos.y = bounds.pos.y + bounds.size.y - rad;
                vel.y = -vel.y * bounciness;
            }
        }
    }
}
