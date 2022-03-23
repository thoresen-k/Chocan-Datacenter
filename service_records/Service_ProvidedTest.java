package service_records;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Service_ProvidedTest {
    Service_Provided test = new Service_Provided(12345, "03/22/2021", "350-750",
            12345, 124564,"Better than before",
            "2:25 AM", "Providence", "Consultation","Mike");


    @Test
    void getProvider_ID() {
        assertEquals(12345, test.getTransaction_ID());
    }

    @Test
    void getDate_Of_Service() {
        assertEquals("03/22/2021", test.getDate_Of_Service());
    }

    @Test
    void getRecordedTime() {
        assertEquals("2:25 AM", test.getRecordedTime());
    }

    @Test
    void getProviderName() {
        assertEquals("Providence", test.getProviderName());
    }

    @Test
    void getServiceCode() {
        assertEquals(12345, test.getServiceCode());
    }

    @Test
    void getServiceName() {
        assertEquals("Consultation", test.getServiceName());
    }

    @Test
    void getMemberName() {
        assertEquals(12345, test.getTransaction_ID());
    }

    @Test
    void getMember_ID() {
        assertEquals(124564, test.getMember_ID());
    }

    @Test
    void getService_ID() {
        assertEquals(12345, test.getService_ID());
    }

    @Test
    void getComments() {
        assertEquals("Better than before", test.getComments());
    }

    @Test
    void getTransaction_ID() {
        assertEquals(12345, test.getTransaction_ID());
    }
}