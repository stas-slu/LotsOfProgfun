package codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BiggestIntegerTests {

    @Test
    public void testBiggestNumber1(){
        Codility.twoMinimumNumbersInArray();
        int[] numbers = new int[]{3, 5 ,4};
        int biggestInteger = BiggestInteger.findBiggestInteger(numbers);
        assertEquals(biggestInteger, 543);
    }

    @Test
    public void testBiggestNumber2(){
        int[] numbers = new int[]{1, 9 ,8};
        int biggestInteger = BiggestInteger.findBiggestInteger(numbers);
        assertEquals(biggestInteger, 981);
    }

    @Test
    public void testBiggestNumber3(){
        int[] numbers = new int[]{0, 9 ,8};
        int biggestInteger = BiggestInteger.findBiggestInteger(numbers);
        assertEquals(biggestInteger, 980);
    }

    @Test
    public void testBiggestNumber4(){
        int[] numbers = new int[]{0, 9 ,0};
        int biggestInteger = BiggestInteger.findBiggestInteger(numbers);
        assertEquals(biggestInteger, 900);
    }
}
