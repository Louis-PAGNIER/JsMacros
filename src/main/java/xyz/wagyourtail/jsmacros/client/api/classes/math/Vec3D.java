package xyz.wagyourtail.jsmacros.client.api.classes.math;

import net.minecraft.util.math.MathHelper;
import org.joml.Vector3f;

/**
 * @author Wagyourtail
 * @since 1.2.6 [citation needed]
 */
public class Vec3D extends Vec2D {
    public double z1;
    public double z2;

    public Vec3D(double x1, double y1, double z1, double x2, double y2, double z2) {
        super(x1, y1, x2, y2);
        this.z1 = z1;
        this.z2 = z2;
    }

    public Vec3D(Pos3D start, Pos3D end) {
        super(start, end);
        this.z1 = start.z;
        this.z2 = end.z;
    }

    public double getZ1() {
        return z1;
    }

    public double getZ2() {
        return z2;
    }

    public double getDeltaZ() {
        return z2 - z1;
    }

    @Override
    public Pos3D getStart() {
        return new Pos3D(x1, y1, z1);
    }

    @Override
    public Pos3D getEnd() {
        return new Pos3D(x2, y2, z2);
    }

    @Override
    public double getMagnitude() {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double dz = z2 - z1;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double getMagnitudeSq() {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double dz = z2 - z1;
        return dx * dx + dy * dy + dz * dz;
    }

    public Vec3D add(Vec3D vec) {
        return new Vec3D(
                this.x1 + vec.x1,
                this.y1 + vec.y1,
                this.z1 + vec.z1,
                this.x2 + vec.x2,
                this.y2 + vec.y2,
                this.z2 + vec.z2
        );
    }

    /**
     * @param x1
     * @param y1
     * @param z1
     * @param x2
     * @param y2
     * @param z2
     * @return
     * @since 1.6.3
     */
    public Vec3D add(double x1, double y1, double z1, double x2, double y2, double z2) {
        return new Vec3D(this.x1 + x1, this.y1 + y1, this.z1 + z1, this.x2 + x2, this.y2 + y2, this.z2 + z2);
    }

    /**
     * @param pos
     * @return
     * @since 1.9.0
     */
    public Vec3D add(Pos3D pos) {
        return new Vec3D(
                this.x1 + pos.x,
                this.y1 + pos.y,
                this.z1 + pos.z,
                this.x2 + pos.x,
                this.y2 + pos.y,
                this.z2 + pos.z
        );
    }

    /**
     * @param pos
     * @return
     * @since 1.6.4
     */
    public Vec3D addStart(Pos3D pos) {
        return new Vec3D(this.x1 + pos.x, this.y1 + pos.y, this.z1 + pos.z, this.x2, this.y2, this.z2);
    }

    /**
     * @param pos
     * @return
     * @since 1.6.4
     */
    public Vec3D addEnd(Pos3D pos) {
        return new Vec3D(this.x1, this.y1, this.z1, this.x2 + pos.x, this.y2 + pos.y, this.z2 + pos.z);
    }

    /**
     * @param x
     * @param y
     * @param z
     * @return
     * @since 1.6.4
     */
    public Vec3D addStart(double x, double y, double z) {
        return new Vec3D(this.x1 + x, this.y1 + y, this.z1 + z, this.x2, this.y2, this.z2);
    }

    /**
     * @param x
     * @param y
     * @param z
     * @return
     * @since 1.6.4
     */
    public Vec3D addEnd(double x, double y, double z) {
        return new Vec3D(this.x1, this.y1, this.z1, this.x2 + x, this.y2 + y, this.z2 + z);
    }


    /**
     * @param vec
     * @return
     * @since 1.9.0
     */
    public Vec3D sub(Vec3D vec) {
        return new Vec3D(
                this.x1 - vec.x1,
                this.y1 - vec.y1,
                this.z1 - vec.z1,
                this.x2 - vec.x2,
                this.y2 - vec.y2,
                this.z2 - vec.z2
        );
    }

    /**
     * @param x1
     * @param y1
     * @param z1
     * @param x2
     * @param y2
     * @param z2
     * @return
     * @since 1.9.0
     */
    public Vec3D sub(double x1, double y1, double z1, double x2, double y2, double z2) {
        return new Vec3D(this.x1 - x1, this.y1 - y1, this.z1 - z1, this.x2 - x2, this.y2 - y2, this.z2 - z2);
    }

    /**
     * @param pos
     * @return
     * @since 1.9.0
     */
    public Vec3D sub(Pos3D pos) {
        return new Vec3D(
                this.x1 - pos.x,
                this.y1 - pos.y,
                this.z1 - pos.z,
                this.x2 - pos.x,
                this.y2 - pos.y,
                this.z2 - pos.z
        );
    }

    public Vec3D multiply(Vec3D vec) {
        return new Vec3D(
                this.x1 * vec.x1,
                this.y1 * vec.y1,
                this.z1 * vec.z1,
                this.x2 * vec.x2,
                this.y2 * vec.y2,
                this.z2 * vec.z2
        );
    }

    /**
     * @param x1
     * @param y1
     * @param z1
     * @param x2
     * @param y2
     * @param z2
     * @return
     * @since 1.6.3
     */
    public Vec3D multiply(double x1, double y1, double z1, double x2, double y2, double z2) {
        return new Vec3D(this.x1 * x1, this.y1 * y1, this.z1 * z1, this.x2 * x2, this.y2 * y2, this.z2 * z2);
    }

    /**
     * @param pos
     * @return
     * @since 1.9.0
     */
    public Vec3D multiply(Pos3D pos) {
        return new Vec3D(
                this.x1 * pos.x,
                this.y1 * pos.y,
                this.z1 * pos.z,
                this.x2 * pos.x,
                this.y2 * pos.y,
                this.z2 * pos.z
        );
    }

    /**
     * @param scale
     * @return
     * @since 1.6.3
     */
    @Override
    public Vec3D scale(double scale) {
        return new Vec3D(x1 * scale, y1 * scale, z1 * scale, x2 * scale, y2 * scale, z2 * scale);
    }

    /**
     * @return
     * @since 1.6.5
     */
    @Override
    public Vec3D normalize() {
        double mag = getMagnitude();
        return new Vec3D(x1 / mag, y1 / mag, z1 / mag, x2 / mag, y2 / mag, z2 / mag);
    }

    public float getPitch() {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double dz = z2 - z1;
        double xz = Math.sqrt(dx * dx + dz * dz);
        return 90F - (float) MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(xz, -dy)));
    }

    public float getYaw() {
        double dx = x2 - x1;
        double dz = z2 - z1;
        return (float) -MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(dx, dz)));
    }

    public double dotProduct(Vec3D vec) {
        double dz1 = z2 - z1;
        double dz2 = vec.z2 - vec.z1;
        return super.dotProduct(vec) + dz1 * dz2;
    }

    public Vec3D crossProduct(Vec3D vec) {
        double dx1 = x2 - x1;
        double dx2 = vec.x2 - vec.x1;
        double dy1 = y2 - y1;
        double dy2 = vec.y2 - vec.y1;
        double dz1 = z2 - z1;
        double dz2 = vec.z2 - vec.z1;
        return new Vec3D(0, 0, 0, dy1 * dz2 - dz1 * dy2, dz1 * dx2 - dx1 * dz2, dx1 * dy2 - dy1 * dx2);
    }

    @Override
    public Vec3D reverse() {
        return new Vec3D(x2, y2, z2, x1, y1, z1);
    }

    /**
     * @param x
     * @param y
     * @param z
     * @return
     * @since 1.9.0
     */
    public Vec3D stretch(double x, double y, double z) {
        double d = this.x1;
        double e = this.y1;
        double f = this.z1;
        double g = this.x2;
        double h = this.y2;
        double i = this.z2;

        if (x < 0.0D)
            d += x;
        else if (x > 0.0D)
            g += x;

        if (y < 0.0D)
            e += y;
        else if (y > 0.0D)
            h += y;

        if (z < 0.0D)
            f += z;
        else if (z > 0.0D)
            i += z;

        return new Vec3D(d, e, f, g, h, i);
    }

    /**
     * @param pos
     * @return
     * @since 1.9.0
     */
    public Vec3D stretch(Pos3D pos) {
        return stretch(pos.x, pos.y, pos.z);
    }

    /**
     * @param vec
     * @return
     * @since 1.9.0
     */
    public Vec3D stretch(Vec3D vec) {
        return stretch(vec.getStart()).stretch(vec.getEnd());
    }

    /**
     * @param n
     * @return
     * @since 1.9.0
     */
    @Override
    public Vec3D expand(double n) {
        return new Vec3D(x1 - n, y1 - n, z1 - n, x2 + n, y2 + n, z2 + n);
    }


    @Override
    public String toString() {
        return String.format("%f, %f, %f -> %f, %f, %f", x1, y1, z1, x2, y2, z2);
    }

    /**
     * @return
     * @since 1.6.5
     */
    public Vector3f toMojangFloatVector() {
        return new Vector3f((float) (x2 - x1), (float) (y2 - y1), (float) (z2 - z1));
    }

}
