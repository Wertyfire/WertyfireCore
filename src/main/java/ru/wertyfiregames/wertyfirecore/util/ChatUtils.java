/**
 * File created on 23:19 22.07.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

/**
 * Class for chat utils.
 * @since 1.0.0
 * @author Wertyfire
 * */
public class ChatUtils {
    /**Don't let anyone instantiate this class.*/
    private ChatUtils() {}

    /**
     * Send message with clickable link.
     * @param player which player should see message.
     * @param beforeLinkKey translation key for text before link.
     * @param url what url should be opened.
     * @param urlKey translation key for text instead of link.
     * @param afterLinkKey translation key for text after link.
     * @since 1.0.0
     * @apiNote if linkKey starts with "http" used {@linkplain ChatComponentText} else - with I18n.format().
     * */
    public static void sendMessageWithLink(EntityPlayer player, String beforeLinkKey, String url, String urlKey, String afterLinkKey) {
        ChatComponentText beforeLinkText = new ChatComponentText(I18n.format(beforeLinkKey) + " ");
        ChatComponentText urlText = urlKey.startsWith("http") ? new ChatComponentText(url) : new ChatComponentText(I18n.format(urlKey));
        ChatComponentText afterLinkText = new ChatComponentText(I18n.format(afterLinkKey));

        ChatStyle linkStyle = new ChatStyle();
        linkStyle.setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentTranslation("chat.wertyfireCore.clickToOpenUrl")));
        linkStyle.setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
        linkStyle.setColor(EnumChatFormatting.AQUA);
        linkStyle.setUnderlined(true);

        urlText.setChatStyle(linkStyle);

        beforeLinkText.appendSibling(urlText);
        beforeLinkText.appendSibling(afterLinkText);

        player.addChatMessage(beforeLinkText);
    }

    /**
     * Send message with changelog from your update json.
     * @param player which player should see message.
     * @param s changelog.
     * @apiNote you can add languages to changelog (you should split them with "{@literal <}lang{@literal >}")
     * @apiNote supported languages order: english|russian
     * */
    public static void sendUpdateChangelogMessage(EntityPlayer player, String s) {
//        Order: 0-en_US;1-ru_RU
        String[] message = s.split("<lang>");
        String currentLanguage = Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode();

        if (currentLanguage.equals("ru_RU")) {
            for (String change : message[1].split("<n>")) {
                change = change.replace("<t>", "    ");
                player.addChatMessage(new ChatComponentText(change));
            }
        }
        else {
            for (String change : message[0].split("<n>")) {
                change = change.replace("<t>", "    ");
                player.addChatMessage(new ChatComponentText(change));
            }
        }
    }
}