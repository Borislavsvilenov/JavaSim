package Vector;

import java.awt.*;

public class Box2 {
    public Vector2 pos;
    public Vector2 size;

    public Box2 (Vector2 p, Vector2 s) {
        pos = p;
        size = s;
    }

    public boolean contains (Vector2 ppos, int pr) {
        return (ppos.x - pr >= pos.x) && (ppos.x + pr <= pos.x + size.x) && (ppos.y - pr >= pos.y) && (ppos.y + pr <= pos.y + size.y);
    }
}
