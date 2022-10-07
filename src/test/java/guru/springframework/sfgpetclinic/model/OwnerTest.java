package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions(){
        Owner owner=new Owner(1L, "Mevlut", "Kaymaz");
        owner.setCity("Spring");
        owner.setTelephone("123456789");

        assertAll("Properties Test",
                ()->{
                    assertAll("Person properties", ()->{
                        assertEquals("Mevlut", owner.getFirstName(), "firstname didnot match");
                        assertEquals("Kaymaz", owner.getLastName());
                    });
                },
                ()->{
                    assertAll("Owner properties", ()->{
                        assertEquals("Spring", owner.getCity(), "city didnot match");
                        assertEquals("123456789", owner.getTelephone());
                    });
                }
                );

    }

}