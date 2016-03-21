import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoToOneTest {

    @Test
    public void test() {
        System.out.println("longest Fixed Tests A");
        assertEquals("aehrsty", TwoToOne.longest("aretheyhere", "yestheyarehere"));
        assertEquals("abcdefghilnoprstu", TwoToOne.longest("loopingisfunbutdangerous", "lessdangerousthancoding"));
        assertEquals("acefghilmnoprstuy", TwoToOne.longest("inmanylanguages", "theresapairoffunctions"));

        System.out.println("longest Fixed Tests B");
        assertEquals("aehrsty", TwoToOne.longest2("aretheyhere", "yestheyarehere"));
        assertEquals("abcdefghilnoprstu", TwoToOne.longest2("loopingisfunbutdangerous", "lessdangerousthancoding"));
        assertEquals("acefghilmnoprstuy", TwoToOne.longest2("inmanylanguages", "theresapairoffunctions"));
    }
}
