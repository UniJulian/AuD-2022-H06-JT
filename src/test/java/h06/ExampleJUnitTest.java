package h06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * An example JUnit test class.
 */
public class ExampleJUnitTest {

    @Test
    public void testMyIndexHoppingHashMap() {

        MyIndexHoppingHashMap<Integer,Integer> hopper = new MyIndexHoppingHashMap<>(10,1.5,0.7
            ,new LinearProbing<>(new Hash2IndexFct<>(10, 0)));
        hopper.put(12345, 6);
        hopper.put(12345, 7);

        for (int i = 0; i < 100000 ; i++) {
            hopper.put(i*214, i*3);
        }
        assertEquals(hopper.remove(214*100), 300);
        assertTrue(hopper.containsKey(4774 * 214));
        assertEquals(hopper.put(34785 * 214, 384),34785*3);
        assertEquals(hopper.getValue(23132 * 214), 23132*3);

        assertEquals(2, 1 + 1);
    }
}
