package com.yukitey;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TimerAndThrowTest {
    @Test
    void parse_shouldNotThrow_whenInputValid() {
        assertDoesNotThrow(() -> Integer.parseInt("123"));
    }

    @Test
    void process_shouldFinishIn1Second() {
        assertTimeout(Duration.ofSeconds(1), () -> {
            Thread.sleep(500);
        });
    }


    @Test
    void process_shouldPreemptivelyFinishIn1Second() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            Thread.sleep(500);
        });
    }
}