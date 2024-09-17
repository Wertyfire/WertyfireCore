/**
 * File created on 14:49 17.09.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.gui.guidebook;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Simple chapter builder.
 * @author Wertyfire
 * @since 1.1.0
 * */
public class GuideBookChapterBuilder {
    /**Font renderer. Used to get string width and height.*/
    private FontRenderer fontRenderer;
    /**List of chapter content.*/
    private final List<IBookElement> content;

    public GuideBookChapterBuilder(IBookElement startingElement) {
        this(new IBookElement[]{ startingElement });
    }
    public GuideBookChapterBuilder(IBookElement[] startingElements) {
        this();
        for (int i = 0; i < startingElements.length; i++)
            content.add(i, startingElements[i]);
    }
    /**
     * Default constructor. Sets content to new array list and fontRenderer to font renderer from Minecraft class.
     * @since 1.1.0
     * */
    public GuideBookChapterBuilder() {
        content = new ArrayList<>();
        fontRenderer = Minecraft.getMinecraft().fontRenderer;
    }
    public GuideBookChapterBuilder(GuideBookChapterBuilder builder) {
        content = builder.content;
        fontRenderer = Minecraft.getMinecraft().fontRenderer;
    }

    /**
     * Set custom font renderer.
     * @param renderer custom font renderer.
     * @since 1.1.0
     * */
    public GuideBookChapterBuilder setCustomFontRenderer(FontRenderer renderer) {
        fontRenderer = renderer;
        return this;
    }

    public GuideBookChapterBuilder add(IBookElement element) {
        content.add(element);
        return this;
    }
    public GuideBookChapterBuilder add(IBookElement[] elements) {
        Collections.addAll(content, elements);
        return this;
    }
    public GuideBookChapterBuilder add(GuideBookChapterBuilder builder) {
        content.addAll(builder.content);
        return this;
    }

    /**
     * Add usual text to builder.
     * @param text text.
     * @param xPos x position.
     * @param yPos y position.
     * @param splitLine should split line when limit reached.
     * @param maxWidth max width of string when line should be separated.
     * @param useAlignment use alignment for this string (left, center or right).
     * @param alignment alignment of string. Will only be used when useAlignment is true.
     * @since 1.1.0
     * */
    public GuideBookChapterBuilder addText(String text, int xPos, int yPos, boolean splitLine, int maxWidth, boolean useAlignment, Alignment alignment) {
        Text element;
        element = new Text(text, xPos, yPos, fontRenderer.getStringWidth(text), fontRenderer.FONT_HEIGHT);
        if (splitLine) element.setSplit(maxWidth);
        if (useAlignment) element.setAlignment(alignment);
        content.add(element);
        return this;
    }

    /**
     * Add link to page to builder.
     * @param linkText text of link.
     * @param xPos x position of link.
     * @param yPos y position of link.
     * @param openPage which page should be opened when clicked.
     * @since 1.1.0
     * */
    public GuideBookChapterBuilder addPageLink(String linkText, int xPos, int yPos, int openPage) {
        content.add(new PageLink(linkText, xPos, yPos, openPage, fontRenderer.getStringWidth(linkText), fontRenderer.FONT_HEIGHT));
        return this;
    }

    /**
     * Add URL link to builder.
     * @param linkText text of link.
     * @param url which url should be opened when clicked.
     * @param xPos x position of link.
     * @param yPos y position of link.
     * @since 1.1.0
     * */
    public GuideBookChapterBuilder addURLLink(String linkText, String url, int xPos, int yPos) {
        content.add(new URLLink(linkText, url, xPos, yPos, fontRenderer.getStringWidth(linkText), fontRenderer.FONT_HEIGHT));
        return this;
    }

    /**
     * Build content.
     * @since 1.1.0
     * */
    public List<IBookElement> build() {
        return content;
    }
}