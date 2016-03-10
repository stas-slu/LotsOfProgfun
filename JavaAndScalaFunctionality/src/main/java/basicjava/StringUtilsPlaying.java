package basicjava;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import static org.hamcrest.core.Is.is;

/**
 * Playing with StringUtils.isNotEmpty() VS StringUtils.isNotBlank()
 *
 * http://sbollam.blogspot.co.il/2013/02/stringutilsisnotempty-vs.html
 */
public class StringUtilsPlaying {

    public static void main(String[] argc){
        /**
         * isNotEmpty
         */
        Assert.assertThat(StringUtils.isNotEmpty(null), is(false)); //empty!
        Assert.assertThat(StringUtils.isNotEmpty(""), is(false)); //empty!

        Assert.assertThat(StringUtils.isNotEmpty(" "), is(true));
        Assert.assertThat(StringUtils.isNotEmpty("bob"), is(true));
        Assert.assertThat(StringUtils.isNotEmpty("  bob  "), is(true));

        /**
         * isNotBlank
         */
        Assert.assertThat(StringUtils.isNotBlank(null), is(false)); //blank!
        Assert.assertThat(StringUtils.isNotBlank(""), is(false)); //blank!
        Assert.assertThat(StringUtils.isNotBlank(" "), is(false)); //blank!

        Assert.assertThat(StringUtils.isNotBlank("bob"), is(true));
        Assert.assertThat(StringUtils.isNotBlank("  bob  "), is(true));

        /**
         * Difference: the WHITESPACE
         */
    }
}
