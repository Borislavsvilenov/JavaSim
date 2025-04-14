package Vector;

public class Vector2 {
    public double x;
    public double y;

    public Vector2 (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 add (Vector2 b) {
        return new Vector2(this.x+b.x, this.y+b.y);
    }

    public Vector2 sub (Vector2 b) {
        return new Vector2(this.x-b.x, this.y-b.y);
    }

    public Vector2 scale (double s) {
        return new Vector2(this.x*s, this.y*s);
    }

    public Vector2 normalize () {
        double size = this.size();
        return new Vector2(this.x / size, this.y / size);
    }

    public double size () {
        return Math.sqrt((this.x * this.x) + (this.y * this.y));
    }

    public double dot (Vector2 b) {
        return (this.x * b.x) + (this.y * b.y);
    }
}
