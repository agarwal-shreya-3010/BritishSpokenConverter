package com.example.time;

/**
 * Factory to obtain TimeSpokenForm implementations.
 */
public final class TimeSpokenFormFactory {

    private TimeSpokenFormFactory() { /* no instances */ }

    public static TimeSpokenForm getFormatter(String style) {
        if (style == null) throw new IllegalArgumentException("style must not be null");
        switch (style.toLowerCase()) {
            case "british":
            case "british-english":
                return new BritishTimeSpokenForm();
            default:
                throw new UnsupportedOperationException("Unsupported style: " + style);
        }
    }
}
