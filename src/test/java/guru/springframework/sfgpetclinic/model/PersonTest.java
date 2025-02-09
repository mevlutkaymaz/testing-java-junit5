package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTests {

    @Test
    void grouppedAssertions(){
        //given
        Person person=new Person(1L, "Mevlut", "Kaymaz");
        //then
        assertAll("Test prop set",
                ()->assertEquals("Mevlut", person.getFirstName()),
                ()->assertEquals("Kaymaz", person.getLastName())
        );
    }    @Test
    void grouppedAssertionsFailed(){
        //given
        Person person=new Person(1L, "Mevlut", "Kaymaz");
        //then
        assertAll("Test prop set",
                ()->assertEquals(person.getFirstName(), "Mevlut", "Firstname failed"),
                ()->assertEquals(person.getLastName(), "Kaymaz","Lastname failed")
        );
    }
}