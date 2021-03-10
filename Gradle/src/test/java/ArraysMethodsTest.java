import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArraysMethodsTest {
    private final ArraysMethods arraysMethods = new ArraysMethods();

    @Test
    public void testElementsAfterFour() {
        int[] input = {3,2,1,4,5,9};
        int[] expected = {5,9};

        Assertions.assertArrayEquals(expected, arraysMethods.returnArrWithElementsAfterFour(input));

        input = new int[]{3,2,1,4,5,4,9};
        expected = new int[]{9};

        Assertions.assertArrayEquals(expected, arraysMethods.returnArrWithElementsAfterFour(input));

        input = new int[]{3,2,1,5,9};
        RuntimeException actual = null;

        try{
            arraysMethods.returnArrWithElementsAfterFour(input);
        } catch (RuntimeException e){
            actual = e;
        }

        assertNotNull(actual);

    }

    @Test
    public void testCheckArraysContent() {
        int[] input = {1, 1, 4, 4, 4, 1, 4};
        Assertions.assertTrue(arraysMethods.checkArraysContent(input));

        input = new int[]{1, 1, 1};
        Assertions.assertFalse(arraysMethods.checkArraysContent(input));

        input = new int[]{4, 4, 4};
        Assertions.assertFalse(arraysMethods.checkArraysContent(input));

        input = new int[]{4, 1, 3, 1, 4};
        Assertions.assertFalse(arraysMethods.checkArraysContent(input));

    }
}
