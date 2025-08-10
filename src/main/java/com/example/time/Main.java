package com.example.time;

import java.util.Scanner;

/**
 * CLI entrypoint. Minimal - for demos.
 */
public class Main {
    public static void main(String[] args) {
        TimeSpokenForm formatter = TimeSpokenFormFactory.getFormatter("british");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter time in HH:mm (24-hour) format: ");
            String input = scanner.nextLine();
            try {
                String spoken = formatter.toSpoken(input);
                System.out.println(spoken);
            } catch (IllegalArgumentException | UnsupportedOperationException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }
}
