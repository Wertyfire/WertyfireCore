/**
 * File created on 20:58 03.08.2024 by Wertyfire
 */

package ru.wertyfiregames.wertyfirecore.util;

/**
 * Class provides utils for class String.
 * @since 1.0.2
 * @author Wertyfire
 * */
public class StringUtils {
    /**
     * Check is string is null or empty.
     * @return is string null or empty.
     * @param s string to check.
     * @since 1.0.2
     * */
    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }
    /**
     * Check is string contains at least 1 character.
     * @return is string contains at least 1 character.
     * @param s string to check.
     * @since 1.0.2
     * */
    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }
}