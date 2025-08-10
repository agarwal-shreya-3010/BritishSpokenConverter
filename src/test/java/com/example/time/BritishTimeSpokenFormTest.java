package com.example.time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;                   // JUnit 4
import static org.junit.Assert.assertThrows;

public class BritishTimeSpokenFormTest {

    private final TimeSpokenForm formatter = new BritishTimeSpokenForm();

    @Test
    public void testExactHours() {
        assertEquals("one o'clock", formatter.toSpoken("01:00"));
        assertEquals("noon", formatter.toSpoken("12:00"));
        assertEquals("midnight", formatter.toSpoken("00:00"));
    }

    @Test
    public void testPastVariants() {
        assertEquals("five past two", formatter.toSpoken("14:05"));
        assertEquals("ten past three", formatter.toSpoken("03:10"));
        assertEquals("quarter past four", formatter.toSpoken("04:15"));
        assertEquals("twenty past five", formatter.toSpoken("05:20"));
        assertEquals("twenty-five past six", formatter.toSpoken("06:25"));
    }

    @Test
    public void testHalfAndQuarterTo() {
        assertEquals("half past seven", formatter.toSpoken("07:30"));
        assertEquals("quarter to eight", formatter.toSpoken("07:45"));
    }

    @Test
    public void testToVariants() {
        assertEquals("twenty-five to eight", formatter.toSpoken("07:35"));
        assertEquals("twenty to nine", formatter.toSpoken("08:40"));
        assertEquals("quarter to ten", formatter.toSpoken("09:45"));
        assertEquals("ten to eleven", formatter.toSpoken("10:50"));
        assertEquals("five to twelve", formatter.toSpoken("11:55"));
    }

    @Test
    public void testDigitalStyle() {
        assertEquals("six thirty-two", formatter.toSpoken("06:32"));
        assertEquals("eleven fifty-nine", formatter.toSpoken("11:59"));
    }

    @Test
    public void invalidFormatThrows() {
        assertThrows(IllegalArgumentException.class, () -> formatter.toSpoken("99:99"));
        assertThrows(IllegalArgumentException.class, () -> formatter.toSpoken("abcd"));
        assertThrows(NullPointerException.class, () -> formatter.toSpoken(null));
    }
}
