package com.yukitey;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsLifecycleTest {

    private StringUtils stringUtils;

    @BeforeEach
    void beforeEach() {
        // Arrange
        stringUtils = new StringUtils();
    }

    @Test
    @DisplayName("reverse('abc' должен вернуть 'cba'")
    void reverse_abcString() {
        // Act
        String result = stringUtils.reverse("abc");

        // Assert
        assertEquals("cba", result);
    }

    @Test
    @DisplayName("reverse('' должен вернуть ''")
    void reverse_blankString() {
        // Act
        String result = stringUtils.reverse("");

        // Assert
        assertEquals("", result);
    }


    @ParameterizedTest(name = "{index}: reverse({0}) == {1}")
    @CsvSource({"abc, cba", "hello, olleh", "a, a", "'',''"})
    void revere_csvSourceString(String input, String expected) {
        // Act
        String result = stringUtils.reverse(input);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("isPalindrome('level' должен вернуть true")
    void isPalindrome_levelAssertTrue() {
        // Act
        boolean result = stringUtils.isPalindrome("level");

        // Assert
        assertTrue(result);
    }

    @ParameterizedTest(name = "{index}: isPalindrome({0}) == true")
    @ValueSource(strings = {"level", "madam", "racecar"})
    @NullAndEmptySource
    void isPalindrome_levelingAsserParameterizedTrue(String input) {
        // Act
        boolean result = stringUtils.isPalindrome(input);

        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("isPalindrome('leveling' должен вернуть false")
    void isPalindrome_levelingAssertFalse() {
        // Act
        boolean result = stringUtils.isPalindrome("leveling");

        // Assert
        assertFalse(result);
    }

    @ParameterizedTest(name = "{index}: isPalindrome({0}) == false")
    @ValueSource(strings = {"hello", "world", "abc"})
    void isPalindrome_levelingAsserParameterizedFalse(String input) {
        // Act
        boolean result = stringUtils.isPalindrome(input);

        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("isPalindrome('' должен вернуть true")
    void isPalindrome_blankAssertEquals() {
        // Act
        boolean result = stringUtils.isPalindrome("");

        // Assert
        assertEquals(true, result);
    }

    @Test
    @DisplayName("isPalindrome специально провальный для рассмотрения assertAll")
    void isPalindrome_failAssertAll() {
        // Act
        boolean blankResult = stringUtils.isPalindrome("");

        assertAll(
                () -> assertTrue(blankResult),
                () -> fail("Что-то пошло не так")
        );
    }

    @Test
    @DisplayName("isPalindrome специально провальный для рассмотрения ленивого сообщения")
    void isPalindrome_lazyMessageFailAssertEquals() {
        boolean result = stringUtils.isPalindrome(null);

        assertEquals(true, result, () -> "Результат: " + result + ", ожидалось: true");
    }

    @ParameterizedTest
    @ValueSource(strings = {"level", "madam", "racecar", "topspot"})
    void isPalindrome_shouldReturnTrue(String word) {
        assertTrue(stringUtils.isPalindrome(word));
    }

    @ParameterizedTest(name = "{index}: isPalindrome({0}) == {1}")
    @MethodSource("providePalindromeCases")
    void isPalindrome_shouldReturnTrueMethodSource (String input, boolean expected){
        assertEquals(expected, stringUtils.isPalindrome(input));
    }

    static Stream<Arguments> providePalindromeCases(){
        return Stream.of(
                Arguments.of("level", true),
                Arguments.of("madam", true),
                Arguments.of("racecar", true),
                Arguments.of("topspot", true),
                Arguments.of("", true),
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "abc,   cba",
            "hello, olleh",
            "a,     a",
            "'',    ''"
    })
    void reverse_shouldReturnReversed(String input, String expected) {
        assertEquals(expected, stringUtils.reverse(input));
    }

    @ParameterizedTest
    @MethodSource("provideStringsForReverse")
    void reverse_MethodSourceShouldReturnReversed(String input, String expected) {
        assertEquals(expected, stringUtils.reverse(input));
    }

    static Stream<Arguments> provideStringsForReverse() {
        return Stream.of(
                Arguments.of("abc", "cba"),
                Arguments.of("hello", "olleh"),
                Arguments.of("a", "a")
        );
    }

    @AfterEach
    void afterEach() {
        stringUtils = null;
    }
}