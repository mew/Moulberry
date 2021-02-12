package zone.nora.moulberry;

import java.awt.*;
import java.awt.color.ColorSpace;

public class Colour extends Color {
    public Colour(int r, int g, int b) {
        super(r, g, b);
    }

    public Colour(int r, int g, int b, int a) {
        super(r, g, b, a);
    }

    public Colour(int rgb) {
        super(rgb);
    }

    public Colour(int rgba, boolean hasalpha) {
        super(rgba, hasalpha);
    }

    public Colour(float r, float g, float b) {
        super(r, g, b);
    }

    public Colour(float r, float g, float b, float a) {
        super(r, g, b, a);
    }

    public Colour(ColorSpace cspace, float[] components, float alpha) {
        super(cspace, components, alpha);
    }
}
