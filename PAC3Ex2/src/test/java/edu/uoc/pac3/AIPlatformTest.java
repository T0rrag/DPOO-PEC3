package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AIPlatformTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        assertEquals(2, AIPlatform.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(AIPlatform.class.getDeclaredConstructor(String.class, String.class, String.class, LocalDate.class, int.class).getModifiers()));
            assertTrue(Modifier.isPublic(AIPlatform.class.getDeclaredConstructor(String.class, String.class, String.class, LocalDate.class, int.class, String.class, int.class, int.class, double.class, LocalDate.class, boolean.class, int.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Method definition")
    public void checkMethodsSanity() {
        assertEquals(6, Arrays.stream(AIPlatform.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());
        assertEquals(6, Arrays.stream(AIPlatform.class.getDeclaredMethods()).filter(m -> Modifier.isPrivate(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPrivate(AIPlatform.class.getDeclaredMethod("setCluster", String.class, int.class, int.class, double.class, LocalDate.class, boolean.class, int.class).getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredMethod("setCluster", String.class, int.class, int.class, double.class, LocalDate.class, boolean.class, int.class).getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredMethod("setCluster", String.class, int.class, int.class, double.class, LocalDate.class, boolean.class, int.class).getModifiers()));
            assertEquals(void.class, AIPlatform.class.getDeclaredMethod("setCluster", String.class, int.class, int.class, double.class, LocalDate.class, boolean.class, int.class).getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

}
