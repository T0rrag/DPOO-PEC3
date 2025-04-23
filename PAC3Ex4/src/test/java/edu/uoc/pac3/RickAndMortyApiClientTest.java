package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RickAndMortyApiClientTest {

    private static final int NUM_PAGES = 3;

    private static final String[][] KEY_NAMES = {
            {"Rick Sanchez", "Morty Smith", "Summer Smith"},
            {"Aqua Morty", "Baby Legs", "Beth Sanchez"},
            {"Big Head Morty", "Birdperson", "Blim Blam"}
    };

    @Test
    @Order(1)
    @DisplayName("fetchCharactersJson")
    public void testFetchCharactersJsonByPage() {
        for (int i = 0; i < NUM_PAGES; i++) {
            String json = RickAndMortyApiClient.fetchCharactersJsonByPage(i + 1);

            assertNotNull(json);
            assertTrue(json.contains("results"));

            for (String name : KEY_NAMES[i]) {
                assertTrue(json.contains(name), "Expected name '" + name + "' not found in JSON response");
            }
        }
    }

    @Test
    @Order(2)
    @DisplayName("getCharacterNamesByPage")
    public void getCharacterNamesByPage() {
        for (int i = 0; i < NUM_PAGES; i++) {
            String[] names = RickAndMortyApiClient.getCharacterNamesByPage(i + 1);

            assertNotNull(names);
            List<String> nameList = Arrays.asList(names);

            for (String expected : KEY_NAMES[i]) {
                assertTrue(nameList.contains(expected), "Expected name '" + expected + "' not found in character names");
            }
        }
    }

}
