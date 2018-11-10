package tudelft.numfinder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NumFinderTest {

    private NumFinder nf;

    @BeforeEach
    void setup() {
        nf = new NumFinder();
    }

    @Nested
    @DisplayName("Largest")
    class TestLargest {

        @Test
        @DisplayName("WHEN one element EXPECT element")
        void testOneElement() {
            nf.find(new int[] { 3 });

            assertEquals(3, nf.getLargest());
        }

        @Test
        @DisplayName("WHEN zero element EXPECT element")
        void testZeroElements() {
            nf.find(new int[] {  });

            assertEquals(Integer.MIN_VALUE, nf.getLargest());
        }

        @Test
        @DisplayName("WHEN multiple elements EXPECT largest")
        void testMultipleElements() {
            nf.find(new int[] {4, 25, 7, 9});

            assertEquals(25, nf.getLargest());
        }

        @Test
        @DisplayName("WHEN multiple elements decending EXPECT largest")
        void testMultipleElementsDecending() {
            nf.find(new int[] {4, 3, 2, 1});

            assertEquals(4, nf.getLargest());
        }
    }

    @Nested
    @DisplayName("Smallest")
    class TestSmallest {

        @Test
        @DisplayName("WHEN one element EXPECT element")
        void testOneElement() {
            nf.find(new int[] { 3 });

            assertEquals(3, nf.getSmallest());
        }

        @Test
        @DisplayName("WHEN zero element EXPECT element")
        void testZeroElements() {
            nf.find(new int[] {  });

            assertEquals(Integer.MAX_VALUE, nf.getSmallest());
        }

        @Test
        @DisplayName("WHEN multiple elements EXPECT smallest")
        void testMultipleElements() {
            nf.find(new int[] {4, 25, 7, 9});

            assertEquals(4, nf.getSmallest());
        }

        @Test
        @DisplayName("WHEN multiple elements decending EXPECT largest")
        void testMultipleElementsAscending() {
            nf.find(new int[] {1, 2, 3, 4});

            assertEquals(1, nf.getSmallest());
        }
    }
}
