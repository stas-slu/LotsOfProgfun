package JmockExperimenting;


import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Christopher Bartling, Pintail Consulting LLC
 * @since Sep 4, 2008 12:08:38 AM
 *
 * https://sites.google.com/a/pintailconsultingllc.com/java/jmock-examples
 */
public class PricingServiceTests {

    private static final String SKU = "3283947";
    private static final String BAD_SKU = "-9999993434";

    private PricingService systemUnderTest;
    private DataAccess mockedDependency;

    @Rule
    public JUnitRuleMockery mockingContext = new JUnitRuleMockery();

    /* Also could be used instead of mockedDependency = mockingContext.mock(DataAccess.class);
    @Mock
    DataAccess mockedDependency; //Using annotation to create mock object!
    */

    @Before
    public void doBeforeEachTestCase() {
        systemUnderTest = new PricingServiceImpl();
        mockedDependency = mockingContext.mock(DataAccess.class);
        systemUnderTest.setDataAccess(mockedDependency);
    }

    @Test
    public void getPrice() throws SkuNotFoundException {
        mockingContext.checking(new Expectations() {
            {
                oneOf(mockedDependency).getPriceBySku(SKU);
                will(returnValue(new BigDecimal(100)));
            }
        });
        final BigDecimal testPrice = systemUnderTest.getPrice(SKU);
    }

    @Test(expected = SkuNotFoundException.class)
    public void getPriceNonExistentSkuThrowsException() throws SkuNotFoundException {
        mockingContext.checking(new Expectations() {
            {
                one(mockedDependency).getPriceBySku(BAD_SKU);
                will(returnValue(null));
            }
        });
        final BigDecimal price = systemUnderTest.getPrice(BAD_SKU);
    }

    @Test(expected = RuntimeException.class)
    public void getPriceDataAccessThrowsRuntimeException() throws SkuNotFoundException {
        mockingContext.checking(new Expectations() {
            {
                allowing(mockedDependency).getPriceBySku(with(any(String.class)));
                will(throwException(new RuntimeException("Fatal data access exception.")));
            }
        });
        final BigDecimal price = systemUnderTest.getPrice(SKU);
    }
}

interface PricingService {

    void setDataAccess(DataAccess dataAccess);

    BigDecimal getPrice(String sku) throws SkuNotFoundException;
}

interface DataAccess {

    BigDecimal getPriceBySku(String sku);
}

class PricingServiceImpl implements PricingService {

    private DataAccess dataAccess;

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public BigDecimal getPrice(String sku) throws SkuNotFoundException {
        final BigDecimal price = this.dataAccess.getPriceBySku(sku);
        if (price == null) {
            throw new SkuNotFoundException();
        }
        return price;
    }
}

class SkuNotFoundException extends Throwable {
}
