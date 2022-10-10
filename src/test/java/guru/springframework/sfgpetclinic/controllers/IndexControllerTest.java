package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Tag("Controller")
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

        assertThat(indexController.index().equals("index"));
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

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testOnWindows() {
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testOnMac() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testJava11() {
    }
}