import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class SILab2Test {

    @Test
    public void testAllItemsNull() {
        try {
            SILab2.checkCart(null, 100);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("allItems list can't be null!", e.getMessage());
        }
    }

    @Test
    public void testValidItemAllConditionsMet() {
        List<Item> items = Arrays.asList(new Item("bread", "012345", 350, 0.1f));
        assertTrue(SILab2.checkCart(items, 315));
    }

    @Test
    public void testInvalidBarcodeCharacter() {
        List<Item> items = Arrays.asList(new Item("milk", "0-12345", 50, 0));
        try {
            SILab2.checkCart(items, 100);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Invalid character in item barcode!", e.getMessage());
        }
    }

    @Test
    public void testMissingBarcode() {
        List<Item> items = Arrays.asList(new Item("milk", null, 50, 0));
        try {
            SILab2.checkCart(items, 100);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("No barcode!", e.getMessage());
        }
    }

    @Test
    public void testNameIsNull() {
        List<Item> items = Arrays.asList(new Item(null, "012345", 50, 0));
        assertTrue(SILab2.checkCart(items, 100));
    }

    @Test
    public void testPriceGreaterThan300DiscountPositiveAndBarcodeStartsWith0() {
        List<Item> items = Arrays.asList(new Item("cheese", "012345", 350, 0.1f));
        assertTrue(SILab2.checkCart(items, 285));
    }

    @Test
    public void testPriceGreaterThan300DiscountPositiveAndBarcodeNotStartsWith0() {
        List<Item> items = Arrays.asList(new Item("cheese", "112345", 350, 0.1f));
        assertTrue(SILab2.checkCart(items, 315));
    }

    @Test
    public void testPriceGreaterThan300DiscountZero() {
        List<Item> items = Arrays.asList(new Item("meat", "012345", 350, 0));
        assertTrue(SILab2.checkCart(items, 350));
    }

    @Test
    public void testSumExceedsPayment() {
        List<Item> items = Arrays.asList(new Item("fish", "012345", 400, 0.1f));
        assertFalse(SILab2.checkCart(items, 300));
    }
}