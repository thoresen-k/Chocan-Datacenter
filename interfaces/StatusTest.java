package interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusTest {
    Status test = new Status("Mike", "Active");
    @Test
    void getName() {
        assertEquals("Mike", test.getName());
    }

    @Test
    void getMembership_status() {
        assertEquals("Active", test.getMembership_status());
    }

    @Test
    void setStatus() {
        test.setStatus("1234","Inactive");
        assertEquals("Inactive", test.getMembership_status());
    }
}