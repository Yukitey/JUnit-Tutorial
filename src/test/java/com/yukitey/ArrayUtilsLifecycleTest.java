package com.yukitey;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsLifecycleTest {

    private ArrayUtils arrayUtils;

    @BeforeEach
    void beforeEach() {
        // Arrange
        arrayUtils = new ArrayUtils();
    }

    @Test
    @DisplayName("sort({3, 1, 2}, должен вернуть {1, 2 ,3}")
    void sort_312AssertArrayEquals(){
        // Arrange
        int [] arr = {3,1,2};

        // Act
        int[] result = arrayUtils.sort(arr);

        // Assert
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, result);
    }

    @AfterEach
    void afterEach() {
        arrayUtils = null;
    }
}