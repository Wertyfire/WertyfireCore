/**
 * File created on 14:41 17.09.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.gui.guidebook;

/**
 * Book element that stores link to page.
 * @author Wertyfire
 * @since 1.1.0
 * */
public class PageLink implements IBookElement {
    /**Text of link*/
    String text;
    /**Coordinates of link*/
    int x, y;
    /**What page should open this link*/
    int openPage;
    /**Size of link*/
    int width, height;

    /**
     * Default constructor.
     * @param text text of link.
     * @param x x position of link.
     * @param y y position of link.
     * @param openPage what page should open this link.
     * @param width width of link.
     * @param height height of link.
     * @since 1.1.0
     * */
    public PageLink(String text, int x, int y, int openPage, int width, int height) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.openPage = openPage;
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