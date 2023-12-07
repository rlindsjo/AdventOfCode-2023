package net.tilialacus.adventofcode2023.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalibratorTest {

    private Calibrator calibrator = new Calibrator();
    @ParameterizedTest
    @CsvSource({
            "1abc2,12",
            "pqr3stu8vwx,38",
            "a1b2c3d4e5f,15",
            "treb7uchet,77"
    })
    void singleLines(String input, int expected) {
        assertEquals(
                expected,
                calibrator.calibrate(List.of(input))
        );
    }

    @Test
    void allLines() {
        int result = calibrator.calibrate(List.of(
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet")
        );
        assertEquals(
                142,
                result
        );
    }

    @ParameterizedTest
    @CsvSource({
            "two1nine,29",
            "eightwothree,83",
            "abcone2threexyz,13",
            "xtwone3four,24",
            "4nineeightseven2,42",
            "zoneight234,14",
            "7pqrstsixteen,76",
    })
    void spelledOutDigits(String input, int expected) {
        assertEquals(
                expected,
                calibrator.calibrate(List.of(input))
        );
    }
}
