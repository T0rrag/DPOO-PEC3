package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComputeClusterTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(14, ComputeCluster.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(ComputeCluster.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(ComputeCluster.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertEquals(String.class, ComputeCluster.class.getDeclaredField("INVALID_NAME").getType());
            assertEquals("[ERROR] The name cannot be null and has to start with 'cluster-' followed by a number", ComputeCluster.INVALID_NAME);

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredField("INVALID_NUM_NODES").getModifiers()));
            assertTrue(Modifier.isStatic(ComputeCluster.class.getDeclaredField("INVALID_NUM_NODES").getModifiers()));
            assertTrue(Modifier.isFinal(ComputeCluster.class.getDeclaredField("INVALID_NUM_NODES").getModifiers()));
            assertEquals(String.class, ComputeCluster.class.getDeclaredField("INVALID_NUM_NODES").getType());
            assertEquals("[ERROR] The number of nodes has to be greater or equal to 4", ComputeCluster.INVALID_NUM_NODES);

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredField("INVALID_NUM_GPUS").getModifiers()));
            assertTrue(Modifier.isStatic(ComputeCluster.class.getDeclaredField("INVALID_NUM_GPUS").getModifiers()));
            assertTrue(Modifier.isFinal(ComputeCluster.class.getDeclaredField("INVALID_NUM_GPUS").getModifiers()));
            assertEquals(String.class, ComputeCluster.class.getDeclaredField("INVALID_NUM_GPUS").getType());
            assertEquals("[ERROR] The number of GPUs cannot be negative or zero", ComputeCluster.INVALID_NUM_GPUS);

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredField("INVALID_RAM_CAPACITY").getModifiers()));
            assertTrue(Modifier.isStatic(ComputeCluster.class.getDeclaredField("INVALID_RAM_CAPACITY").getModifiers()));
            assertTrue(Modifier.isFinal(ComputeCluster.class.getDeclaredField("INVALID_RAM_CAPACITY").getModifiers()));
            assertEquals(String.class, ComputeCluster.class.getDeclaredField("INVALID_RAM_CAPACITY").getType());
            assertEquals("[ERROR] The RAM capacity has to be greater or equal to 16 GB", ComputeCluster.INVALID_RAM_CAPACITY);

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredField("INVALID_MAINTENANCE_DATE").getModifiers()));
            assertTrue(Modifier.isStatic(ComputeCluster.class.getDeclaredField("INVALID_MAINTENANCE_DATE").getModifiers()));
            assertTrue(Modifier.isFinal(ComputeCluster.class.getDeclaredField("INVALID_MAINTENANCE_DATE").getModifiers()));
            assertEquals(String.class, ComputeCluster.class.getDeclaredField("INVALID_MAINTENANCE_DATE").getType());
            assertEquals("[ERROR] The next maintenance date cannot be null or in the past", ComputeCluster.INVALID_MAINTENANCE_DATE);

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredField("MIN_NUM_NODES").getModifiers()));
            assertTrue(Modifier.isStatic(ComputeCluster.class.getDeclaredField("MIN_NUM_NODES").getModifiers()));
            assertTrue(Modifier.isFinal(ComputeCluster.class.getDeclaredField("MIN_NUM_NODES").getModifiers()));
            assertEquals(int.class, ComputeCluster.class.getDeclaredField("MIN_NUM_NODES").getType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredField("MIN_NUM_GPUS").getModifiers()));
            assertTrue(Modifier.isStatic(ComputeCluster.class.getDeclaredField("MIN_NUM_GPUS").getModifiers()));
            assertTrue(Modifier.isFinal(ComputeCluster.class.getDeclaredField("MIN_NUM_GPUS").getModifiers()));
            assertEquals(int.class, ComputeCluster.class.getDeclaredField("MIN_NUM_GPUS").getType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredField("MIN_RAM_CAPACITY").getModifiers()));
            assertTrue(Modifier.isStatic(ComputeCluster.class.getDeclaredField("MIN_RAM_CAPACITY").getModifiers()));
            assertTrue(Modifier.isFinal(ComputeCluster.class.getDeclaredField("MIN_RAM_CAPACITY").getModifiers()));
            assertEquals(double.class, ComputeCluster.class.getDeclaredField("MIN_RAM_CAPACITY").getType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, ComputeCluster.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredField("numNodes").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredField("numNodes").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredField("numNodes").getModifiers()));
            assertEquals(int.class, ComputeCluster.class.getDeclaredField("numNodes").getType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredField("numGPUs").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredField("numGPUs").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredField("numGPUs").getModifiers()));
            assertEquals(int.class, ComputeCluster.class.getDeclaredField("numGPUs").getType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredField("ramCapacity").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredField("ramCapacity").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredField("ramCapacity").getModifiers()));
            assertEquals(double.class, ComputeCluster.class.getDeclaredField("ramCapacity").getType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredField("nextMaintenanceDate").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredField("nextMaintenanceDate").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredField("nextMaintenanceDate").getModifiers()));
            assertEquals(LocalDate.class, ComputeCluster.class.getDeclaredField("nextMaintenanceDate").getType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredField("isGPUEnabled").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredField("isGPUEnabled").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredField("isGPUEnabled").getModifiers()));
            assertEquals(boolean.class, ComputeCluster.class.getDeclaredField("isGPUEnabled").getType());
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
            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredConstructor(String.class, int.class, int.class, double.class, LocalDate.class, boolean.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(6, Arrays.stream(ComputeCluster.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());
        assertEquals(6, Arrays.stream(ComputeCluster.class.getDeclaredMethods()).filter(m -> Modifier.isPrivate(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, ComputeCluster.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, ComputeCluster.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredMethod("getNumNodes").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("getNumNodes").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("getNumNodes").getModifiers()));
            assertEquals(int.class, ComputeCluster.class.getDeclaredMethod("getNumNodes").getReturnType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredMethod("setNumNodes", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("setNumNodes", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("setNumNodes", int.class).getModifiers()));
            assertEquals(void.class, ComputeCluster.class.getDeclaredMethod("setNumNodes", int.class).getReturnType());

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredMethod("getNumGPUs").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("getNumGPUs").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("getNumGPUs").getModifiers()));
            assertEquals(int.class, ComputeCluster.class.getDeclaredMethod("getNumGPUs").getReturnType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredMethod("setNumGPUs", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("setNumGPUs", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("setNumGPUs", int.class).getModifiers()));
            assertEquals(void.class, ComputeCluster.class.getDeclaredMethod("setNumGPUs", int.class).getReturnType());

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredMethod("getRamCapacity").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("getRamCapacity").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("getRamCapacity").getModifiers()));
            assertEquals(double.class, ComputeCluster.class.getDeclaredMethod("getRamCapacity").getReturnType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredMethod("setRamCapacity", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("setRamCapacity", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("setRamCapacity", double.class).getModifiers()));
            assertEquals(void.class, ComputeCluster.class.getDeclaredMethod("setRamCapacity", double.class).getReturnType());

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredMethod("getNextMaintenanceDate").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("getNextMaintenanceDate").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("getNextMaintenanceDate").getModifiers()));
            assertEquals(LocalDate.class, ComputeCluster.class.getDeclaredMethod("getNextMaintenanceDate").getReturnType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredMethod("setNextMaintenanceDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("setNextMaintenanceDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("setNextMaintenanceDate", LocalDate.class).getModifiers()));
            assertEquals(void.class, ComputeCluster.class.getDeclaredMethod("setNextMaintenanceDate", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(ComputeCluster.class.getDeclaredMethod("isGPUEnabled").getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("isGPUEnabled").getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("isGPUEnabled").getModifiers()));
            assertEquals(boolean.class, ComputeCluster.class.getDeclaredMethod("isGPUEnabled").getReturnType());

            assertTrue(Modifier.isPrivate(ComputeCluster.class.getDeclaredMethod("setGPUEnabled", boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(ComputeCluster.class.getDeclaredMethod("setGPUEnabled", boolean.class).getModifiers()));
            assertFalse(Modifier.isFinal(ComputeCluster.class.getDeclaredMethod("setGPUEnabled", boolean.class).getModifiers()));
            assertEquals(void.class, ComputeCluster.class.getDeclaredMethod("setGPUEnabled", boolean.class).getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testCreateComputeCluster() {
        ComputeCluster cluster = new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true);

        assertEquals("cluster-1", cluster.getName());
        assertEquals(4, cluster.getNumNodes());
        assertEquals(1, cluster.getNumGPUs());
        assertEquals(16.0, cluster.getRamCapacity());
        assertEquals(LocalDate.now().plusDays(1), cluster.getNextMaintenanceDate());
        assertTrue(cluster.isGPUEnabled());

        cluster = new ComputeCluster("cluster-2", 8, 4, 32.0, LocalDate.now().plusMonths(5), false);

        assertEquals("cluster-2", cluster.getName());
        assertEquals(8, cluster.getNumNodes());
        assertEquals(4, cluster.getNumGPUs());
        assertEquals(32.0, cluster.getRamCapacity());
        assertEquals(LocalDate.now().plusMonths(5), cluster.getNextMaintenanceDate());
        assertFalse(cluster.isGPUEnabled());
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Name")
    public void testCreateComputeClusterName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new ComputeCluster(null, 4, 1, 16.0, LocalDate.now().plusDays(1), true));
        assertEquals("[ERROR] The name cannot be null and has to start with 'cluster-' followed by a number", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("", 4, 1, 16.0, LocalDate.now().plusDays(1), true));
        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("noname", 4, 1, 16.0, LocalDate.now().plusDays(1), true));
        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster", 4, 1, 16.0, LocalDate.now().plusDays(1), true));
        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-", 4, 1, 16.0, LocalDate.now().plusDays(1), true));
        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-a", 4, 1, 16.0, LocalDate.now().plusDays(1), true));
        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1a", 4, 1, 16.0, LocalDate.now().plusDays(1), true));
        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1-", 4, 1, 16.0, LocalDate.now().plusDays(1), true));
        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true));

        ComputeCluster cluster = new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNotNull(cluster);
        assertEquals("cluster-1", cluster.getName());

        cluster = new ComputeCluster("cluster-123", 4, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNotNull(cluster);
        assertEquals("cluster-123", cluster.getName());

        cluster = new ComputeCluster("cluster-01", 4, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNotNull(cluster);
        assertEquals("cluster-01", cluster.getName());
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - Number of nodes")
    public void testCreateComputeClusterNumNodes() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", 3, 1, 16.0, LocalDate.now().plusDays(1), true));
        assertEquals("[ERROR] The number of nodes has to be greater or equal to 4", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", 0, 1, 16.0, LocalDate.now().plusDays(1), true));
        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", -1, 1, 16.0, LocalDate.now().plusDays(1), true));
        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", 3, 1, 16.0, LocalDate.now().plusDays(1), true));

        ComputeCluster cluster = new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNotNull(cluster);
        assertEquals(4, cluster.getNumNodes());

        cluster = new ComputeCluster("cluster-1", 8, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNotNull(cluster);
        assertEquals(8, cluster.getNumNodes());
    }

    @Test
    @Order(7)
    @Tag("minimum")
    @DisplayName("Minimum - Number of GPUs")
    public void testCreateComputeClusterNumGPUs() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", 4, 0, 16.0, LocalDate.now().plusDays(1), true));
        assertEquals("[ERROR] The number of GPUs cannot be negative or zero", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", 4, -1, 16.0, LocalDate.now().plusDays(1), true));
        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", 4, 0, 16.0, LocalDate.now().plusDays(1), true));

        ComputeCluster cluster = new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNotNull(cluster);
        assertEquals(1, cluster.getNumGPUs());

        cluster = new ComputeCluster("cluster-1", 4, 4, 16.0, LocalDate.now().plusDays(1), true);
        assertNotNull(cluster);
        assertEquals(4, cluster.getNumGPUs());
    }

    @Test
    @Order(8)
    @Tag("minimum")
    @DisplayName("Minimum - RAM capacity")
    public void testCreateComputeClusterRamCapacity() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", 4, 1, 15.9, LocalDate.now().plusDays(1), true));
        assertEquals("[ERROR] The RAM capacity has to be greater or equal to 16 GB", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", 4, 1, 0.0, LocalDate.now().plusDays(1), true));
        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", 4, 1, -1.0, LocalDate.now().plusDays(1), true));
        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", 4, 1, 15.9, LocalDate.now().plusDays(1), true));

        ComputeCluster cluster = new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNotNull(cluster);
        assertEquals(16.0, cluster.getRamCapacity());

        cluster = new ComputeCluster("cluster-1", 4, 1, 32.0, LocalDate.now().plusDays(1), true);
        assertNotNull(cluster);
        assertEquals(32.0, cluster.getRamCapacity());
    }

    @Test
    @Order(9)
    @Tag("minimum")
    @DisplayName("Minimum - Next maintenance date")
    public void testCreateComputeClusterNextMaintenanceDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", 4, 1, 16.0, null, true));
        assertEquals("[ERROR] The next maintenance date cannot be null or in the past", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().minusDays(1), true));
        assertThrows(IllegalArgumentException.class, () -> new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().minusMonths(7), true));

        ComputeCluster cluster = new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNotNull(cluster);
        assertEquals(LocalDate.now().plusDays(1), cluster.getNextMaintenanceDate());

        cluster = new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().plusMonths(1), true);
        assertNotNull(cluster);
        assertEquals(LocalDate.now().plusMonths(1), cluster.getNextMaintenanceDate());

        cluster = new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now(), true);
        assertNotNull(cluster);
        assertEquals(LocalDate.now(), cluster.getNextMaintenanceDate());
    }

    @Test
    @Order(10)
    @Tag("minimum")
    @DisplayName("Minimum - GPU enabled")
    public void testCreateComputeClusterGPUEnabled() {
        ComputeCluster cluster = new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNotNull(cluster);
        assertTrue(cluster.isGPUEnabled());

        cluster = new ComputeCluster("cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), false);
        assertNotNull(cluster);
        assertFalse(cluster.isGPUEnabled());
    }

}
