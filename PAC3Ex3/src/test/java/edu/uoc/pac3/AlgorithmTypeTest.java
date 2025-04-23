package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AlgorithmTypeTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definitions")
    public void checkFieldsSanity() {
        assertEquals(8, AlgorithmType.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(AlgorithmType.class.getDeclaredField("description").getModifiers()));
            assertFalse(Modifier.isStatic(AlgorithmType.class.getDeclaredField("description").getModifiers()));
            assertTrue(Modifier.isFinal(AlgorithmType.class.getDeclaredField("description").getModifiers()));
            assertEquals(String.class, AlgorithmType.class.getDeclaredField("description").getType());

            assertTrue(Modifier.isPrivate(AlgorithmType.class.getDeclaredField("expectedPrecision").getModifiers()));
            assertFalse(Modifier.isStatic(AlgorithmType.class.getDeclaredField("expectedPrecision").getModifiers()));
            assertTrue(Modifier.isFinal(AlgorithmType.class.getDeclaredField("expectedPrecision").getModifiers()));
            assertEquals(double.class, AlgorithmType.class.getDeclaredField("expectedPrecision").getType());

            assertTrue(Modifier.isPrivate(AlgorithmType.class.getDeclaredField("expectedRecall").getModifiers()));
            assertFalse(Modifier.isStatic(AlgorithmType.class.getDeclaredField("expectedRecall").getModifiers()));
            assertTrue(Modifier.isFinal(AlgorithmType.class.getDeclaredField("expectedRecall").getModifiers()));
            assertEquals(double.class, AlgorithmType.class.getDeclaredField("expectedRecall").getType());

            assertTrue(Modifier.isPrivate(AlgorithmType.class.getDeclaredField("learningRate").getModifiers()));
            assertFalse(Modifier.isStatic(AlgorithmType.class.getDeclaredField("learningRate").getModifiers()));
            assertTrue(Modifier.isFinal(AlgorithmType.class.getDeclaredField("learningRate").getModifiers()));
            assertEquals(double.class, AlgorithmType.class.getDeclaredField("learningRate").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(1, AlgorithmType.class.getDeclaredConstructors().length);
        assertEquals(9, Arrays.stream(AlgorithmType.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(AlgorithmType.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isStatic(AlgorithmType.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isFinal(AlgorithmType.class.getDeclaredMethod("getDescription").getModifiers()));
            assertEquals(String.class, AlgorithmType.class.getDeclaredMethod("getDescription").getReturnType());

            assertTrue(Modifier.isPublic(AlgorithmType.class.getDeclaredMethod("getExpectedPrecision").getModifiers()));
            assertFalse(Modifier.isStatic(AlgorithmType.class.getDeclaredMethod("getExpectedPrecision").getModifiers()));
            assertFalse(Modifier.isFinal(AlgorithmType.class.getDeclaredMethod("getExpectedPrecision").getModifiers()));
            assertEquals(double.class, AlgorithmType.class.getDeclaredMethod("getExpectedPrecision").getReturnType());

            assertTrue(Modifier.isPublic(AlgorithmType.class.getDeclaredMethod("getExpectedRecall").getModifiers()));
            assertFalse(Modifier.isStatic(AlgorithmType.class.getDeclaredMethod("getExpectedRecall").getModifiers()));
            assertFalse(Modifier.isFinal(AlgorithmType.class.getDeclaredMethod("getExpectedRecall").getModifiers()));
            assertEquals(double.class, AlgorithmType.class.getDeclaredMethod("getExpectedRecall").getReturnType());

            assertTrue(Modifier.isPublic(AlgorithmType.class.getDeclaredMethod("getLearningRate").getModifiers()));
            assertFalse(Modifier.isStatic(AlgorithmType.class.getDeclaredMethod("getLearningRate").getModifiers()));
            assertFalse(Modifier.isFinal(AlgorithmType.class.getDeclaredMethod("getLearningRate").getModifiers()));
            assertEquals(double.class, AlgorithmType.class.getDeclaredMethod("getLearningRate").getReturnType());

            assertTrue(Modifier.isPublic(AlgorithmType.class.getDeclaredMethod("getExpectedF1Score").getModifiers()));
            assertFalse(Modifier.isStatic(AlgorithmType.class.getDeclaredMethod("getExpectedF1Score").getModifiers()));
            assertFalse(Modifier.isFinal(AlgorithmType.class.getDeclaredMethod("getExpectedF1Score").getModifiers()));
            assertEquals(double.class, AlgorithmType.class.getDeclaredMethod("getExpectedF1Score").getReturnType());

            assertTrue(Modifier.isPublic(AlgorithmType.class.getDeclaredMethod("getType", String.class).getModifiers()));
            assertTrue(Modifier.isStatic(AlgorithmType.class.getDeclaredMethod("getType", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(AlgorithmType.class.getDeclaredMethod("getType", String.class).getModifiers()));
            assertEquals(AlgorithmType.class, AlgorithmType.class.getDeclaredMethod("getType", String.class).getReturnType());

            assertTrue(Modifier.isPublic(AlgorithmType.class.getDeclaredMethod("getNextBetterLearningRate").getModifiers()));
            assertFalse(Modifier.isStatic(AlgorithmType.class.getDeclaredMethod("getNextBetterLearningRate").getModifiers()));
            assertFalse(Modifier.isFinal(AlgorithmType.class.getDeclaredMethod("getNextBetterLearningRate").getModifiers()));
            assertEquals(AlgorithmType.class, AlgorithmType.class.getDeclaredMethod("getNextBetterLearningRate").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Algorithm Type - testDescription")
    public void checkDescription() {
        assertEquals("Linear Regression", AlgorithmType.LINEAR_REGRESSION.getDescription());
        assertEquals("Q-Learning", AlgorithmType.Q_LEARNING.getDescription());
        assertEquals("Neural Network", AlgorithmType.NEURAL_NETWORK.getDescription());
    }

    @Test
    @Order(4)
    @DisplayName("Algorithm Type - testExpectedPrecision")
    public void checkExpectedPrecision() {
        assertEquals(0.75, AlgorithmType.LINEAR_REGRESSION.getExpectedPrecision());
        assertEquals(0.70, AlgorithmType.Q_LEARNING.getExpectedPrecision());
        assertEquals(0.92, AlgorithmType.NEURAL_NETWORK.getExpectedPrecision());
    }

    @Test
    @Order(5)
    @DisplayName("Algorithm Type - testExpectedRecall")
    public void checkExpectedRecall() {
        assertEquals(0.65, AlgorithmType.LINEAR_REGRESSION.getExpectedRecall());
        assertEquals(0.60, AlgorithmType.Q_LEARNING.getExpectedRecall());
        assertEquals(0.88, AlgorithmType.NEURAL_NETWORK.getExpectedRecall());
    }

    @Test
    @Order(6)
    @DisplayName("Algorithm Type - testLearningRate")
    public void checkLearningRate() {
        assertEquals(1.0, AlgorithmType.LINEAR_REGRESSION.getLearningRate());
        assertEquals(0.1, AlgorithmType.Q_LEARNING.getLearningRate());
        assertEquals(0.001, AlgorithmType.NEURAL_NETWORK.getLearningRate());
    }

    @Test
    @Order(7)
    @DisplayName("Algorithm Type - testExpectedF1Score")
    public void checkExpectedF1Score() {
        assertEquals(0.70, AlgorithmType.LINEAR_REGRESSION.getExpectedF1Score(), 0.01);
        assertEquals(0.64, AlgorithmType.Q_LEARNING.getExpectedF1Score(), 0.01);
        assertEquals(0.90, AlgorithmType.NEURAL_NETWORK.getExpectedF1Score(), 0.01);
    }

    @Test
    @Order(8)
    @DisplayName("Algorithm Type - testGetType")
    public void checkGetType() {
        assertEquals(AlgorithmType.LINEAR_REGRESSION, AlgorithmType.getType("Linear Regression"));
        assertEquals(AlgorithmType.Q_LEARNING, AlgorithmType.getType("Q-Learning"));
        assertEquals(AlgorithmType.NEURAL_NETWORK, AlgorithmType.getType("Neural Network"));
        assertNull(AlgorithmType.getType("Unknown Type"));
    }

    @Test
    @Order(9)
    @DisplayName("Algorithm Type - testGetNextBetterLearningRate")
    public void checkGetNextBetterLearningRate() {
        assertEquals(AlgorithmType.Q_LEARNING, AlgorithmType.LINEAR_REGRESSION.getNextBetterLearningRate());
        assertEquals(AlgorithmType.NEURAL_NETWORK, AlgorithmType.Q_LEARNING.getNextBetterLearningRate());
        assertEquals(AlgorithmType.NEURAL_NETWORK, AlgorithmType.NEURAL_NETWORK.getNextBetterLearningRate());
    }

}
