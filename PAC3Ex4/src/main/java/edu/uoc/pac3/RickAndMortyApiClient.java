package edu.uoc.pac3;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class RickAndMortyApiClient {

    private static final String BASE_URL = "https://rickandmortyapi.com/api/character";

    public static String fetchCharactersJsonByPage(int page) {
        try {
            // hacemos la web con los parámetros
            String urlString = BASE_URL + "?page=" + page;
            URI uri = new URI(urlString);
            URL url = uri.toURL();

            // parámetros de conexxión
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); // 5 seconds timeout
            connection.setReadTimeout(5000);

            // response code
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                connection.disconnect();
                return null;
            }

            // read response
            StringBuilder response = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }

            connection.disconnect();
            return response.toString();

        } catch (Exception e) {
            return null;
        }
    }

    public static String[] getCharacterNamesByPage(int page) {
        String jsonResponse = fetchCharactersJsonByPage(page);
        if (jsonResponse == null) {
            return new String[0];
        }

        try {
            // COPIAR json
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONArray results = jsonObject.getJSONArray("results");

            // OBTENER nombres
            String[] names = new String[results.length()];
            for (int i = 0; i < results.length(); i++) {
                JSONObject character = results.getJSONObject(i);
                names[i] = character.getString("name");
            }

            return names;

        } catch (Exception e) {
            return new String[0];
        }
    }
}