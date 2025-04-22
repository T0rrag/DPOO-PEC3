package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComputeClusterTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsDefinition() {
        assertEquals(22, ComputeCluster.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredField("INVALID_MAX_MODELS").getModifiers()));
            assertTrue(Modifier.isStatic(ComputeCluster.class.getDeclaredField("INVALID_MAX_MODELS").getModifiers()));
            assertTrue(Modifier.isFinal(ComputeCluster.class.getDeclaredField("INVALID_MAX_MODELS").getModifiers()));
            assertEquals(String.class, ComputeCluster.class.getDeclaredField("INVALID_MAX_MODELS").getType());
            assertEquals("[ERROR] The maximum number of models has to be greater than 0", ComputeCluster.INVALID_MAX_MODELS);

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredField("MODEL_NULL").getModifiers()));
            assertTrue(Modifier.isStatic(ComputeCluster.class.getDeclaredField("MODEL_NULL").getModifiers()));
            assertTrue(Modifier.isFinal(ComputeCluster.class.getDeclaredField("MODEL_NULL").getModifiers()));
            assertEquals(String.class, ComputeCluster.class.getDeclaredField("MODEL_NULL").getType());
            assertEquals("[ERROR] The model cannot be null", ComputeCluster.MODEL_NULL);

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredField("MODEL_ALREADY_EXISTS").getModifiers()));
            assertTrue(Modifier.isStatic(ComputeCluster.class.getDeclaredField("MODEL_ALREADY_EXISTS").getModifiers()));
            assertTrue(Modifier.isFinal(ComputeCluster.class.getDeclaredField("MODEL_ALREADY_EXISTS").getModifiers()));
            assertEquals(String.class, ComputeCluster.class.getDeclaredField("MODEL_ALREADY_EXISTS").getType());
            assertEquals("[ERROR] The model already exists in the cluster", ComputeCluster.MODEL_ALREADY_EXISTS);

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredField("MODEL_NOT_FOUND").getModifiers()));
            assertTrue(Modifier.isStatic(ComputeCluster.class.getDeclaredField("MODEL_NOT_FOUND").getModifiers()));
            assertTrue(Modifier.isFinal(ComputeCluster.class.getDeclaredField("MODEL_NOT_FOUND").getModifiers()));
            assertEquals(String.class, ComputeCluster.class.getDeclaredField("MODEL_NOT_FOUND").getType());
            assertEquals("[ERROR] The model does not exist in the cluster", ComputeCluster.MODEL_NOT_FOUND);

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredField("CANNOT_ADD_MODEL").getModifiers()));
            assertTrue(Modifier.isStatic(ComputeCluster.class.getDeclaredField("CANNOT_ADD_MODEL").getModifiers()));
            assertTrue(Modifier.isFinal(ComputeCluster.class.getDeclaredField("CANNOT_ADD_MODEL").getModifiers()));
            assertEquals(String.class, ComputeCluster.class.getDeclaredField("CANNOT_ADD_MODEL").getType());
            assertEquals("[ERROR] The model cannot be added to the cluster because it is full", ComputeCluster.CANNOT_ADD_MODEL);

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredField("MAX_MODELS").getModifiers()));
            assertTrue(Modifier.isFinal(ComputeCluster.class.getDeclaredField("MAX_MODELS").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredField("MAX_MODELS").getModifiers()));
            assertEquals(int.class, ComputeCluster.class.getDeclaredField("MAX_MODELS").getType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredField("models").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredField("models").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredField("models").getModifiers()));
            assertEquals(Model[].class, ComputeCluster.class.getDeclaredField("models").getType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredField("numModels").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredField("numModels").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredField("numModels").getModifiers()));
            assertEquals(int.class, ComputeCluster.class.getDeclaredField("numModels").getType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        assertEquals(1, ComputeCluster.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredConstructor(String.class, int.class, int.class, double.class, LocalDate.class, boolean.class, int.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(12, Arrays.stream(ComputeCluster.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());
        assertEquals(8, Arrays.stream(ComputeCluster.class.getDeclaredMethods()).filter(m -> Modifier.isPrivate(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredMethod("getMaxModels").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("getMaxModels").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("getMaxModels").getModifiers()));
            assertEquals(int.class, ComputeCluster.class.getDeclaredMethod("getMaxModels").getReturnType());

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredMethod("getModels").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("getModels").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("getModels").getModifiers()));
            assertEquals(Model[].class, ComputeCluster.class.getDeclaredMethod("getModels").getReturnType());

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredMethod("getNumModels").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("getNumModels").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("getNumModels").getModifiers()));
            assertEquals(int.class, ComputeCluster.class.getDeclaredMethod("getNumModels").getReturnType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredMethod("findModel", Model.class).getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("findModel", Model.class).getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("findModel", Model.class).getModifiers()));
            assertEquals(int.class, ComputeCluster.class.getDeclaredMethod("findModel", Model.class).getReturnType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredMethod("containsModel", Model.class).getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("containsModel", Model.class).getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("containsModel", Model.class).getModifiers()));
            assertEquals(boolean.class, ComputeCluster.class.getDeclaredMethod("containsModel", Model.class).getReturnType());

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredMethod("addModel", Model.class).getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("addModel", Model.class).getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("addModel", Model.class).getModifiers()));
            assertEquals(void.class, ComputeCluster.class.getDeclaredMethod("addModel", Model.class).getReturnType());

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredMethod("removeModel", Model.class).getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("removeModel", Model.class).getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("removeModel", Model.class).getModifiers()));
            assertEquals(void.class, ComputeCluster.class.getDeclaredMethod("removeModel", Model.class).getReturnType());

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredMethod("getBestModel").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("getBestModel").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("getBestModel").getModifiers()));
            assertEquals(Model.class, ComputeCluster.class.getDeclaredMethod("getBestModel").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("advanced")
    @DisplayName("Advanced - Max models")
    public void testMaxModels() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true, -1));
        assertEquals("[ERROR] The maximum number of models has to be greater than 0", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true, 0));
        assertEquals("[ERROR] The maximum number of models has to be greater than 0", exception.getMessage());

        ComputeCluster cluster = new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true, 5);

        assertNotNull(cluster);
        assertEquals(5, cluster.getMaxModels());

        cluster = new ComputeCluster("cluster-2", 4, 1, 16.0, LocalDate.now().plusDays(1), true, 10);
        assertEquals(10, cluster.getMaxModels());
    }

    @Test
    @Order(5)
    @Tag("advanced")
    @DisplayName("Advanced - Add model")
    public void testAddModel() {
        ComputeCluster cluster = new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true, 5);

        Model model1 = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now(), LocalDate.now());
        Model model2 = new Model("DataAnalysis", "Tool to predict the quality of datasets", 1087, 40, 937, 22, LocalDate.now().minusMonths(2), LocalDate.now().minusDays(2));
        Model model3 = new Model("TextClassifier", "Tool to classify text documents", 9721, 38, 9741, 54, LocalDate.now(), LocalDate.now());
        Model model4 = new Model("ImageClassifier", "Tool to classify images", 7481, 44, 7600, 39, LocalDate.now(), LocalDate.now());
        Model model5 = new Model("VideoClassifier", "Tool to classify videos", 486, 11, 780, 21, LocalDate.now(), LocalDate.now());
        Model model6 = new Model("AudioClassifier", "Tool to classify audio files", 1234, 12, 5678, 34, LocalDate.now(), LocalDate.now());

        assertEquals(5, cluster.getMaxModels());
        assertEquals(0, cluster.getNumModels());

        Exception exception = assertThrows(NullPointerException.class, () -> cluster.addModel(null));
        assertEquals("[ERROR] The model cannot be null", exception.getMessage());
        assertEquals(0, cluster.getNumModels());

        cluster.addModel(model1);

        assertEquals(1, cluster.getNumModels());
        assertEquals(model1, cluster.getModels()[0]);
        for (int i = 1; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }

        exception = assertThrows(IllegalArgumentException.class, () -> cluster.addModel(model1));
        assertEquals("[ERROR] The model already exists in the cluster", exception.getMessage());
        assertEquals(1, cluster.getNumModels());
        assertEquals(model1, cluster.getModels()[0]);
        for (int i = 1; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }

        cluster.addModel(model2);
        assertEquals(2, cluster.getNumModels());
        assertEquals(model1, cluster.getModels()[0]);
        assertEquals(model2, cluster.getModels()[1]);
        for (int i = 2; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }

        cluster.addModel(model3);
        assertEquals(3, cluster.getNumModels());
        assertEquals(model1, cluster.getModels()[0]);
        assertEquals(model2, cluster.getModels()[1]);
        assertEquals(model3, cluster.getModels()[2]);
        for (int i = 3; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }

        cluster.addModel(model4);
        assertEquals(4, cluster.getNumModels());
        assertEquals(model1, cluster.getModels()[0]);
        assertEquals(model2, cluster.getModels()[1]);
        assertEquals(model3, cluster.getModels()[2]);
        assertEquals(model4, cluster.getModels()[3]);
        for (int i = 4; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }

        cluster.addModel(model5);
        assertEquals(5, cluster.getNumModels());
        assertEquals(model1, cluster.getModels()[0]);
        assertEquals(model2, cluster.getModels()[1]);
        assertEquals(model3, cluster.getModels()[2]);
        assertEquals(model4, cluster.getModels()[3]);
        assertEquals(model5, cluster.getModels()[4]);

        exception = assertThrows(IllegalArgumentException.class, () -> cluster.addModel(model6));
        assertEquals("[ERROR] The model cannot be added to the cluster because it is full", exception.getMessage());
        assertEquals(5, cluster.getNumModels());
        assertEquals(model1, cluster.getModels()[0]);
        assertEquals(model2, cluster.getModels()[1]);
        assertEquals(model3, cluster.getModels()[2]);
        assertEquals(model4, cluster.getModels()[3]);
        assertEquals(model5, cluster.getModels()[4]);
    }

    @Test
    @Order(6)
    @Tag("advanced")
    @DisplayName("Advanced - Remove model")
    public void testRemoveModel() {
        ComputeCluster cluster = new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true, 4);

        Model model1 = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now(), LocalDate.now());
        Model model2 = new Model("DataAnalysis", "Tool to predict the quality of datasets", 1087, 40, 937, 22, LocalDate.now().minusMonths(2), LocalDate.now().minusDays(2));
        Model model3 = new Model("TextClassifier", "Tool to classify text documents", 9721, 38, 9741, 54, LocalDate.now(), LocalDate.now());
        Model model4 = new Model("ImageClassifier", "Tool to classify images", 7481, 44, 7600, 39, LocalDate.now(), LocalDate.now());

        Exception exception = assertThrows(NullPointerException.class, () -> cluster.removeModel(null));
        assertEquals("[ERROR] The model cannot be null", exception.getMessage());
        assertEquals(0, cluster.getNumModels());
        assertEquals(4, cluster.getMaxModels());

        exception = assertThrows(IllegalArgumentException.class, () -> cluster.removeModel(model1));
        assertEquals("[ERROR] The model does not exist in the cluster", exception.getMessage());
        assertEquals(0, cluster.getNumModels());

        cluster.addModel(model1);
        assertEquals(1, cluster.getNumModels());
        assertEquals(model1, cluster.getModels()[0]);
        for (int i = 1; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }

        exception = assertThrows(IllegalArgumentException.class, () -> cluster.removeModel(model2));
        assertEquals("[ERROR] The model does not exist in the cluster", exception.getMessage());
        assertEquals(1, cluster.getNumModels());
        assertEquals(model1, cluster.getModels()[0]);
        for (int i = 1; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }

        cluster.removeModel(model1);
        assertEquals(0, cluster.getNumModels());
        assertEquals(4, cluster.getMaxModels());
        for (int i = 0; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }

        cluster.addModel(model2);
        assertEquals(1, cluster.getNumModels());
        assertEquals(model2, cluster.getModels()[0]);
        for (int i = 1; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }

        cluster.addModel(model1);
        assertEquals(2, cluster.getNumModels());
        assertEquals(model2, cluster.getModels()[0]);
        assertEquals(model1, cluster.getModels()[1]);
        for (int i = 2; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }

        cluster.addModel(model3);
        assertEquals(3, cluster.getNumModels());
        assertEquals(model2, cluster.getModels()[0]);
        assertEquals(model1, cluster.getModels()[1]);
        assertEquals(model3, cluster.getModels()[2]);
        for (int i = 3; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }

        cluster.removeModel(model1);
        assertEquals(2, cluster.getNumModels());
        assertEquals(model2, cluster.getModels()[0]);
        assertEquals(model3, cluster.getModels()[1]);
        for (int i = 2; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }

        cluster.addModel(model4);
        cluster.addModel(model1);
        assertEquals(4, cluster.getNumModels());
        assertEquals(model2, cluster.getModels()[0]);
        assertEquals(model3, cluster.getModels()[1]);
        assertEquals(model4, cluster.getModels()[2]);
        assertEquals(model1, cluster.getModels()[3]);

        cluster.removeModel(model2);
        assertEquals(3, cluster.getNumModels());
        assertEquals(model3, cluster.getModels()[0]);
        assertEquals(model4, cluster.getModels()[1]);
        assertEquals(model1, cluster.getModels()[2]);
        for (int i = 3; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }

        cluster.removeModel(model1);
        assertEquals(2, cluster.getNumModels());
        assertEquals(model3, cluster.getModels()[0]);
        assertEquals(model4, cluster.getModels()[1]);
        for (int i = 2; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }

        cluster.removeModel(model3);
        assertEquals(1, cluster.getNumModels());
        assertEquals(model4, cluster.getModels()[0]);
        for (int i = 1; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }

        cluster.removeModel(model4);
        assertEquals(0, cluster.getNumModels());
        assertEquals(4, cluster.getMaxModels());
        for (int i = 0; i < cluster.getMaxModels(); i++) {
            assertNull(cluster.getModels()[i]);
        }
    }

    @Test
    @Order(7)
    @Tag("advanced")
    @DisplayName("Advanced - Get best model")
    public void testGetBestModel() {
        ComputeCluster cluster = new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true, 6);

        Model model1 = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now(), LocalDate.now());
        Model model2 = new Model("DataAnalysis", "Tool to predict the quality of datasets", 1087, 40, 937, 22, LocalDate.now().minusMonths(2), LocalDate.now().minusDays(2));
        Model model3 = new Model("TextClassifier", "Tool to classify text documents", 9721, 38, 9741, 54, LocalDate.now(), LocalDate.now());
        Model model4 = new Model("ImageClassifier", "Tool to classify images", 7481, 44, 7600, 39, LocalDate.now(), LocalDate.now());
        Model model5 = new Model("VideoClassifier", "Tool to classify videos", 486, 11, 780, 21, LocalDate.now(), LocalDate.now());
        Model model6 = new Model("AudioClassifier", "Tool to classify audio files", 1234, 12, 5678, 34, LocalDate.now(), LocalDate.now());

        assertNull(cluster.getBestModel());

        cluster.addModel(model1);
        assertEquals(model1, cluster.getBestModel());

        cluster.addModel(model2);
        assertEquals(model2, cluster.getBestModel());

        cluster.addModel(model3);
        assertEquals(model3, cluster.getBestModel());

        cluster.addModel(model4);
        assertEquals(model3, cluster.getBestModel());

        cluster.addModel(model5);
        assertEquals(model3, cluster.getBestModel());

        cluster.addModel(model6);
        assertEquals(model3, cluster.getBestModel());

        cluster.removeModel(model3);
        assertEquals(model4, cluster.getBestModel());

        cluster.removeModel(model4);
        assertEquals(model6, cluster.getBestModel());

        cluster.removeModel(model6);
        assertEquals(model2, cluster.getBestModel());

        cluster.removeModel(model2);
        assertEquals(model5, cluster.getBestModel());

        cluster.removeModel(model5);
        assertEquals(model1, cluster.getBestModel());

        cluster.removeModel(model1);
        assertNull(cluster.getBestModel());
    }

}
