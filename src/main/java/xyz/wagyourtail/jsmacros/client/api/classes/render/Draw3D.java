package xyz.wagyourtail.jsmacros.client.api.classes.render;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import xyz.wagyourtail.jsmacros.client.api.classes.math.Pos2D;
import xyz.wagyourtail.jsmacros.client.api.classes.math.Pos3D;
import xyz.wagyourtail.jsmacros.client.api.classes.render.components3d.Box;
import xyz.wagyourtail.jsmacros.client.api.classes.render.components3d.Line3D;
import xyz.wagyourtail.jsmacros.client.api.classes.render.components3d.RenderElement3D;
import xyz.wagyourtail.jsmacros.client.api.classes.render.components3d.Surface;
import xyz.wagyourtail.jsmacros.client.api.helpers.world.BlockPosHelper;
import xyz.wagyourtail.jsmacros.client.api.library.impl.FHud;

import java.util.*;

/**
 * {@link Draw2D} is cool
 *
 * @author Wagyourtail
 * @since 1.0.6
 */
@SuppressWarnings("unused")
public class Draw3D {
    private final Set<RenderElement3D> elements = new TreeSet<>();

    /**
     * @return
     * @since 1.0.6
     */
    public List<Box> getBoxes() {
        List<Box> list = new ArrayList<>();
        synchronized (elements) {
            for (RenderElement3D element : elements) {
                if (element instanceof Box) {
                    list.add((Box) element);
                }
            }
        }
        return list;
    }

    /**
     * @return
     * @since 1.0.6
     */
    public List<Line3D> getLines() {
        List<Line3D> list = new ArrayList<>();
        synchronized (elements) {
            for (RenderElement3D element : elements) {
                if (element instanceof Line3D) {
                    list.add((Line3D) element);
                }
            }
        }
        return list;
    }

    /**
     * @return
     * @since 1.6.5
     */
    public List<Surface> getDraw2Ds() {
        List<Surface> list = new ArrayList<>();
        synchronized (elements) {
            for (RenderElement3D element : elements) {
                if (element instanceof Surface) {
                    list.add((Surface) element);
                }
            }
        }
        return list;
    }

    /**
     * @since 1.8.4
     */
    public void clear() {
        synchronized (elements) {
            elements.clear();
        }
    }

    /**
     * @since 1.8.4
     * @param element
     */
    public void reAddElement(RenderElement3D element) {
        synchronized (elements) {
            elements.add(element);
        }
    }

    /**
     * @param box
     * @since 1.8.4
     */
    public void addBox(Box box) {
        synchronized (elements) {
            elements.add(box);
        }
    }

    /**
     * @param line
     * @since 1.8.4
     */
    public void addLine(Line3D line) {
        synchronized (elements) {
            elements.add(line);
        }
    }

    /**
     * @param surface
     * @since 1.8.4
     */
    public void addSurface(Surface surface) {
        synchronized (elements) {
            elements.add(surface);
        }
    }

    /**
     * @param x1
     * @param y1
     * @param z1
     * @param x2
     * @param y2
     * @param z2
     * @param color
     * @param fillColor
     * @param fill
     * @return The {@link Box} you added.
     * @since 1.0.6
     */
    public Box addBox(double x1, double y1, double z1, double x2, double y2, double z2, int color, int fillColor, boolean fill) {
        return addBox(x1, y1, z1, x2, y2, z2, color, fillColor, fill, false);
    }

    /**
     * @param x1
     * @param y1
     * @param z1
     * @param x2
     * @param y2
     * @param z2
     * @param color
     * @param fillColor
     * @param fill
     * @param cull
     * @return
     * @since 1.3.1
     */
    public Box addBox(double x1, double y1, double z1, double x2, double y2, double z2, int color, int fillColor, boolean fill, boolean cull) {
        Box b = new Box(x1, y1, z1, x2, y2, z2, color, fillColor, fill, cull);
        synchronized (elements) {
            elements.add(b);
        }
        return b;
    }

    /**
     * @param x1
     * @param y1
     * @param z1
     * @param x2
     * @param y2
     * @param z2
     * @param color
     * @param alpha
     * @param fillColor
     * @param fillAlpha
     * @param fill
     * @return the {@link Box} you added.
     * @since 1.1.8
     */
    public Box addBox(double x1, double y1, double z1, double x2, double y2, double z2, int color, int alpha, int fillColor, int fillAlpha, boolean fill) {
        return addBox(x1, y1, z1, x2, y2, z2, color, alpha, fillColor, fillAlpha, fill, false);
    }

    public Box addBox(double x1, double y1, double z1, double x2, double y2, double z2, int color, int alpha, int fillColor, int fillAlpha, boolean fill, boolean cull) {
        Box b = new Box(x1, y1, z1, x2, y2, z2, color, alpha, fillColor, fillAlpha, fill, cull);
        synchronized (elements) {
            elements.add(b);
        }
        return b;
    }

    /**
     * @param b
     * @return
     * @since 1.0.6
     */
    public Draw3D removeBox(Box b) {
        synchronized (elements) {
            elements.remove(b);
        }
        return this;
    }

    /**
     * @param x1
     * @param y1
     * @param z1
     * @param x2
     * @param y2
     * @param z2
     * @param color
     * @return the {@link Line3D} you added.
     * @since 1.0.6
     */
    public Line3D addLine(double x1, double y1, double z1, double x2, double y2, double z2, int color) {
        return addLine(x1, y1, z1, x2, y2, z2, color, false);
    }

    /**
     * @param x1
     * @param y1
     * @param z1
     * @param x2
     * @param y2
     * @param z2
     * @param color
     * @param cull
     * @return
     * @since 1.3.1
     */
    public Line3D addLine(double x1, double y1, double z1, double x2, double y2, double z2, int color, boolean cull) {
        Line3D l = new Line3D(x1, y1, z1, x2, y2, z2, color, cull);
        synchronized (elements) {
            elements.add(l);
        }
        return l;
    }

    /**
     * @param x1
     * @param y1
     * @param z1
     * @param x2
     * @param y2
     * @param z2
     * @param color
     * @param alpha
     * @return the {@link Line3D} you added.
     * @since 1.1.8
     */

    public Line3D addLine(double x1, double y1, double z1, double x2, double y2, double z2, int color, int alpha) {
        return addLine(x1, y1, z1, x2, y2, z2, color, alpha, false);
    }

    /**
     * @param x1
     * @param y1
     * @param z1
     * @param x2
     * @param y2
     * @param z2
     * @param color
     * @param alpha
     * @param cull
     * @return
     * @since 1.3.1
     */
    public Line3D addLine(double x1, double y1, double z1, double x2, double y2, double z2, int color, int alpha, boolean cull) {
        Line3D l = new Line3D(x1, y1, z1, x2, y2, z2, color, alpha, cull);
        synchronized (elements) {
            elements.add(l);
        }
        return l;
    }

    /**
     * @param l
     * @return
     * @since 1.0.6
     */
    public Draw3D removeLine(Line3D l) {
        synchronized (elements) {
            elements.remove(l);
        }
        return this;
    }

    /**
     * Draws a cube({@link Box}) with a specific radius({@code side length = 2*radius})
     *
     * @param point  the center point
     * @param radius 1/2 of the side length of the cube
     * @param color  point color
     * @return the {@link Box} generated, and visualized
     * @see Box
     * @since 1.4.0
     */
    public Box addPoint(Pos3D point, double radius, int color) {
        return addPoint(point.getX(), point.getY(), point.getZ(), radius, color);
    }

    /**
     * Draws a cube({@link Box}) with a specific radius({@code side length = 2*radius})
     *
     * @param x      x value of the center point
     * @param y      y value of the center point
     * @param z      z value of the center point
     * @param radius 1/2 of the side length of the cube
     * @param color  point color
     * @return the {@link Box} generated, and visualized
     * @see Box
     * @since 1.4.0
     */
    public Box addPoint(double x, double y, double z, double radius, int color) {
        return addBox(
                x - radius,
                y - radius,
                z - radius,
                x + radius,
                y + radius,
                z + radius,
                color,
                color,
                true,
                false
        );
    }

    /**
     * Draws a cube({@link Box}) with a specific radius({@code side length = 2*radius})
     *
     * @param x      x value of the center point
     * @param y      y value of the center point
     * @param z      z value of the center point
     * @param radius 1/2 of the side length of the cube
     * @param color  point color
     * @param alpha  alpha of the point
     * @param cull   whether to cull the point or not
     * @return the {@link Box} generated, and visualized
     * @see Box
     * @since 1.4.0
     */
    public Box addPoint(double x, double y, double z, double radius, int color, int alpha, boolean cull) {
        return addBox(
                x - radius,
                y - radius,
                z - radius,
                x + radius,
                y + radius,
                z + radius,
                color,
                color,
                alpha,
                alpha,
                true,
                cull
        );
    }

    /**
     * @param x top left
     * @param y
     * @param z
     * @return
     * @since 1.6.5
     */
    public Surface addDraw2D(double x, double y, double z) {
        return addDraw2D(x, y, z, 0, 0, 0, 1, 1, 200, false, false);
    }

    /**
     * @param x
     * @param y
     * @param z
     * @param width
     * @param height
     * @return
     * @since 1.6.5
     */
    public Surface addDraw2D(double x, double y, double z, double width, double height) {
        return addDraw2D(x, y, z, 0, 0, 0, width, height, 200, false, false);
    }

    /**
     * @param x
     * @param y
     * @param z
     * @param xRot
     * @param yRot
     * @param zRot
     * @return
     * @since 1.6.5
     */
    public Surface addDraw2D(double x, double y, double z, double xRot, double yRot, double zRot) {
        return addDraw2D(x, y, z, xRot, yRot, zRot, 1, 1, 200, false, false);
    }

    /**
     * @param x
     * @param y
     * @param z
     * @param xRot
     * @param yRot
     * @param zRot
     * @param width
     * @param height
     * @return
     * @since 1.6.5
     */
    public Surface addDraw2D(double x, double y, double z, double xRot, double yRot, double zRot, double width, double height) {
        return addDraw2D(x, y, z, xRot, yRot, zRot, width, height, 200, false, false);
    }

    /**
     * @param x
     * @param y
     * @param z
     * @param xRot
     * @param yRot
     * @param zRot
     * @param width
     * @param height
     * @param minSubdivisions
     * @return
     * @since 1.6.5
     */
    public Surface addDraw2D(double x, double y, double z, double xRot, double yRot, double zRot, double width, double height, int minSubdivisions) {
        return addDraw2D(x, y, z, xRot, yRot, zRot, width, height, minSubdivisions, false, false);
    }

    /**
     * @param x
     * @param y
     * @param z
     * @param xRot
     * @param yRot
     * @param zRot
     * @param width
     * @param height
     * @param minSubdivisions
     * @param renderBack
     * @return
     * @since 1.6.5
     */
    public Surface addDraw2D(double x, double y, double z, double xRot, double yRot, double zRot, double width, double height, int minSubdivisions, boolean renderBack) {
        return addDraw2D(x, y, z, xRot, yRot, zRot, width, height, minSubdivisions, renderBack, false);
    }

    /**
     * @param x               top left
     * @param y
     * @param z
     * @param xRot
     * @param yRot
     * @param zRot
     * @param width
     * @param height
     * @param minSubdivisions
     * @param renderBack
     * @return
     * @since 1.6.5
     */
    public Surface addDraw2D(double x, double y, double z, double xRot, double yRot, double zRot, double width, double height, int minSubdivisions, boolean renderBack, boolean cull) {
        Surface surface = new Surface(
                new Pos3D(x, y, z),
                new Pos3D(xRot, yRot, zRot),
                new Pos2D(width, height),
                minSubdivisions,
                renderBack,
                cull
        );
        synchronized (elements) {
            this.elements.add(surface);
        }
        return surface;
    }

    /**
     * @since 1.6.5
     */
    public void removeDraw2D(Surface surface) {
        synchronized (elements) {
            this.elements.remove(surface);
        }
    }

    /**
     * @return a new {@link Box.Builder} instance.
     * @since 1.8.4
     */
    public Box.Builder boxBuilder() {
        return new Box.Builder(this);
    }

    /**
     * @param pos the block position of the box
     * @return a new {@link Box.Builder} instance.
     * @since 1.8.4
     */
    public Box.Builder boxBuilder(BlockPosHelper pos) {
        return new Box.Builder(this).forBlock(pos);
    }

    /**
     * @param x the x coordinate of the box
     * @param y the y coordinate of the box
     * @param z the z coordinate of the box
     * @return a new {@link Box.Builder} instance.
     * @since 1.8.4
     */
    public Box.Builder boxBuilder(int x, int y, int z) {
        return new Box.Builder(this).forBlock(x, y, z);
    }

    /**
     * @return a new {@link Line3D.Builder} instance.
     * @since 1.8.4
     */
    public Line3D.Builder lineBuilder() {
        return new Line3D.Builder(this);
    }

    /**
     * @return a new {@link Surface.Builder} instance.
     * @since 1.8.4
     */
    public Surface.Builder surfaceBuilder() {
        return new Surface.Builder(this);
    }

    /**
     * register so it actually shows up
     *
     * @return self for chaining
     * @since 1.6.5
     */
    public Draw3D register() {
        FHud.renders.add(this);
        return this;
    }

    /**
     * @return self for chaining
     * @since 1.6.5
     */
    public Draw3D unregister() {
        FHud.renders.remove(this);
        return this;
    }

    public void render(DrawContext drawContext, float tickDelta) {
        MinecraftClient mc = MinecraftClient.getInstance();

        MatrixStack matrixStack = drawContext.getMatrices();
        matrixStack.push();
        //setup
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionColorProgram);

        Vec3d camPos = mc.gameRenderer.getCamera().getPos();
        matrixStack.translate(-camPos.x, -camPos.y, -camPos.z);

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();

        //sort elements by type
        synchronized (elements) {
            for (RenderElement3D element : elements) {
                element.render(drawContext, bufferBuilder, tickDelta);
            }
        }

        //reset
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);

        matrixStack.pop();

    }

}
