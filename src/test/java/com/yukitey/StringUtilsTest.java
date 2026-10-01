package com.yukitey;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    @Test
    @DisplayName("reverse('abc' должен вернуть 'cba'")
    void reverse_abcString() {
        // Arrange
        StringUtils stringUtils = new StringUtils();

        // Act
        String result = stringUtils.reverse("abc");

        // Assert
        assertEquals("cba", result);
    }
}