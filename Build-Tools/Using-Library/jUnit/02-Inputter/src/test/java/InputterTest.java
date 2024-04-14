
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputterTest {

    @Test
    public void testInputter() {

        Inputter inp = new Inputter();
        int case_1 = Inputter.getAnInteger("Enter int: ", "Integer required");
        int case_2 = Inputter.getAnInteger("Enter int (1-10): ", "Integer required between 1-10", 1, 10);
        double case_3 = Inputter.getADouble("Enter dobule: ", "Double required");
        double case_4 = Inputter.getADouble("Enter dobule (1-10): ", "Double required between 1-10", 1, 10);
        String case_5 = Inputter.getString("Enter hotel phone", "Hotel Phone required 10 digits", Regex.HOTEL_PHONE);
        String case_6 = Inputter.getString("Enter hotel phone", "Hotel Phone required 10 digits", Regex.HOTEL_PHONE);

        try {
            Assertions.assertEquals(5, case_1, "Test case 1 failed");
            Assertions.assertEquals(5, case_2, "Test case 2 failed");
            Assertions.assertEquals(5, case_3, "Test case 3 failed");
            Assertions.assertEquals(5, case_4, "Test case 4 failed");
            Assertions.assertEquals("0934162561", case_5, "Test case 5 failed");
            Assertions.assertEquals("0934", case_6, "Test case 6 failed");
        } finally {
//            Inputter.closeScanner();
        }

    }

}
