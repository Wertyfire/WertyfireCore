/**
 * File created on 14:40 17.09.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.gui.guidebook;

/**
 * Interface to indicate that given object is element of guide book.
 * @author Wertyfire
 * @since 1.1.0
 * */
public interface IBookElement {
    /**Check if mouse over component*/
    boolean isMouseOver(int mouseX, int mouseY);
}