package service_records;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Service_DirectoryTest {
    Service_Directory test = new Service_Directory(15578,"Pep-talk", 150);
    @Test
    void getServiceID() {
        assertEquals(15578, test.getServiceID());
    }

    @Test
    void getServiceName() {
        assertEquals("Pep-talk", test.getServiceName());
    }

    @Test
    void getServiceFee() {
        assertEquals(150, test.getServiceFee());
    }
}