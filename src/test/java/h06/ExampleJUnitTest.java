package h06;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * An example JUnit test class.
 */
public class ExampleJUnitTest {

    @Test
    public void testMyIndexHoppingHashMap() {

        MyIndexHoppingHashMap<Integer,Integer> hopper2 = new MyIndexHoppingHashMap<>(100,1.1,0.9
            ,new LinearProbing<>(new Hash2IndexFct<>(10, 0)));
        MyListsHashMap<Integer,Integer> hopper = new MyListsHashMap<>(new Hash2IndexFct<>(20000, 0));
        hopper.put(12345, 6);
        hopper.put(12345, 7);

        for (int i = 0; i < 100000 ; i++) {
            hopper.put(i*214, i*3);
        }
        assertEquals( 300,hopper.remove(214*100));
        assertTrue(hopper.containsKey(4774 * 214));
        assertEquals(75634*3,hopper.put(75634 * 214, 384));
        assertEquals(23132*3,hopper.getValue(23132 * 214));

        assertEquals(2, 1 + 1);

    }

    @Test
    public void CalendarTest() {
        RuntimeTest.test(RuntimeTest.createTestSet(2,1,2,2,RuntimeTest.generateTestdata()));

    }



}
