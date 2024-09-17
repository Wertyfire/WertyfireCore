/**
 * File created on 15:19 17.09.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.gui.guidebook;

/**
 * Basic component that stores usual text.
 * @author Wertyfire
 * @since 1.1.0
 * */
public class Text implements IBookElement {
    /**Contained text*/
    String text;
    /**Coordinates of text*/
    int x, y;
    /**Size of text*/
    int width, height;
    /**Should text be split*/
    boolean split;
    /**Max width of line
     * @see #split*/
    int maxLineWidth;
    /**Has alignment*/
    boolean aligned;
    /**Alignment of text
     * @see #aligned*/
    Alignment textAlignment;

    /**
     * Default constructor.
     * @param text text.
     * @param x x position.
     * @param y y position.
     * @param width width of text.
     * @param height height of text.
     * */
    public Text(String text, int x, int y, int width, int height) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        split = false;
        aligned = false;
    }

    /**
     * Set max length for line to split.
     * @param maxWidth max width of line.
     * @since 1.1.0
     * */
    public Text setSplit(int maxWidth) {
        split = true;
        maxLineWidth = maxWidth;
        return this;
    }

    /**
     * Set alignment for text.
     * @param alignment alignment.
     * @since 1.1.0
     * */
    public Text setAlignment(Alignment alignment) {
        aligned = true;
        textAlignment = alignment;
        return this;
    }

    /**
     * Check if mouse is over link.
     * @return if mouse is over link.
     * @param mouseX mouse x position.
     * @param mouseY mouse y position.
     * @since 1.1.0
     * */
    public boolean isMouseOver(int mouseX, int mouseY) {
        return mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height;
    }
}