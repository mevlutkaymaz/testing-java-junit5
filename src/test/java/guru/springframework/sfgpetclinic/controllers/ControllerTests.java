package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@Tag("Controller")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ControllerTests {

    @BeforeAll
    default void beforeAll(){
        System.out.println("Before all");
    }
}
