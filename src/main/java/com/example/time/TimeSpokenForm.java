package com.example.time;

/**
 * Strategy interface for converting a time string (HH:mm) into a spoken form.
 */
public interface TimeSpokenForm {
    /**
     * Convert a time string in HH:mm (24-hour) format into spoken words.
     *
     * @param time in format "HH:mm" (e.g. "23:05")
     * @return spoken form (e.g. "five past eleven")
     * @throws IllegalArgumentException if input is invalid
     */
    String toSpoken(String time);
}
