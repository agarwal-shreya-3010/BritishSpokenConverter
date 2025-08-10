package com.example.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

/**
 * British English spoken form implementation.
 * Examples:
 *  11:55 -> "five to twelve"
 *  06:32 -> "six thirty-two"
 *  00:00 -> "midnight"
 *  12:00 -> "noon"
 */
public class BritishTimeSpokenForm implements TimeSpokenForm {

    private static final String[] HOURS = {
            "twelve", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven"
    };

    private static final String[] NUM_WORDS = {
            "zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
            "twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five",
            "twenty-six", "twenty-seven", "twenty-eight", "twenty-nine", "thirty",
            "thirty-one", "thirty-two", "thirty-three", "thirty-four", "thirty-five",
            "thirty-six", "thirty-seven", "thirty-eight", "thirty-nine", "forty",
            "forty-one", "forty-two", "forty-three", "forty-four", "forty-five",
            "forty-six", "forty-seven", "forty-eight", "forty-nine", "fifty",
            "fifty-one", "fifty-two", "fifty-three", "fifty-four", "fifty-five",
            "fifty-six", "fifty-seven", "fifty-eight", "fifty-nine"
    };

    private static final DateTimeFormatter PARSER = DateTimeFormatter.ofPattern("H:mm");

    @Override
    public String toSpoken(String time) {
        Objects.requireNonNull(time, "time must not be null");
        LocalTime lt;
        try {
            lt = LocalTime.parse(time.trim(), PARSER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid time format. Expected HH:mm (24-hour).", e);
        }

        int hour = lt.getHour();
        int minute = lt.getMinute();

        // special cases
        if (hour == 0 && minute == 0) return "midnight";
        if (hour == 12 && minute == 0) return "noon";

        int displayHour = hour % 12;
        if (displayHour == 0) displayHour = 12; // convert 0 -> 12

        String spokenHour = HOURS[(displayHour % 12)];
        String nextHour = HOURS[(displayHour % 12 + 1) % 12];

        if (minute == 0) {
            return spokenHour + " o'clock";
        } else if (minute == 15) {
            return "quarter past " + spokenHour;
        } else if (minute == 30) {
            return "half past " + spokenHour;
        } else if (minute == 45) {
            return "quarter to " + nextHour;
        } else if (minute < 30 && minute % 5 == 0) {
            return NUM_WORDS[minute] + " past " + spokenHour;
        } else if (minute > 30 && (60 - minute) % 5 == 0) {
            return NUM_WORDS[60 - minute] + " to " + nextHour;
        } else {
            // digital-style: "six thirty-two"
            return spokenHour + " " + NUM_WORDS[minute];
        }
    }
}
