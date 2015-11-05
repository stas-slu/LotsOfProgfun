import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroTest{

    static String[] quotes = { "Quote Hidden in example test",
            "Holy haberdashery, Batman!",
            "Quote Hidden in example test"
    };

    @Test
    public void test1(){
        assertEquals("Fail", "Robin: Holy haberdashery, Batman!", RobinQuotes.getQuote(quotes, "Rob1n"));
    }
}