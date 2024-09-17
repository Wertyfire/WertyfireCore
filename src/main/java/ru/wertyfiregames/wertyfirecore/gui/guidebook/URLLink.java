/**
 * File created on 15:11 17.09.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.gui.guidebook;

public class URLLink implements IBookElement {
    /**Text of link*/
    String text;
    /**What address should open this link*/
    String url;
    /**Coordinates of link*/
    int x, y;
    /**Size of link*/
    int width, height;

    /**
     * Default constructor.
     * @param text text.
     * @param url url.
     * @param x x position.
     * @param y y position.
     * @param width width of text.
     * @param height height of text.
     * */
    public URLLink(String text, String url, int x, int y, int width, int height) {
        this.text = text;
        this.url = url;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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