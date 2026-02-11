package assessment;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class UserClient {
    private static final String URL = "https://reqres.in/api/users?page=1";

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    // Requirement #2: query first page and return List<UserDTO>
    public List<UserDTO> fetchFirstPageUsers() throws Exception {
        String apiKey = System.getenv("REQRES_API_KEY"); // optional

        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .GET();

        if (apiKey != null && !apiKey.isBlank()) {
            builder.header("x-api-key", apiKey);
        }

        HttpResponse<String> resp = httpClient.send(builder.build(), HttpResponse.BodyHandlers.ofString());
        if (resp.statusCode() != 200) {
            throw new RuntimeException("HTTP " + resp.statusCode() + ": " + resp.body());
        }

        UsersPageResponse parsed = mapper.readValue(resp.body(), UsersPageResponse.class);
        return parsed.getData();
    }

    // Requirement #3: main calls method and prints firstName + lastName
    public static void main(String[] args) throws Exception {
        UserClient client = new UserClient();
        List<UserDTO> users = client.fetchFirstPageUsers();

        for (UserDTO u : users) {
            System.out.println(u.getFirstName() + " " + u.getLastName());
        }
    }
}
