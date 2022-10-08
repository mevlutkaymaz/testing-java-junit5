package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {
    IndexController indexController;
    @BeforeEach
    void setUp() {
        indexController=new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "Wrong view returned");
    }

    @Test
    void throwException() {
        assertThrows(ValueNotFoundException.class, ()->{
            indexController.oupsHandler();
        });
    }

    @Test
    void testIndex() {
    }

    @Test
    void testOupsHandler() {
    }

    @Disabled("Demo timeout")
    @Test
    void timeoutTest() {
        assertTimeout(Duration.ofMillis(100),()->{
            Thread.sleep(5000);
            System.out.println("I got here");
        });
    }

    @Disabled("Demo timeout")
    @Test
    void timeoutTestPrompt() {
        assertTimeoutPreemptively(Duration.ofMillis(100),()->{
            Thread.sleep(5000);
            System.out.println("I got here2");
        });
    }
}