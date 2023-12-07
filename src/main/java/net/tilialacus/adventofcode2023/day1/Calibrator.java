package net.tilialacus.adventofcode2023.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calibrator {

    public static void main(String[] args) throws IOException {
        System.out.println(
                new Calibrator().calibrate(
                        Files.readAllLines(Paths.get("src/main/resources/day1-part1.txt")))
        );
    }

    public int calibrate(List<String> input) {
        return input.stream()
                .map(this::calibrate)
                .reduce(0, Integer::sum);
    }

    private int calibrate(String input) {
        int first = 0;
        int last = 0;

        for (int i = 0; i < input.length(); i++) {
            int digit = getDigit(input, i);
            if (digit != -1) {
                last = digit;
                if (first == 0) {
                    first = digit;
                }
            }
        }
        return first * 10 + last;
    }

    private static final String[] NUMBERS = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
    };
    private int getDigit(String input, int index) {
        char c = input.charAt(index);
        if (c >= '0' && c <= '9') {
            return c -'0';
        } else {
            for (int i = 0; i < NUMBERS.length; i++) {
                if (input.substring(index).startsWith(NUMBERS[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
}
