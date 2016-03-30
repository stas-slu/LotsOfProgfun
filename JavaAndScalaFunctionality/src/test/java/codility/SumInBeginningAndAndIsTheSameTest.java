package codility;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SumInBeginningAndAndIsTheSameTest {

    @Test
    public void testSumInBeginningAndAndIsTheSameTest1(){
        int[] numbers = new int[]{1, 3, 3, 5, 2, 2};
        int numberOfNums = SumInBeginningAndAndIsTheSame.isSumInBeginningAndAndIsTheSame(numbers);
        assertThat(numberOfNums, is(2));
    }

    @Test
    public void testSumInBeginningAndAndIsTheSameTest2(){
        int[] numbers = new int[]{2, 3, 0, 1, 4, 0};
        int numberOfNums = SumInBeginningAndAndIsTheSame.isSumInBeginningAndAndIsTheSame(numbers);
        assertThat(numberOfNums, is(3));
    }
}
