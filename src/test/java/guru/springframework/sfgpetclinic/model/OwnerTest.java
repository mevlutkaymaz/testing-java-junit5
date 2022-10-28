package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests{

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
        assertThat(owner.getCity(), is("Spring"));
    }

    @DisplayName("Value source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Enum source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName("Enum source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 2",
            "TX, 3, 3"
    })
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName+"-"+val1+"-"+val2);
    }

    @DisplayName("Enum source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/file.csv", numLinesToSkip = 1)
    void csvInputFileSourceTest(String stateName, int val1, int val2) {
        System.out.println(stateName+"-"+val1+"-"+val2);
    }

    @DisplayName("Enum source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void fromMethodTest(String stateName, int val1, int val2) {
        System.out.println(stateName+"-"+val1+"-"+val2);
    }

    static Stream<Arguments> getArgs(){
        return Stream.of(
                Arguments.of("FL", 1, 1),
                Arguments.of("OH", 2, 2),
                Arguments.of("TX", 3, 3)
        );
    }

    @DisplayName("Enum source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void customProviderTest(String stateName, int val1, int val2) {
        System.out.println(stateName+"-"+val1+"-"+val2);
    }
}