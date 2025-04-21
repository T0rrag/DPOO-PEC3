package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AIPlatformTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(11, AIPlatform.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(AIPlatform.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(AIPlatform.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(AIPlatform.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertEquals(String.class, AIPlatform.class.getDeclaredField("INVALID_NAME").getType());
            assertEquals("[ERROR] The name cannot be null and it can only contain characters and spaces", AIPlatform.INVALID_NAME);

            assertTrue(Modifier.isPublic(AIPlatform.class.getDeclaredField("INVALID_DESCRIPTION").getModifiers()));
            assertTrue(Modifier.isStatic(AIPlatform.class.getDeclaredField("INVALID_DESCRIPTION").getModifiers()));
            assertTrue(Modifier.isFinal(AIPlatform.class.getDeclaredField("INVALID_DESCRIPTION").getModifiers()));
            assertEquals(String.class, AIPlatform.class.getDeclaredField("INVALID_DESCRIPTION").getType());
            assertEquals("[ERROR] The description cannot be null, empty or blank", AIPlatform.INVALID_DESCRIPTION);

            assertTrue(Modifier.isPublic(AIPlatform.class.getDeclaredField("INVALID_DOMAIN").getModifiers()));
            assertTrue(Modifier.isStatic(AIPlatform.class.getDeclaredField("INVALID_DOMAIN").getModifiers()));
            assertTrue(Modifier.isFinal(AIPlatform.class.getDeclaredField("INVALID_DOMAIN").getModifiers()));
            assertEquals(String.class, AIPlatform.class.getDeclaredField("INVALID_DOMAIN").getType());
            assertEquals("[ERROR] The domain cannot be null and must be a valid domain: 'www.example.com'", AIPlatform.INVALID_DOMAIN);

            assertTrue(Modifier.isPublic(AIPlatform.class.getDeclaredField("INVALID_RELEASE_DATE").getModifiers()));
            assertTrue(Modifier.isStatic(AIPlatform.class.getDeclaredField("INVALID_RELEASE_DATE").getModifiers()));
            assertTrue(Modifier.isFinal(AIPlatform.class.getDeclaredField("INVALID_RELEASE_DATE").getModifiers()));
            assertEquals(String.class, AIPlatform.class.getDeclaredField("INVALID_RELEASE_DATE").getType());
            assertEquals("[ERROR] The release date cannot be null or in the future", AIPlatform.INVALID_RELEASE_DATE);

            assertTrue(Modifier.isPrivate(AIPlatform.class.getDeclaredField("MAX_CONCURRENT_USERS").getModifiers()));
            assertTrue(Modifier.isStatic(AIPlatform.class.getDeclaredField("MAX_CONCURRENT_USERS").getModifiers()));
            assertTrue(Modifier.isFinal(AIPlatform.class.getDeclaredField("MAX_CONCURRENT_USERS").getModifiers()));
            assertEquals(int.class, AIPlatform.class.getDeclaredField("MAX_CONCURRENT_USERS").getType());

            assertTrue(Modifier.isPrivate(AIPlatform.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, AIPlatform.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(AIPlatform.class.getDeclaredField("description").getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredField("description").getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredField("description").getModifiers()));
            assertEquals(String.class, AIPlatform.class.getDeclaredField("description").getType());

            assertTrue(Modifier.isPrivate(AIPlatform.class.getDeclaredField("domain").getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredField("domain").getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredField("domain").getModifiers()));
            assertEquals(String.class, AIPlatform.class.getDeclaredField("domain").getType());

            assertTrue(Modifier.isPrivate(AIPlatform.class.getDeclaredField("releaseDate").getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredField("releaseDate").getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredField("releaseDate").getModifiers()));
            assertEquals(LocalDate.class, AIPlatform.class.getDeclaredField("releaseDate").getType());

            assertTrue(Modifier.isPrivate(AIPlatform.class.getDeclaredField("maxConcurrentUsers").getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredField("maxConcurrentUsers").getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredField("maxConcurrentUsers").getModifiers()));
            assertEquals(int.class, AIPlatform.class.getDeclaredField("maxConcurrentUsers").getType());

            assertTrue(Modifier.isPrivate(AIPlatform.class.getDeclaredField("cluster").getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredField("cluster").getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredField("cluster").getModifiers()));
            assertEquals(ComputeCluster.class, AIPlatform.class.getDeclaredField("cluster").getType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        assertEquals(2, AIPlatform.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(AIPlatform.class.getDeclaredConstructor(String.class, String.class, String.class, LocalDate.class, int.class).getModifiers()));
            assertTrue(Modifier.isPublic(AIPlatform.class.getDeclaredConstructor(String.class, String.class, String.class, LocalDate.class, int.class, String.class, int.class, int.class, double.class, LocalDate.class, boolean.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(6, Arrays.stream(AIPlatform.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());
        assertEquals(6, Arrays.stream(AIPlatform.class.getDeclaredMethods()).filter(m -> Modifier.isPrivate(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(AIPlatform.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, AIPlatform.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPrivate(AIPlatform.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, AIPlatform.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(AIPlatform.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredMethod("getDescription").getModifiers()));
            assertEquals(String.class, AIPlatform.class.getDeclaredMethod("getDescription").getReturnType());

            assertTrue(Modifier.isPrivate(AIPlatform.class.getDeclaredMethod("setDescription", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredMethod("setDescription", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredMethod("setDescription", String.class).getModifiers()));
            assertEquals(void.class, AIPlatform.class.getDeclaredMethod("setDescription", String.class).getReturnType());

            assertTrue(Modifier.isPublic(AIPlatform.class.getDeclaredMethod("getDomain").getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredMethod("getDomain").getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredMethod("getDomain").getModifiers()));
            assertEquals(String.class, AIPlatform.class.getDeclaredMethod("getDomain").getReturnType());

            assertTrue(Modifier.isPrivate(AIPlatform.class.getDeclaredMethod("setDomain", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredMethod("setDomain", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredMethod("setDomain", String.class).getModifiers()));
            assertEquals(void.class, AIPlatform.class.getDeclaredMethod("setDomain", String.class).getReturnType());

            assertTrue(Modifier.isPublic(AIPlatform.class.getDeclaredMethod("getReleaseDate").getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredMethod("getReleaseDate").getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredMethod("getReleaseDate").getModifiers()));
            assertEquals(LocalDate.class, AIPlatform.class.getDeclaredMethod("getReleaseDate").getReturnType());

            assertTrue(Modifier.isPrivate(AIPlatform.class.getDeclaredMethod("setReleaseDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredMethod("setReleaseDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredMethod("setReleaseDate", LocalDate.class).getModifiers()));
            assertEquals(void.class, AIPlatform.class.getDeclaredMethod("setReleaseDate", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(AIPlatform.class.getDeclaredMethod("getMaxConcurrentUsers").getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredMethod("getMaxConcurrentUsers").getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredMethod("getMaxConcurrentUsers").getModifiers()));
            assertEquals(int.class, AIPlatform.class.getDeclaredMethod("getMaxConcurrentUsers").getReturnType());

            assertTrue(Modifier.isPrivate(AIPlatform.class.getDeclaredMethod("setMaxConcurrentUsers", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredMethod("setMaxConcurrentUsers", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredMethod("setMaxConcurrentUsers", int.class).getModifiers()));
            assertEquals(void.class, AIPlatform.class.getDeclaredMethod("setMaxConcurrentUsers", int.class).getReturnType());

            assertTrue(Modifier.isPublic(AIPlatform.class.getDeclaredMethod("getCluster").getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredMethod("getCluster").getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredMethod("getCluster").getModifiers()));
            assertEquals(ComputeCluster.class, AIPlatform.class.getDeclaredMethod("getCluster").getReturnType());

            assertTrue(Modifier.isPrivate(AIPlatform.class.getDeclaredMethod("setCluster", String.class, int.class, int.class, double.class, LocalDate.class, boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(AIPlatform.class.getDeclaredMethod("setCluster", String.class, int.class, int.class, double.class, LocalDate.class, boolean.class).getModifiers()));
            assertFalse(Modifier.isFinal(AIPlatform.class.getDeclaredMethod("setCluster", String.class, int.class, int.class, double.class, LocalDate.class, boolean.class).getModifiers()));
            assertEquals(void.class, AIPlatform.class.getDeclaredMethod("setCluster", String.class, int.class, int.class, double.class, LocalDate.class, boolean.class).getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("advanced")
    @DisplayName("Advanced - Valid parameters")
    public void checkValidParameters() {
        AIPlatform platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94);
        assertEquals("Uoc supercomputing center", platform.getName());
        assertEquals("Supercomputing center of Universitat Oberta de Catalunya", platform.getDescription());
        assertEquals("www.uoc.edu", platform.getDomain());
        assertEquals(LocalDate.now(), platform.getReleaseDate());
        assertEquals(94, platform.getMaxConcurrentUsers());
        assertNull(platform.getCluster());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, "cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertEquals("Uoc supercomputing center", platform.getName());
        assertEquals("Supercomputing center of Universitat Oberta de Catalunya", platform.getDescription());
        assertEquals("www.uoc.edu", platform.getDomain());
        assertEquals(LocalDate.now(), platform.getReleaseDate());
        assertEquals(94, platform.getMaxConcurrentUsers());
        assertNotNull(platform.getCluster());
        assertEquals("cluster-1", platform.getCluster().getName());
        assertEquals(4, platform.getCluster().getNumNodes());
        assertEquals(1, platform.getCluster().getNumGPUs());
        assertEquals(16.0, platform.getCluster().getRamCapacity());
        assertEquals(LocalDate.now().plusDays(1), platform.getCluster().getNextMaintenanceDate());
        assertTrue(platform.getCluster().isGPUEnabled());
    }

    @Test
    @Order(5)
    @Tag("advanced")
    @DisplayName("Advanced - Name")
    public void testCreateAIPlatformName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new AIPlatform(null, "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94));
        assertEquals("[ERROR] The name cannot be null and it can only contain characters and spaces", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("123", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("Uoc supercomputer 1994", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("Uoc supercomputer!.,?", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94));

        AIPlatform platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94);
        assertEquals("Uoc supercomputing center", platform.getName());

        platform = new AIPlatform("uoc supercomputing center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94);
        assertEquals("Uoc supercomputing center", platform.getName());

        platform = new AIPlatform("UOC SUPERCOMPUTING CENTER", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94);
        assertEquals("Uoc supercomputing center", platform.getName());

        platform = new AIPlatform("  UOC Supercomputing Center  ", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94);
        assertEquals("Uoc supercomputing center", platform.getName());
    }

    @Test
    @Order(6)
    @Tag("advanced")
    @DisplayName("Advanced - Description")
    public void testCreateAIPlatformDescription() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", null, "www.uoc.edu", LocalDate.now(), 94));
        assertEquals("[ERROR] The description cannot be null, empty or blank", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "", "www.uoc.edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", " ", "www.uoc.edu", LocalDate.now(), 94));

        AIPlatform platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94);
        assertEquals("Supercomputing center of Universitat Oberta de Catalunya", platform.getDescription());

        platform = new AIPlatform("UOC Supercomputing Center", "  Supercomputing center of Universitat Oberta de Catalunya  ", "www.uoc.edu", LocalDate.now(), 94);
        assertEquals("Supercomputing center of Universitat Oberta de Catalunya", platform.getDescription());
    }

    @Test
    @Order(7)
    @Tag("advanced")
    @DisplayName("Advanced - Domain")
    public void testCreateAIPlatformDomain() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", null, LocalDate.now(), 94));
        assertEquals("[ERROR] The domain cannot be null and must be a valid domain: 'www.example.com'", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", " ", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.com/", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "uoc..edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "uoc-.edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.c", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.-uoc.edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc@edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc..barcelona", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.barcelona.", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc!edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc#edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc$edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc%edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc^edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc&edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc*edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc(edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc)edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc=edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc+edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc,edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc<edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc>edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc|edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "WWW.uoc.edu", LocalDate.now(), 94));
        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.EDU", LocalDate.now(), 94));

        AIPlatform platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94);
        assertEquals("www.uoc.edu", platform.getDomain());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "uoc.edu", LocalDate.now(), 94);
        assertEquals("uoc.edu", platform.getDomain());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.supercomputing-center.barcelona", LocalDate.now(), 94);
        assertEquals("www.supercomputing-center.barcelona", platform.getDomain());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "supercomputing-center.barcelona", LocalDate.now(), 94);
        assertEquals("supercomputing-center.barcelona", platform.getDomain());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "subdomain.uoc.edu", LocalDate.now(), 94);
        assertEquals("subdomain.uoc.edu", platform.getDomain());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "sub-domain.uoc.edu", LocalDate.now(), 94);
        assertEquals("sub-domain.uoc.edu", platform.getDomain());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "research.lab.uoc.edu", LocalDate.now(), 94);
        assertEquals("research.lab.uoc.edu", platform.getDomain());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "portal.supercomputing-center.barcelona", LocalDate.now(), 94);
        assertEquals("portal.supercomputing-center.barcelona", platform.getDomain());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.ac", LocalDate.now(), 94);
        assertEquals("www.uoc.ac", platform.getDomain());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "my-uoc-portal.org", LocalDate.now(), 94);
        assertEquals("my-uoc-portal.org", platform.getDomain());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "intranet.university.edu", LocalDate.now(), 94);
        assertEquals("intranet.university.edu", platform.getDomain());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "conference.uoc.io", LocalDate.now(), 94);
        assertEquals("conference.uoc.io", platform.getDomain());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "support.uoc.edu", LocalDate.now(), 94);
        assertEquals("support.uoc.edu", platform.getDomain());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "super.uoc.com", LocalDate.now(), 94);
        assertEquals("super.uoc.com", platform.getDomain());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "lab.research-uoc.org", LocalDate.now(), 94);
        assertEquals("lab.research-uoc.org", platform.getDomain());
    }

    @Test
    @Order(8)
    @Tag("advanced")
    @DisplayName("Advanced - Release date")
    public void testCreateAIPlatformReleaseDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", null, 94));
        assertEquals("[ERROR] The release date cannot be null or in the future", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now().plusDays(1), 94));

        AIPlatform platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94);
        assertEquals(LocalDate.now(), platform.getReleaseDate());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now().minusDays(1), 94);
        assertEquals(LocalDate.now().minusDays(1), platform.getReleaseDate());
    }

    @Test
    @Order(9)
    @Tag("advanced")
    @DisplayName("Advanced - Max concurrent users")
    public void testCreateAIPlatformMaxConcurrentUsers() {
        AIPlatform platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 1);
        assertEquals(1, platform.getMaxConcurrentUsers());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 100);
        assertEquals(100, platform.getMaxConcurrentUsers());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 50);
        assertEquals(50, platform.getMaxConcurrentUsers());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), -1);
        assertEquals(1, platform.getMaxConcurrentUsers());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 0);
        assertEquals(1, platform.getMaxConcurrentUsers());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 101);
        assertEquals(100, platform.getMaxConcurrentUsers());
    }

    @Test
    @Order(10)
    @Tag("special")
    @DisplayName("Special - Cluster")
    public void testCreateAIPlatformCluster() {
        AIPlatform platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94);
        assertNull(platform.getCluster());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, null, 4, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNull(platform.getCluster());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, "", 4, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNull(platform.getCluster());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, "noname", 4, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNull(platform.getCluster());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, "cluster-", 4, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNull(platform.getCluster());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, "cluster-1a", 4, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNull(platform.getCluster());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, "cluster-1", 3, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNull(platform.getCluster());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, "cluster-1", 0, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNull(platform.getCluster());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, "cluster-1", 4, 0, 16.0, LocalDate.now().plusDays(1), true);
        assertNull(platform.getCluster());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, "cluster-1", 4, -1, 16.0, LocalDate.now().plusDays(1), true);
        assertNull(platform.getCluster());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, "cluster-1", 4, 1, 15.9, LocalDate.now().plusDays(1), true);
        assertNull(platform.getCluster());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, "cluster-1", 4, 1, 0.0, LocalDate.now().plusDays(1), true);
        assertNull(platform.getCluster());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, "cluster-1", 4, 1, 16.0, null, true);
        assertNull(platform.getCluster());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, "cluster-1", 4, 1, 16.0, LocalDate.now().minusDays(1), true);
        assertNull(platform.getCluster());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, "cluster-1", 4, 1, 16.0, LocalDate.now().plusDays(1), true);
        assertNotNull(platform.getCluster());
        assertEquals("cluster-1", platform.getCluster().getName());
        assertEquals(4, platform.getCluster().getNumNodes());
        assertEquals(1, platform.getCluster().getNumGPUs());
        assertEquals(16.0, platform.getCluster().getRamCapacity());
        assertEquals(LocalDate.now().plusDays(1), platform.getCluster().getNextMaintenanceDate());
        assertTrue(platform.getCluster().isGPUEnabled());

        platform = new AIPlatform("UOC Supercomputing Center", "Supercomputing center of Universitat Oberta de Catalunya", "www.uoc.edu", LocalDate.now(), 94, "cluster-2", 8, 2, 32.0, LocalDate.now().plusDays(2), false);
        assertNotNull(platform.getCluster());
        assertEquals("cluster-2", platform.getCluster().getName());
        assertEquals(8, platform.getCluster().getNumNodes());
        assertEquals(2, platform.getCluster().getNumGPUs());
        assertEquals(32.0, platform.getCluster().getRamCapacity());
        assertEquals(LocalDate.now().plusDays(2), platform.getCluster().getNextMaintenanceDate());
        assertFalse(platform.getCluster().isGPUEnabled());
    }

}
