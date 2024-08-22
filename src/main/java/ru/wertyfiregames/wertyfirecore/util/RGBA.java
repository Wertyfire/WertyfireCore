/**
 * File created on 15:25 22.08.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.util;

/**
 * Class to store rgba color.
 * @since 1.0.2
 * @author Wertyfire
 * */
public class RGBA {
    /**Red*/
    private int red;
    /**Green*/
    private int green;
    /**Blue*/
    private int blue;
    /**Alpha*/
    private float alpha;

    /**
     * Default constructor to create white color.
     * @since 1.0.2
     * */
    public RGBA() {
        red=255;
        green=255;
        blue=255;
        alpha=1f;
        validate();
    }

    /**
     * Create RGBA with red, green, blue colors with alpha = 1f.
     * @since 1.0.2
     * @param red red.
     * @param green green.
     * @param blue blue.
     * */
    public RGBA(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        alpha = 1f;
        validate();
    }
    /**
     * Create RGBA wit red, green, blue colors and alpha.
     * @since 1.0.2
     * @param red red.
     * @param green green.
     * @param blue blue.
     * @param alpha opacity.
     * */
    public RGBA(int red, int green, int blue, float alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
        validate();
    }

    /**
     * Copy RGBA from another RGBA.
     * @since 1.0.2
     * @param toCopy RGBA to copy.
     * */
    public RGBA(RGBA toCopy) {
        red = toCopy.r();
        green = toCopy.g();
        blue = toCopy.b();
        alpha = toCopy.a();
        validate();
    }

    /**
     * Create RGBA from inted rgba.
     * @since 1.0.2
     * @param rgba rgba in int.
     * @see #intToRGBA(int)
     * */
    public RGBA(int rgba) {
        this(intToRGBA(rgba));
        validate();
    }

    /**
     * Build int from RGBA.
     * @since 1.0.2
     * @return int created from RGBA
     * @param rgba RGBA to build.
     * */
    public static int RGBAtoInt(RGBA rgba) {
        return ((int) rgba.a() << 24) | (rgba.r() << 16) | (rgba.g() << 8) | rgba.b();
    }

    /**
     * Parse int to RGBA.
     * @since 1.0.2
     * @return RGBA parsed from int.
     * @param rgba int to parse.
     * */
    public static RGBA intToRGBA(int rgba) {
        int a, r, g, b;

        if ((rgba >> 24) == 0) {
            a = 255;
        } else {
            a = (rgba >> 24) & 0xFF;
        }

        r = (rgba >> 16) & 0xFF;
        g = (rgba >> 8) & 0xFF;
        b = rgba & 0xFF;
        return new RGBA(r, g, b, a);
    }

    /**
     * Check if color and opacity values in their bounds.
     * @since 1.0.2
     * */
    private void validate() {
        if (red > 255) red = 255;
        else if (red < 0) red = 0;

        if (green > 255) green = 255;
        else if (green < 0) green = 0;

        if (blue > 255) blue = 255;
        else if (blue < 0) blue = 0;

        if (alpha > 1f) alpha = 1f;
        else if (alpha < 0f) alpha = 0f;
    }

    /**
     * Get red color from RGBA.
     * @since 1.0.2
     * @return red.
     * */
    public int r() {
        return red;
    }
    /**
     * Get green color from RGBA.
     * @since 1.0.2
     * @return green.
     * */
    public int g() {
        return green;
    }
    /**
     * Get blue color from RGBA.
     * @since 1.0.2
     * @return blue.
     * */
    public int b() {
        return blue;
    }
    /**
     * Get opacity from RGBA.
     * @since 1.0.2
     * @return opacity.
     * */
    public float a() {
        return alpha;
    }

    @Override
    public String toString() {
        return "Red='" + red + "', green='" + green + "', blue='" + blue + "', alpha='" + alpha + "'";
    }
}