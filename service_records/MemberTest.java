package service_records;

import interfaces.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    Status status = new Status("Mike", "Active");
    Member test = new Member( "158900","Budei", "Mike","13852 SE Monet Ct", "2", "Clackamas", "OR" , 97089, status);


    @Test
    void getMemberID() {
        assertEquals("158900", test.getMemberID());
    }

    @Test
    void getLastName() {
        assertEquals("Budei", test.getLastName());
    }

    @Test
    void getFirstName() {
        assertEquals("Mike", test.getFirstName());
    }

    @Test
    void getAddress() {
        assertEquals("13852 SE Monet Ct", test.getAddress());
    }

    @Test
    void getAptNumber() {

        assertEquals("2", test.getAptNumber());
    }

    @Test
    void getCity() {
        assertEquals("Clackamas", test.getCity());
    }

    @Test
    void getState() {
        assertEquals("OR", test.getState());
    }

    @Test
    void getZip() {
        assertEquals(97089, test.getZip());
    }

    @Test
    void getMembershipStatus() {
        assertEquals("Active", test.getMembershipStatus());
    }
}