package com.kojavaee.actor;

public class Utils {
    /** Test if string is null or empty. */
    public static boolean isEmpty(CharSequence s) {
        return s == null || s.length() == 0;
    }
    
    /** Truncate a text string to 100 characters. */
    public static String truncate(Object s) {
        return s != null ? truncate(s.toString(), 100) : "null";
    }
    
    /** Truncate a text string to size characters. */
    public static String truncate(String s, int size) {
        if (!isEmpty(s)) {
            s = removeMultipleSpaces(s);
            if (s.length() > size) {
                int leadLength = size / 2;
                int tailLength = size / 2;
                s = s.substring(0, leadLength) + " ... "
                        + s.substring(s.length() - tailLength);
            }
        }
        return s;
    }
    
    /** Remove repeated whitespace (including newlines) */
    public static String removeMultipleSpaces(String s) {
        return removeMultipleSpaces(s, ' ');
    }

    /** Remove repeated whitespace (including newlines) */
    public static String removeMultipleSpaces(String s, char nlReplace) {
        if (!isEmpty(s)) {
            // s = s.replace('\n', nlReplace);
            s = s.replaceAll("\\s\\s+", " ");
        }
        return s;
    }

}
