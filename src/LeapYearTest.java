import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearTest {

    @Test
    void checkLeapYear() {
        assertEquals(false, LeapYear.checkLeapYear(1700));

    }

    @Test
    void testLeapYear() {
        assertEquals(true, LeapYear.isLeapYear(2020));

    }

}