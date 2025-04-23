package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ModelTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definitions")
    public void checkFieldsDefinition() {
        assertEquals(21, Model.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(Model.class.getDeclaredField("INVALID_ALGORITHM_TYPE").getModifiers()));
            assertTrue(Modifier.isStatic(Model.class.getDeclaredField("INVALID_ALGORITHM_TYPE").getModifiers()));
            assertTrue(Modifier.isFinal(Model.class.getDeclaredField("INVALID_ALGORITHM_TYPE").getModifiers()));
            assertEquals(String.class, Model.class.getDeclaredField("INVALID_ALGORITHM_TYPE").getType());
            assertEquals("[ERROR] The algorithm type cannot be null", Model.INVALID_ALGORITHM_TYPE);

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredField("algorithmType").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredField("algorithmType").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredField("algorithmType").getModifiers()));
            assertEquals(AlgorithmType.class, Model.class.getDeclaredField("algorithmType").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        assertEquals(1, Model.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Model.class.getDeclaredConstructor(String.class, String.class, int.class, int.class, int.class, int.class, LocalDate.class, LocalDate.class, AlgorithmType.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(14, Arrays.stream(Model.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());
        assertEquals(11, Arrays.stream(Model.class.getDeclaredMethods()).filter(m -> Modifier.isPrivate(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(Model.class.getDeclaredMethod("getAlgorithmType").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("getAlgorithmType").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("getAlgorithmType").getModifiers()));
            assertEquals(AlgorithmType.class, Model.class.getDeclaredMethod("getAlgorithmType").getReturnType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredMethod("setAlgorithmType", AlgorithmType.class).getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("setAlgorithmType", AlgorithmType.class).getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("setAlgorithmType", AlgorithmType.class).getModifiers()));
            assertEquals(void.class, Model.class.getDeclaredMethod("setAlgorithmType", AlgorithmType.class).getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Model - testAlgorithmType")
    public void checkAlgorithmType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Model("Test Model", "Test Description", 10, 2, 5, 1, LocalDate.now(), LocalDate.now(), null);
        });
        assertEquals("[ERROR] The algorithm type cannot be null", exception.getMessage());

        Model model = new Model("Test Model", "Test Description", 10, 2, 5, 1, LocalDate.now(), LocalDate.now(), AlgorithmType.LINEAR_REGRESSION);
        assertEquals(AlgorithmType.LINEAR_REGRESSION, model.getAlgorithmType());

        model = new Model("Test Model", "Test Description", 10, 2, 5, 1, LocalDate.now(), LocalDate.now(), AlgorithmType.Q_LEARNING);
        assertEquals(AlgorithmType.Q_LEARNING, model.getAlgorithmType());

        model = new Model("Test Model", "Test Description", 10, 2, 5, 1, LocalDate.now(), LocalDate.now(), AlgorithmType.NEURAL_NETWORK);
        assertEquals(AlgorithmType.NEURAL_NETWORK, model.getAlgorithmType());
    }

}
