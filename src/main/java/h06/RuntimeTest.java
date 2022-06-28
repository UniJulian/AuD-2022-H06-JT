package h06;

import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RuntimeTest {
    private final static int TEST_SET_SIZE = 1_000;

    /**
     * Generates two test data sets with 1,000 dates each.
     * The first test data set is in component 0 of the returned array and is initialized with true.
     * The second test data set is in component 1 of the returned array and is initialized with false.
     * The dates are between 1970 and 2022.
     *
     * @return Two test data sets of 1,000 dates each.
     */
    public static MyDate[][] generateTestdata() {
        MyDate[][] data = new MyDate[2][TEST_SET_SIZE];


        for (int i = 0; i < TEST_SET_SIZE; i++) {
            int exde = 0;
            exde = ThreadLocalRandom.current().nextInt(0,12);
            int y = 30;
            if((exde == 0 )|| (exde == 2 )|| (exde == 4) ||(exde == 6) ||(exde == 7) ||(exde == 9) ||(exde == 11))
                y = 31;
            if(exde == 1)
                y = 28;
            GregorianCalendar calendar = new GregorianCalendar( // ist stumpf ich weiß I'm sorry
                ThreadLocalRandom.current().nextInt(1970,2023)
                ,exde
                ,ThreadLocalRandom.current().nextInt(0,y)
                ,ThreadLocalRandom.current().nextInt(0,24)
                ,ThreadLocalRandom.current().nextInt(0,60));
            data[0][i] = new MyDate(calendar,true);
            data[1][i] = new MyDate(calendar,false);
        }

        return data;
    }

    /**
     * Generates a test set.
     *
     * @param i        See exercise sheet.
     * @param j        See exercise sheet.
     * @param k        See exercise sheet.
     * @param l        See exercise sheet.
     * @param testData The testdata used.
     * @return A test set.
     */
    public static TestSet<MyDate> createTestSet(int i, int j, int k, int l, MyDate[][] testData) {

        int size;

        if(l == 1)
            size = (int) Math.pow(2,12);
        else if(l == 2)
            size = (int) Math.pow(2,6);
        else
            throw new RuntimeException("why");

        BinaryFct2Int<MyDate> fct2Int;
        if(k == 1)
            fct2Int = new LinearProbing<>(new Hash2IndexFct<>(size, 0));
        else if(k == 2)
            fct2Int = new DoubleHashing<>(new Hash2IndexFct<>(size,0), new Hash2IndexFct<>(size,42));
        else
            throw new RuntimeException("why");


        MyMap<MyDate,MyDate> map;
        if(j == 1)
           map = new MyIndexHoppingHashMap<>(size,2,0.75,fct2Int);
        else if (j == 2)
            map = new MyListsHashMap<>(new Hash2IndexFct<>(size,0));
        else
            throw new RuntimeException("why");

        return new TestSet<>(map,testData[i-1]);
    }

    /**
     * Tests the given test set.
     *
     * @param testSet The test set to test.
     */
    public static void test(TestSet<MyDate> testSet) {
        MyDate[] data = testSet.getTestData();
        MyMap<MyDate,MyDate> map = testSet.getHashTable();
        int counter = 0;
        int counter2 = 0;
        int counter3 = 0;
        MyDate[] values = new MyDate[750];

        for (int i = 0; i < 750; i++) {
            map.put(data[i],data[i]);
        }
        System.out.println(1);
        for (int i = 0; i <750; i++) {
            if(map.containsKey(data[i]))
                counter++;
        }

        for (int i = 0; i <750; i++) {
            if(map.containsKey(data[i])){
                values[i] = map.getValue(data[i]);
                counter3++;
            }

        }
        for (int i = 0; i <750; i++){
            MyDate dat = map.remove(data[i]);
            if(dat != null){
                counter2++;
            }
        }

        System.out.println(counter);
        System.out.println(counter2);
        System.out.println(counter3);


    }
}
