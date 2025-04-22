package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ModelTest {

    @BeforeEach
    public void resetNextId() throws Exception {
        java.lang.reflect.Field field = Model.class.getDeclaredField("nextId");
        field.setAccessible(true);
        field.setInt(null, 1);
    }

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(19, Model.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(Model.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(Model.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(Model.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertEquals(String.class, Model.class.getDeclaredField("INVALID_NAME").getType());
            assertEquals("[ERROR] The name cannot be null, empty or have less than 3 characters", Model.INVALID_NAME);

            assertTrue(Modifier.isPublic(Model.class.getDeclaredField("INVALID_DESCRIPTION").getModifiers()));
            assertTrue(Modifier.isStatic(Model.class.getDeclaredField("INVALID_DESCRIPTION").getModifiers()));
            assertTrue(Modifier.isFinal(Model.class.getDeclaredField("INVALID_DESCRIPTION").getModifiers()));
            assertEquals(String.class, Model.class.getDeclaredField("INVALID_DESCRIPTION").getType());
            assertEquals("[ERROR] The description cannot be null", Model.INVALID_DESCRIPTION);

            assertTrue(Modifier.isPublic(Model.class.getDeclaredField("INVALID_TP").getModifiers()));
            assertTrue(Modifier.isStatic(Model.class.getDeclaredField("INVALID_TP").getModifiers()));
            assertTrue(Modifier.isFinal(Model.class.getDeclaredField("INVALID_TP").getModifiers()));
            assertEquals(String.class, Model.class.getDeclaredField("INVALID_TP").getType());
            assertEquals("[ERROR] The number of true positives cannot be negative", Model.INVALID_TP);

            assertTrue(Modifier.isPublic(Model.class.getDeclaredField("INVALID_FP").getModifiers()));
            assertTrue(Modifier.isStatic(Model.class.getDeclaredField("INVALID_FP").getModifiers()));
            assertTrue(Modifier.isFinal(Model.class.getDeclaredField("INVALID_FP").getModifiers()));
            assertEquals(String.class, Model.class.getDeclaredField("INVALID_FP").getType());
            assertEquals("[ERROR] The number of false positives cannot be negative", Model.INVALID_FP);

            assertTrue(Modifier.isPublic(Model.class.getDeclaredField("INVALID_TN").getModifiers()));
            assertTrue(Modifier.isStatic(Model.class.getDeclaredField("INVALID_TN").getModifiers()));
            assertTrue(Modifier.isFinal(Model.class.getDeclaredField("INVALID_TN").getModifiers()));
            assertEquals(String.class, Model.class.getDeclaredField("INVALID_TN").getType());
            assertEquals("[ERROR] The number of true negatives cannot be negative", Model.INVALID_TN);

            assertTrue(Modifier.isPublic(Model.class.getDeclaredField("INVALID_FN").getModifiers()));
            assertTrue(Modifier.isStatic(Model.class.getDeclaredField("INVALID_FN").getModifiers()));
            assertTrue(Modifier.isFinal(Model.class.getDeclaredField("INVALID_FN").getModifiers()));
            assertEquals(String.class, Model.class.getDeclaredField("INVALID_FN").getType());
            assertEquals("[ERROR] The number of false negatives cannot be negative", Model.INVALID_FN);

            assertTrue(Modifier.isPublic(Model.class.getDeclaredField("INVALID_FIRST_TRAINING_DATE").getModifiers()));
            assertTrue(Modifier.isStatic(Model.class.getDeclaredField("INVALID_FIRST_TRAINING_DATE").getModifiers()));
            assertTrue(Modifier.isFinal(Model.class.getDeclaredField("INVALID_FIRST_TRAINING_DATE").getModifiers()));
            assertEquals(String.class, Model.class.getDeclaredField("INVALID_FIRST_TRAINING_DATE").getType());
            assertEquals("[ERROR] The first training date cannot be null or in the future", Model.INVALID_FIRST_TRAINING_DATE);

            assertTrue(Modifier.isPublic(Model.class.getDeclaredField("INVALID_LAST_TRAINING_DATE").getModifiers()));
            assertTrue(Modifier.isStatic(Model.class.getDeclaredField("INVALID_LAST_TRAINING_DATE").getModifiers()));
            assertTrue(Modifier.isFinal(Model.class.getDeclaredField("INVALID_LAST_TRAINING_DATE").getModifiers()));
            assertEquals(String.class, Model.class.getDeclaredField("INVALID_LAST_TRAINING_DATE").getType());
            assertEquals("[ERROR] The last training date cannot be null, in the future or before the first training date", Model.INVALID_LAST_TRAINING_DATE);

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(Model.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(Model.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertEquals(int.class, Model.class.getDeclaredField("MIN_NAME_LENGTH").getType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredField("nextId").getModifiers()));
            assertTrue(Modifier.isStatic(Model.class.getDeclaredField("nextId").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredField("nextId").getModifiers()));
            assertEquals(int.class, Model.class.getDeclaredField("nextId").getType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredField("id").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredField("id").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredField("id").getModifiers()));
            assertEquals(int.class, Model.class.getDeclaredField("id").getType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, Model.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredField("description").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredField("description").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredField("description").getModifiers()));
            assertEquals(String.class, Model.class.getDeclaredField("description").getType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredField("tp").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredField("tp").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredField("tp").getModifiers()));
            assertEquals(int.class, Model.class.getDeclaredField("tp").getType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredField("fp").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredField("fp").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredField("fp").getModifiers()));
            assertEquals(int.class, Model.class.getDeclaredField("fp").getType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredField("tn").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredField("tn").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredField("tn").getModifiers()));
            assertEquals(int.class, Model.class.getDeclaredField("tn").getType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredField("fn").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredField("fn").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredField("fn").getModifiers()));
            assertEquals(int.class, Model.class.getDeclaredField("fn").getType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredField("firstTrainingDate").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredField("firstTrainingDate").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredField("firstTrainingDate").getModifiers()));
            assertEquals(LocalDate.class, Model.class.getDeclaredField("firstTrainingDate").getType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredField("lastTrainingDate").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredField("lastTrainingDate").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredField("lastTrainingDate").getModifiers()));
            assertEquals(LocalDate.class, Model.class.getDeclaredField("lastTrainingDate").getType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        assertEquals(1, Model.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Model.class.getDeclaredConstructor(String.class, String.class, int.class, int.class, int.class, int.class, LocalDate.class, LocalDate.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(13, Arrays.stream(Model.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());
        assertEquals(10, Arrays.stream(Model.class.getDeclaredMethods()).filter(m -> Modifier.isPrivate(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(Model.class.getDeclaredMethod("getId").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("getId").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("getId").getModifiers()));
            assertEquals(int.class, Model.class.getDeclaredMethod("getId").getReturnType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredMethod("setId").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("setId").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("setId").getModifiers()));
            assertEquals(void.class, Model.class.getDeclaredMethod("setId").getReturnType());

            assertTrue(Modifier.isPublic(Model.class.getDeclaredMethod("getNextId").getModifiers()));
            assertTrue(Modifier.isStatic(Model.class.getDeclaredMethod("getNextId").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("getNextId").getModifiers()));
            assertEquals(int.class, Model.class.getDeclaredMethod("getNextId").getReturnType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredMethod("incNextId").getModifiers()));
            assertTrue(Modifier.isStatic(Model.class.getDeclaredMethod("incNextId").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("incNextId").getModifiers()));
            assertEquals(void.class, Model.class.getDeclaredMethod("incNextId").getReturnType());

            assertTrue(Modifier.isPublic(Model.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, Model.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, Model.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Model.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("getDescription").getModifiers()));
            assertEquals(String.class, Model.class.getDeclaredMethod("getDescription").getReturnType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredMethod("setDescription", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("setDescription", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("setDescription", String.class).getModifiers()));
            assertEquals(void.class, Model.class.getDeclaredMethod("setDescription", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Model.class.getDeclaredMethod("getTp").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("getTp").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("getTp").getModifiers()));
            assertEquals(int.class, Model.class.getDeclaredMethod("getTp").getReturnType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredMethod("setTp", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("setTp", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("setTp", int.class).getModifiers()));
            assertEquals(void.class, Model.class.getDeclaredMethod("setTp", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Model.class.getDeclaredMethod("getFp").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("getFp").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("getFp").getModifiers()));
            assertEquals(int.class, Model.class.getDeclaredMethod("getFp").getReturnType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredMethod("setFp", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("setFp", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("setFp", int.class).getModifiers()));
            assertEquals(void.class, Model.class.getDeclaredMethod("setFp", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Model.class.getDeclaredMethod("getTn").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("getTn").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("getTn").getModifiers()));
            assertEquals(int.class, Model.class.getDeclaredMethod("getTn").getReturnType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredMethod("setTn", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("setTn", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("setTn", int.class).getModifiers()));
            assertEquals(void.class, Model.class.getDeclaredMethod("setTn", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Model.class.getDeclaredMethod("getFn").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("getFn").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("getFn").getModifiers()));
            assertEquals(int.class, Model.class.getDeclaredMethod("getFn").getReturnType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredMethod("setFn", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("setFn", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("setFn", int.class).getModifiers()));
            assertEquals(void.class, Model.class.getDeclaredMethod("setFn", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Model.class.getDeclaredMethod("getFirstTrainingDate").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("getFirstTrainingDate").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("getFirstTrainingDate").getModifiers()));
            assertEquals(LocalDate.class, Model.class.getDeclaredMethod("getFirstTrainingDate").getReturnType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredMethod("setFirstTrainingDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("setFirstTrainingDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("setFirstTrainingDate", LocalDate.class).getModifiers()));
            assertEquals(void.class, Model.class.getDeclaredMethod("setFirstTrainingDate", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(Model.class.getDeclaredMethod("getLastTrainingDate").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("getLastTrainingDate").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("getLastTrainingDate").getModifiers()));
            assertEquals(LocalDate.class, Model.class.getDeclaredMethod("getLastTrainingDate").getReturnType());

            assertTrue(Modifier.isPrivate(Model.class.getDeclaredMethod("setLastTrainingDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("setLastTrainingDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("setLastTrainingDate", LocalDate.class).getModifiers()));
            assertEquals(void.class, Model.class.getDeclaredMethod("setLastTrainingDate", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(Model.class.getDeclaredMethod("getPrecision").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("getPrecision").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("getPrecision").getModifiers()));
            assertEquals(double.class, Model.class.getDeclaredMethod("getPrecision").getReturnType());

            assertTrue(Modifier.isPublic(Model.class.getDeclaredMethod("getRecall").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("getRecall").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("getRecall").getModifiers()));
            assertEquals(double.class, Model.class.getDeclaredMethod("getRecall").getReturnType());

            assertTrue(Modifier.isPublic(Model.class.getDeclaredMethod("getF1Score").getModifiers()));
            assertFalse(Modifier.isStatic(Model.class.getDeclaredMethod("getF1Score").getModifiers()));
            assertFalse(Modifier.isFinal(Model.class.getDeclaredMethod("getF1Score").getModifiers()));
            assertEquals(double.class, Model.class.getDeclaredMethod("getF1Score").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testCreateModel() {
        Model model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());

        assertEquals(1, model.getId());
        assertEquals("UOC plagiarism detector", model.getName());
        assertEquals("Tool to detect plagiarized activities.", model.getDescription());
        assertEquals(55, model.getTp());
        assertEquals(8, model.getFp());
        assertEquals(10874, model.getTn());
        assertEquals(15, model.getFn());
        assertEquals(LocalDate.now().minusDays(10), model.getFirstTrainingDate());
        assertEquals(LocalDate.now(), model.getLastTrainingDate());
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Id")
    public void testCreateModelId() {
        Model model1 = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        Model model2 = new Model("DataAnalysis", "Tool to predict the quality of datasets", 1087, 40, 937, 22, LocalDate.now().minusMonths(2), LocalDate.now().minusDays(2));
        Model model3 = new Model("TextClassifier", "Tool to classify text documents", 9721, 38, 9741, 54, LocalDate.now(), LocalDate.now());

        assertEquals(1, model1.getId());
        assertEquals(2, model2.getId());
        assertEquals(3, model3.getId());
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - Name")
    public void testCreateModelName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Model(null, "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now()));
        assertEquals(Model.INVALID_NAME, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Model("", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now()));
        assertEquals(Model.INVALID_NAME, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Model("  ", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now()));
        assertEquals(Model.INVALID_NAME, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Model("A", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now()));
        assertEquals(Model.INVALID_NAME, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Model("AA", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now()));
        assertEquals(Model.INVALID_NAME, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Model(" AA ", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now()));
        assertEquals(Model.INVALID_NAME, exception.getMessage());

        Model model = new Model("AAA", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals("AAA", model.getName());

        model = new Model(" AAA ", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals("AAA", model.getName());

        model = new Model("   aaaa   ", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals("aaaa", model.getName());
    }

    @Test
    @Order(7)
    @Tag("minimum")
    @DisplayName("Minimum - Description")
    public void testCreateModelDescription() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Model("UOC plagiarism detector", null, 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now()));
        assertEquals(Model.INVALID_DESCRIPTION, exception.getMessage());

        Model model = new Model("UOC plagiarism detector", "", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals("", model.getDescription());

        model = new Model("UOC plagiarism detector", " ", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals("", model.getDescription());

        model = new Model("UOC plagiarism detector", "    ", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals("", model.getDescription());

        model = new Model("UOC plagiarism detector", "   Tool to detect plagiarized activities.    ", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals("Tool to detect plagiarized activities.", model.getDescription());

        model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals("Tool to detect plagiarized activities.", model.getDescription());
    }

    @Test
    @Order(8)
    @Tag("minimum")
    @DisplayName("Minimum - TP")
    public void testCreateModelTP() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", -1, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now()));
        assertEquals(Model.INVALID_TP, exception.getMessage());

        Model model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 0, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals(0, model.getTp());

        model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals(55, model.getTp());
    }

    @Test
    @Order(9)
    @Tag("minimum")
    @DisplayName("Minimum - FP")
    public void testCreateModelFP() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, -1, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now()));
        assertEquals(Model.INVALID_FP, exception.getMessage());

        Model model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 0, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals(0, model.getFp());

        model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals(8, model.getFp());
    }

    @Test
    @Order(10)
    @Tag("minimum")
    @DisplayName("Minimum - TN")
    public void testCreateModelTN() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, -1, 15, LocalDate.now().minusDays(10), LocalDate.now()));
        assertEquals(Model.INVALID_TN, exception.getMessage());

        Model model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 0, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals(0, model.getTn());

        model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals(10874, model.getTn());
    }

    @Test
    @Order(11)
    @Tag("minimum")
    @DisplayName("Minimum - FN")
    public void testCreateModelFN() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, -1, LocalDate.now().minusDays(10), LocalDate.now()));
        assertEquals(Model.INVALID_FN, exception.getMessage());

        Model model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 0, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals(0, model.getFn());

        model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals(15, model.getFn());
    }

    @Test
    @Order(12)
    @Tag("minimum")
    @DisplayName("Minimum - First Training Date")
    public void testCreateModelFirstTrainingDate() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, null, LocalDate.now()));
        assertEquals(Model.INVALID_FIRST_TRAINING_DATE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().plusDays(1), LocalDate.now()));
        assertEquals(Model.INVALID_FIRST_TRAINING_DATE, exception.getMessage());

        Model model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now(), LocalDate.now());
        assertEquals(LocalDate.now(), model.getFirstTrainingDate());

        model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals(LocalDate.now().minusDays(10), model.getFirstTrainingDate());
    }

    @Test
    @Order(13)
    @Tag("minimum")
    @DisplayName("Minimum - Last Training Date")
    public void testCreateModelLastTrainingDate() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), null));
        assertEquals(Model.INVALID_LAST_TRAINING_DATE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now().plusDays(1)));
        assertEquals(Model.INVALID_LAST_TRAINING_DATE, exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now().minusDays(11)));
        assertEquals(Model.INVALID_LAST_TRAINING_DATE, exception.getMessage());

        Model model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now());
        assertEquals(LocalDate.now(), model.getLastTrainingDate());

        model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now().minusDays(1));
        assertEquals(LocalDate.now().minusDays(1), model.getLastTrainingDate());

        model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now().minusDays(10), LocalDate.now().minusDays(10));
        assertEquals(LocalDate.now().minusDays(10), model.getLastTrainingDate());

        model = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 55, 8, 10874, 15, LocalDate.now(), LocalDate.now());
        assertEquals(LocalDate.now(), model.getLastTrainingDate());
    }

    @Test
    @Order(14)
    @Tag("minimum")
    @DisplayName("Minimum - Precision")
    public void testGetPrecision() {
        Model model1 = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 0, 0, 10, 0, LocalDate.now().minusDays(1), LocalDate.now());
        assertEquals(0.0, model1.getPrecision(), 0.0001);

        Model model2 = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 5, 0, 10, 2, LocalDate.now().minusDays(1), LocalDate.now());
        assertEquals(1.0, model2.getPrecision(), 0.0001);

        Model model3 = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 3, 2, 10, 4, LocalDate.now().minusDays(1), LocalDate.now());
        assertEquals(0.6, model3.getPrecision(), 0.0001);
    }

    @Test
    @Order(15)
    @Tag("minimum")
    @DisplayName("Minimum - Recall")
    public void testGetRecall() {
        Model model1 = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 0, 0, 10, 0, LocalDate.now().minusDays(1), LocalDate.now());
        assertEquals(0.0, model1.getRecall(), 0.0001);

        Model model2 = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 5, 0, 10, 2, LocalDate.now().minusDays(1), LocalDate.now());
        assertEquals(0.7143, model2.getRecall(), 0.0001);

        Model model3 = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 3, 2, 10, 4, LocalDate.now().minusDays(1), LocalDate.now());
        assertEquals(0.4286, model3.getRecall(), 0.0001);
    }

    @Test
    @Order(16)
    @Tag("minimum")
    @DisplayName("Minimum - F1 Score")
    public void testGetF1Score() {
        Model model1 = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 0, 0, 10, 0, LocalDate.now().minusDays(1), LocalDate.now());
        assertEquals(0.0, model1.getF1Score(), 0.0001);

        Model model2 = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 5, 0, 10, 2, LocalDate.now().minusDays(1), LocalDate.now());
        assertEquals(0.8333, model2.getF1Score(), 0.0001);

        Model model3 = new Model("UOC plagiarism detector", "Tool to detect plagiarized activities.", 3, 2, 10, 4, LocalDate.now().minusDays(1), LocalDate.now());
        assertEquals(0.5, model3.getF1Score(), 0.0001);
    }

}
