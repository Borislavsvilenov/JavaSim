package Vector;

public class Vector3 {
    public double x;
    public double y;
    public double z;

    Vector3 (double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 add (Vector3 b) {
        return new Vector3(this.x+b.x, this.y+b.y, this.z+b.z);
    }

    public Vector3 sub (Vector3 b) {
        return new Vector3(this.x-b.x, this.y-b.y, this.z-b.z);
    }

    public Vector3 scale (double s) {
        return new Vector3(this.x*s, this.y*s, this.z*s);
    }

    public Vector3 normalize () {
        double size = this.size();
        return new Vector3(this.x / size, this.y / size, this.z / size);
    }

    public double size () {
        return Math.sqrt((this.x * this.x) + (this.y * this.y) + (this.z * this.z));
    }

    public double dot (Vector3 b) {
        return (this.x * b.x) + (this.y * b.y) + (this.z * b.z);
    }
}
