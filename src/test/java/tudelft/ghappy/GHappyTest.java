package tudelft.ghappy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {

    // test 1 char g  !g
    // test 2 char g x, x g, x x, g g
    // test multiple g's in a row

    private GHappy gHappy;
    @BeforeEach
    void setup() {
        gHappy = new GHappy();
    }

    @ParameterizedTest(name = "WHEN `{0}` EXPECT happy")
    @CsvSource(value = { "''", "a", "bb", "ccc" })
    @DisplayName("Happy no g")
    void testOneChar(String testStrg) {
        assertTrue(gHappy.gHappy(testStrg));
    }

    @ParameterizedTest(name = "WHEN prefix `{0}` & suffix `{1}` EXPECT not happy")
    @CsvSource(value = { "'', ''", "'', a", "a, ''", "a, a" })
    @DisplayName("Unhappy 1g")
    void testSingleG(String prefix, String suffix) {
        String testStrg = prefix + "g" + suffix;
        assertFalse(gHappy.gHappy(testStrg));
    }

    @ParameterizedTest(name = "WHEN prefix `{0}` & suffix `{1}` EXPECT happy")
    @CsvSource(value = { "'', ''", "'', a", "a, ''", "a, a" })
    @DisplayName("Happy 2g")
    void testTwoG(String prefix, String suffix) {
        String testStrg = prefix + "gg" + suffix;
        assertTrue(gHappy.gHappy(testStrg));
    }

    @ParameterizedTest(name = "WHEN prefix `{0}` & suffix `{1}` EXPECT happy")
    @CsvSource(value = { "'', ''", "'', a", "a, ''", "a, a" })
    @DisplayName("Happy multi-g")
    void testMultipleG(String prefix, String suffix) {
        String testStrg = prefix + "ggg" + suffix;
        assertTrue(gHappy.gHappy(testStrg));
    }
}
